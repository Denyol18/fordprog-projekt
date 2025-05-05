/**
*Egy polinom egyetlen tagját írja le, például 3x^2 vagy -5.
*/
public class Term {
    /**
     * A tag együtthatója (pl. 3 a 3x^2-ben).
     */
    public double coeff;
    /**
     * A tag kitevője (pl. 2 a 3x^2-ben).
     */
    public int exp;

    /**
     * Konstruktor, ami tagot készít a megadott együtthatóval és kitevővel.
     *
     * @param coeff a tag együtthatója.
     * @param exp a tag kitevője.
     */
    public Term(double coeff, int exp) {
        this.coeff = coeff;
        this.exp = exp;
    }

    /**
     * A tag stringes reprezentációját adja vissza szabványos matematikai jelöléssel.
     * Példák:
     * - "5.0": konstans tag (exp = 0)
     * - "x^2": ahol a coeff = 1 és az exp = 2
     * - "3.5x^2": általános tag alak
     *
     * @return string ami a tagot reprezentálja.
     */
    @Override
    public String toString() {
        if (exp == 0) return "" + coeff;     // 5.0
        if (coeff == 1) return "x^" + exp;   // x^2
        return coeff + "x^" + exp;           // 5x^3
    }
}