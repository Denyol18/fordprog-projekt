import java.util.*;

/**
 * Valós együtthatókkal és egész kitevőkkel rendelkező polinomot képvisel.
 * Támogatja az olyan aritmetikai műveleteket, mint az összeadás, kivonás, szorzás,
 * osztás (hányados), és modulo (maradék).
 * Polinomot még kiértékelni és stringként ábrázolni is lehet.
 */
public class Polynomial {
    /**
     * A polinom tagjait, azon belül azok együtthatóit valamint kitevőit tartalmazó Map.
     * A tagok tárolása a kitevők csökkenő sorrendjében történik.
     */
    private final Map<Integer, Double> terms = new TreeMap<>(Collections.reverseOrder());

    /**
     * Konstruktor, ami egy üres polinomot állít össze.
     */
    public Polynomial() {}

    /**
     * Konstruktor, ami egy polinomot hoz létre {@link Term} objektumok listájából.
     *
     * @param termList A polinom inicializálásához szükséges tagok listája.
     */
    public Polynomial(List<Term> termList) {
        for (Term t : termList) {
            addTerm(t);
        }
    }

    /**
     * Egyetlen tagot ad a polinomhoz, kombinálja az ugyanazzal a kitevővel rendelkező tagokat,
     * és eltávolítja a nullához közeli együtthatókat.
     *
     * @param t a tag amit hozzáadunk a polinomhoz.
     */
    private void addTerm(Term t) {
        terms.merge(t.exp, t.coeff, Double::sum);
        if (Math.abs(terms.get(t.exp)) < 1e-9) {
            terms.remove(t.exp);
        }
    }

    /**
     * Hozzáad egy polinomot az aktuális polinomhoz és visszaadja a művelet eredményét.
     *
     * @param other a polinom amit az aktuális polinomhoz hozzáadunk.
     * @return az eredményül kapott polinom.
     */
    public Polynomial add(Polynomial other) {
        Polynomial result = new Polynomial();
        this.terms.forEach((exp, coeff) -> result.terms.put(exp, coeff));
        other.terms.forEach((exp, coeff) -> result.terms.merge(exp, coeff, Double::sum));
        return result;
    }

    /**
     * Kivon egy polinomot az aktuális polinomból és visszaadja a művelet eredményét.
     *
     * @param other a polinom amit az aktuális polinomból vonunk ki.
     * @return az eredményül kapott polinom.
     */
    public Polynomial subtract(Polynomial other) {
        Polynomial neg = other.multiply(new Polynomial(List.of(new Term(-1, 0))));
        return this.add(neg);
    }

    /**
     * Összeszorozza az aktuális polinomot egy másikkal és visszaadja a művelet eredményét.
     *
     * @param other a másik polinom amivel az aktuálisat összeszorozzuk.
     * @return az eredményül kapott polinom.
     */
    public Polynomial multiply(Polynomial other) {
        Polynomial result = new Polynomial();
        for (var e1 : terms.entrySet()) {
            for (var e2 : other.terms.entrySet()) {
                int newExp = e1.getKey() + e2.getKey();
                double newCoeff = e1.getValue() * e2.getValue();
                result.terms.merge(newExp, newCoeff, Double::sum);
            }
        }
        return result;
    }

    /**
     * Az aktuális polinomot ossza el egy másikkal és visszadja a hányadost.
     *
     * @param divisor a másik polinom amivel osztunk.
     * @return a hányados polinomként.
     */
    public Polynomial divide(Polynomial divisor) {
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial(new ArrayList<>(this.toTermList()));

        while (!remainder.isZero() && remainder.getMaxExp() >= divisor.getMaxExp()) {
            int expDiff = remainder.getMaxExp() - divisor.getMaxExp();
            double coeffRatio = remainder.getLeadingCoeff() / divisor.getLeadingCoeff();

            Polynomial termPoly = new Polynomial();
            termPoly.terms.put(expDiff, coeffRatio);

            quotient = quotient.add(termPoly);
            Polynomial subtract = divisor.multiply(termPoly);
            remainder = remainder.subtract(subtract);
            remainder.cleanUpTinyCoefficients();
        }

        return quotient;
    }

    /**
     * Az aktuális polinomot ossza el egy másikkal és visszadja a maradékot.
     *
     * @param divisor a másik polinom amivel osztunk.
     * @return a maradék polinomként.
     */
    public Polynomial mod(Polynomial divisor) {
        Polynomial remainder = new Polynomial(new ArrayList<>(this.toTermList()));

        while (!remainder.isZero() && remainder.getMaxExp() >= divisor.getMaxExp()) {
            int expDiff = remainder.getMaxExp() - divisor.getMaxExp();
            double coeffRatio = remainder.getLeadingCoeff() / divisor.getLeadingCoeff();

            Polynomial termPoly = new Polynomial();
            termPoly.terms.put(expDiff, coeffRatio);

            Polynomial subtract = divisor.multiply(termPoly);
            remainder = remainder.subtract(subtract);
            remainder.cleanUpTinyCoefficients();
        }

        return remainder;
    }

    /**
     * Kiértékeli a polinomot egy adott x értéknél.
     *
     * @param x az érték, amelyen a polinomot ki kell értékelni.
     * @return a kiértékelés eredménye, a polinom összes tagja szummázva.
     */
    public double evaluate(double x) {
        return terms.entrySet().stream()
                .mapToDouble(e -> e.getValue() * Math.pow(x, e.getKey()))
                .sum();
    }

    /**
     * Lekéri a polinom legnagyobb kitevőjét (fokát).
     *
     * @return a maximális kitevő.
     */
    private int getMaxExp() {
        return terms.keySet().iterator().next();
    }

    /**
     * Lekéri a vezető együtthatót, azaz a legmagasabb fokú tag együtthatóját.
     *
     * @return a vezető együttható.
     */
    private double getLeadingCoeff() {
        return terms.values().iterator().next();
    }

    /**
     * Ellenőrzi, hogy a polinom nulla-e vagy gyakorlatilag nulla (minden együttható közel 0).
     *
     * @return igaz, ha a polinom nulla, egyébként hamis.
     */
    public boolean isZero() {
        return terms.isEmpty() || terms.values().stream().allMatch(coeff -> Math.abs(coeff) < 1e-9);
    }

    /**
     * Törli azokat a tagokat, amelyek együtthatóinak értéke közel 0.
     */
    public void cleanUpTinyCoefficients() {
        terms.entrySet().removeIf(entry -> Math.abs(entry.getValue()) < 1e-9);
    }

    /**
     * Átalakítja a polinomot egy {@link Term} objektumokból álló listává.
     *
     * @return a polinomot reprezentáló tagokból álló lista.
     */
    private List<Term> toTermList() {
        List<Term> list = new ArrayList<>();
        for (var e : terms.entrySet()) {
            list.add(new Term(e.getValue(), e.getKey()));
        }
        return list;
    }

    /**
     * A polinom stringes reprezentációját adja vissza szabványos matematikai jelöléssel.
     *
     * @return string ami a polinomot reprezentálja.
     */
    @Override
    public String toString() {
        if (terms.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        for (var e : terms.entrySet()) {
            double coeff = e.getValue();
            int exp = e.getKey();

            if (Math.abs(coeff) < 1e-9) continue;

            if (sb.length() > 0) sb.append(coeff >= 0 ? "+" : "");

            if (exp == 0) {
                sb.append(coeff);
            } else {
                if (Math.abs(coeff - 1.0) > 1e-9 && Math.abs(coeff + 1.0) > 1e-9) {
                    sb.append(coeff);
                } else if (Math.abs(coeff + 1.0) < 1e-9) {
                    sb.append("-");
                }

                sb.append("x");
                if (exp != 1) {
                    sb.append("^").append(exp);
                }
            }
        }
        return sb.toString();
    }
}