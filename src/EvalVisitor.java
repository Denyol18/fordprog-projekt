import java.util.*;

/**
 * Az {@code EvalVisitor} osztály a {@link PolynomialBaseVisitor} osztály gyerekosztálya azzal a célal, hogy
 * a legenerált kifejezéseket kezelje. Változó deklarációkat kezel, értékadásokat,
 * kiértékeléseket, és műveleteket polinomokon és számokon.
 */
public class EvalVisitor extends PolynomialBaseVisitor<Object> {

    /**
     * Az azonosítójukkal deklarált polinom változókat tároló Map.
     */
    private final Map<String, Polynomial> polynomials = new HashMap<>();
    /**
     * Az azonosítójukkal deklarált szám változókat tároló Map.
     */
    private final Map<String, Double> numbers = new HashMap<>();

    /**
     * Meglátogat és kiértékel egy utasítást, pontosabban deklarációkat, értékadásokat és megjelenítéseket.
     */
    @Override
    public Object visitStatement(PolynomialParser.StatementContext ctx) {
        if (ctx.getText().startsWith("polynom")) {
            for (var id : ctx.ID()) {
                polynomials.put(id.getText(), new Polynomial());
            }
        } else if (ctx.getText().startsWith("number")) {
            for (var id : ctx.ID()) {
                numbers.put(id.getText(), 0.0);
            }
        } else if (ctx.getText().startsWith("show")) {
            Object value = visit(ctx.expr());
            System.out.println(value);
        } else if (ctx.ID() != null && ctx.expr() != null) {
            String name = ctx.ID(0).getText();
            Object value = visit(ctx.expr());

            if (value instanceof Polynomial) {
                if (!polynomials.containsKey(name)) {
                    throw new RuntimeException("Hibás hozzárendelés: A(z) '" + name + "' polinom nincs deklarálva.");
                }
                polynomials.put(name, (Polynomial) value);
            } else if (value instanceof Double) {
                if (!numbers.containsKey(name)) {
                    throw new RuntimeException("Hibás hozzárendelés: A(z) '" + name + "' szám nincs deklarálva.");
                }
                numbers.put(name, (Double) value);
            } else {
                throw new RuntimeException("Ismeretlen érték típusa a hozzárendeléshez: " + value);
            }
        }
        return null;
    }

    /**
     * Egy deklarált változó értékét adja vissza.
     */
    @Override
    public Object visitVarExpr(PolynomialParser.VarExprContext ctx) {
        String name = ctx.ID().getText();
        if (polynomials.containsKey(name)) return polynomials.get(name);
        if (numbers.containsKey(name)) return numbers.get(name);
        throw new RuntimeException("Ismeretlen változó: " + name);
    }

    /**
     * Egy numerikus literált ad vissza {@code Double}-ként.
     */
    @Override
    public Object visitNumExpr(PolynomialParser.NumExprContext ctx) {
        return Double.parseDouble(ctx.NUM().getText());
    }

    /**
     * Kiértékeli a zárójelbe tett kifejezést.
     */
    @Override
    public Object visitParenExpr(PolynomialParser.ParenExprContext ctx) {
        return visit(ctx.expr());
    }

    /**
     * Delegálja a polinomiális kifejezés kiértékelését.
     */
    @Override
    public Object visitPolynomialExpr(PolynomialParser.PolynomialExprContext ctx) {
        return visit(ctx.polynomial());
    }

    /**
     * Elemzi és létrehoz egy {@code Polynomial}-t a PolynomialContext-ből.
     */
    @Override
    public Object visitPolynomial(PolynomialParser.PolynomialContext ctx) {
        List<Term> terms = new ArrayList<>();

        // Első tag mindig pozitív
        Term firstTerm = visitPolyTerm(ctx.polyTerm(0));
        terms.add(firstTerm);

        int counter = 0;
        // Minden következő tag előtt van egy műveleti jel
        for (int i = 1; i < ctx.polyTerm().size(); i++) {
            Term t = visitPolyTerm(ctx.polyTerm(i));
            String op = ctx.getChild(counter+2).getText(); // műveleti jel: '+' vagy '-'

            if (op.equals("-")) {
                t.coeff *= -1; // ha '-' volt, akkor negáljuk az együtthatót
            }
            terms.add(t);
            counter += 2;
        }

        return new Polynomial(terms);
    }

    /**
     * Elemzi és létrehoz egy {@code Term} objektumot a PolyTermContext-ből.
     */
    @Override
    public Term visitPolyTerm(PolynomialParser.PolyTermContext ctx) {
        double coeff = 1.0;
        int exp = 0;
        String text = ctx.getText();

        if (!text.contains("x")) {
            // Pure constant term
            if (ctx.NUM().size() == 1) {
                coeff = Double.parseDouble(ctx.NUM(0).getText());
            } else if (ctx.ID() != null) {
                String id = ctx.ID().getText();
                if (!numbers.containsKey(id)) {
                    throw new RuntimeException("Ismeretlen konstans változó: " + id);
                }
                coeff = numbers.get(id);
            }
            exp = 0;
        } else {
            // Term includes x
            if (ctx.NUM().size() == 2) {
                // e.g., 2.5 x^2 or b x^2
                String coeffStr = ctx.getChild(0).getText();
                coeff = resolveCoefficient(coeffStr);
                exp = (int) Double.parseDouble(ctx.NUM(1).getText());
            } else if (ctx.NUM().size() == 1) {
                if (text.contains("^")) {
                    // e.g., x^2 or b x^2
                    if (text.startsWith("x")) {
                        coeff = 1.0;
                        exp = (int) Double.parseDouble(ctx.NUM(0).getText());
                    } else {
                        String coeffStr = ctx.getChild(0).getText();
                        coeff = resolveCoefficient(coeffStr);
                        exp = (int) Double.parseDouble(ctx.NUM(0).getText());
                    }
                } else {
                    // e.g., 3 x or b x
                    String coeffStr = ctx.getChild(0).getText();
                    coeff = resolveCoefficient(coeffStr);
                    exp = 1;
                }
            } else if (ctx.NUM().isEmpty() && ctx.ID() != null && text.contains("x")) {
                // e.g., a x
                String coeffStr = ctx.getChild(0).getText();
                coeff = resolveCoefficient(coeffStr);
                exp = 1;
            } else {
                // e.g., just x or x^2
                coeff = 1.0;
                exp = text.contains("^") ? Integer.parseInt(text.split("\\^")[1]) : 1;
            }
        }

        return new Term(coeff, exp);
    }

    /**
     * Kiértékeli a bináris összeadás vagy kivonás kifejezéseket.
     */
    @Override
    public Object visitAddSubExpr(PolynomialParser.AddSubExprContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));
        return applyBinaryOp(left, right, ctx.op.getText());
    }

    /**
     * Kiértékeli a bináris szorzás, osztás vagy modulo kifejezéseket.
     */
    @Override
    public Object visitMulDivModExpr(PolynomialParser.MulDivModExprContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));
        return applyBinaryOp(left, right, ctx.op.getText());
    }

    /**
     * Egy polinomot egy adott számértékkel értékel ki.
     */
    @Override
    public Object visitEvalExpr(PolynomialParser.EvalExprContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));

        if (!(left instanceof Polynomial)) {
            throw new RuntimeException("Kiértékelni csak polinomot lehet.");
        }
        double val = (right instanceof Double) ? (Double) right : 0;
        return ((Polynomial) left).evaluate(val);
    }

    /**
     * Felold egy együtthatót egy karakterlánc tokenből, szükség esetén változó értékeket keres.
     *
     * @param token A feloldandó együttható token.
     * @return Az együttható számértéke.
     */
    private double resolveCoefficient(String token) {
        if (token.matches("\\d+(\\.\\d+)?")) {
            return Double.parseDouble(token);
        } else if (numbers.containsKey(token)) {
            return numbers.get(token);
        } else {
            throw new RuntimeException("Ismeretlen együttható vagy változó: " + token);
        }
    }

    /**
     * Bináris műveletet alkalmaz két operandus között (amik számok és polinomok).
     *
     * @param left bal oldali operandus.
     * @param right jobb oldali operandus.
     * @param op művelet szimbóluma.
     * @return az alkalmazott művelet eredménye.
     */
    private Object applyBinaryOp(Object left, Object right, String op) {
        if (left instanceof Polynomial || right instanceof Polynomial) {
            Polynomial l = (left instanceof Polynomial) ? (Polynomial) left : new Polynomial(List.of(new Term((Double) left, 0)));
            Polynomial r = (right instanceof Polynomial) ? (Polynomial) right : new Polynomial(List.of(new Term((Double) right, 0)));

            return switch (op) {
                case "+" -> l.add(r);
                case "-" -> l.subtract(r);
                case "*" -> l.multiply(r);
                case "/" -> l.divide(r);
                case "%" -> l.mod(r);
                default -> throw new RuntimeException("Ismeretlen operátor: " + op);
            };
        } else {
            double l = (Double) left;
            double r = (Double) right;
            return switch (op) {
                case "+" -> l + r;
                case "-" -> l - r;
                case "*" -> l * r;
                case "/" -> l / r;
                case "%" -> l % r;
                default -> throw new RuntimeException("Ismeretlen numerikus operátor: " + op);
            };
        }
    }
}