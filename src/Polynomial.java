import java.util.*;

/**
 * Valós együtthatókkal és egész kitevőkkel rendelkező tagokból álló polinomot ír le.
 * Támogatja az olyan aritmetikai műveleteket, mint az összeadás, kivonás, szorzás,
 * osztás (hányados), és modulo (maradék).
 * Ezeken kívül még kiértékelni és stringként ábrázolni is lehet a polinomot.
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
        Polynomial result = new Polynomial();   // Az eredményt egy új polinom példányként kezeljük.
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
        // A paraméterben kapott polinomot beszorozzuk -1-el:
        Polynomial neg = other.multiply(new Polynomial(List.of(new Term(-1, 0))));
        return this.add(neg);   // Majd a negált polinomot hozzáadjuk az aktuálishoz.
    }

    /**
     * Összeszorozza az aktuális polinomot egy másikkal és visszaadja a művelet eredményét.
     *
     * @param other a másik polinom amivel az aktuálisat összeszorozzuk.
     * @return az eredményül kapott polinom.
     */
    public Polynomial multiply(Polynomial other) {
        Polynomial result = new Polynomial();   // Az eredményt egy új polinom példányként kezeljük.
        // Az egyes tagokat összeszorozzuk a másikból származó tagokkal.
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
     * Az aktuális polinomot ossza el egy másikkal és visszaadja a hányadost.
     *
     * @param divisor a másik polinom amivel osztunk.
     * @return a hányados polinomként.
     */
    public Polynomial divide(Polynomial divisor) {
        // A hányados és maradék polinom példányként:
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial(new ArrayList<>(this.toTermList()));

        // A ciklus addig fut, amíg a maradék nulla vagy a maradék foka kisebb az osztó fokánál.
        while (!remainder.isZero() && remainder.getMaxExp() >= divisor.getMaxExp()) {
            // Elosszuk a vezető tagokat, hogy megkapjuk a következő hányados tag együtthatóját és kitevőjét.
            int expDiff = remainder.getMaxExp() - divisor.getMaxExp();
            double coeffRatio = remainder.getLeadingCoeff() / divisor.getLeadingCoeff();

            // Polinomot konstruálunk.
            Polynomial termPoly = new Polynomial();
            termPoly.terms.put(expDiff, coeffRatio);

            // Ezt a polinomot hozzáadjuk a hányadoshoz.
            quotient = quotient.add(termPoly);
            // Majd kivonjuk a maradékból.
            Polynomial subtractPoly = divisor.multiply(termPoly);
            remainder = remainder.subtract(subtractPoly);
            remainder.cleanUpTinyCoefficients();
        }

        return quotient;
    }

    /**
     * Az aktuális polinomot ossza el egy másikkal és visszaadja a maradékot.
     *
     * @param divisor a másik polinom amivel osztunk.
     * @return a maradék polinomként.
     */
    public Polynomial mod(Polynomial divisor) {
        // A maradék polinom példányként:
        Polynomial remainder = new Polynomial(new ArrayList<>(this.toTermList()));

        // A ciklus addig fut, amíg a maradék nulla vagy a maradék foka kisebb az osztó fokánál.
        while (!remainder.isZero() && remainder.getMaxExp() >= divisor.getMaxExp()) {
            int expDiff = remainder.getMaxExp() - divisor.getMaxExp();
            double coeffRatio = remainder.getLeadingCoeff() / divisor.getLeadingCoeff();

            // Polinomot konstruálunk.
            Polynomial termPoly = new Polynomial();
            termPoly.terms.put(expDiff, coeffRatio);

            // Ezt a polinomot kivonjuk a maradékból.
            Polynomial subtractPoly = divisor.multiply(termPoly);
            remainder = remainder.subtract(subtractPoly);
            remainder.cleanUpTinyCoefficients();
        }

        return remainder;
    }

    /**
     * Kiértékeli a polinomot egy adott x értéknél.
     *
     * @param x az érték, amelyen a polinomot kell kiértékelni.
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

            // Polinom nem első tagjai elé "+".
            if (sb.length() > 0) sb.append(coeff >= 0 ? "+" : "");

            if (exp == 0) {
                sb.append(coeff);    // Csak az együttható.
            } else {
                if (Math.abs(coeff - 1.0) > 1e-9 && Math.abs(coeff + 1.0) > 1e-9) {
                    sb.append(coeff);   // Ha az együttható nem 1 vagy -1.
                } else if (Math.abs(coeff + 1.0) < 1e-9) {
                    sb.append("-");   // Ha az együttható -1.
                }

                sb.append("x");   // X minden nem 0 kitevőjű taghoz.
                if (exp != 1) {
                    sb.append("^").append(exp);   // Ha a kitevő nem 1.
                }
            }
        }
        return sb.toString();
    }
}