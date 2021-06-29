import java.util.Arrays;

/**
 * Implements for abstract class Polynomial.
 * @author  'Ingrid' Xiaoying Liu
 * @version 1.0
 * @since   2021-06-22
 */

/**
 * Polynomial class implements Polynomial.
 */
public class PolynomialImpl implements Polynomial{

    int[] coef;
    int pow;

    /**
     * Constructor of the PolynomialImpl.
     */
    public PolynomialImpl() {
        this.coef = null;
        this.pow = -1;
    }

    /**
     * Constructor of the PolynomialImpl.
     * @param polyStr: a String expression of a polynomial
     */
    public PolynomialImpl(String polyStr) {

        String[] terms = polyStr.split(" ");        // "5x^2 -5x^1 +2x^0" → 5x^2, 5x^1, 2x^0

        for (int i = 0; i < terms.length; i++) {
            int coef = new Integer(terms[i].split("x")[0]);
            int pow = new Integer(terms[i].split("x")[1].replace("^",""));

            PolynomialImpl newTerm = new PolynomialImpl(coef, pow);
            System.out.println("up to now newTerm is " + newTerm.toString() + "\ncoef is: " + coef + "\npow is: " + pow);
            //this.add(newTerm);
        }
    }

    /**
     * Constructor of the PolynomialImpl.
     * @param coef a coefficient
     * @param pow a power
     * @throws IllegalArgumentException when power is negative
     */
    public PolynomialImpl(int coef, int pow) throws IllegalArgumentException {
        if (pow < 0) {
            throw new IllegalArgumentException("The exponent cannot be negative: " + pow);
        }
        this.coef = new int[pow+1];
        this.coef[pow] = coef;
        reduce();
    }

    // pre-compute the degree of the polynomial, in case of leading zero coefficients
    // (that is, the length of the array need not relate to the degree of the polynomial)

    /**
     * Helper method reduce.
     * Calculate out the degree of the polynomial in advance, in case of leading zero coefficients
     */
    protected void reduce() {
        pow = -1;
        for (int i = coef.length - 1; i >= 0; i--) {
            if (coef[i] != 0) {
                pow = i;
                return;
            }
        }
    }

    /*
    addTerm that takes a coefficient and a power (both integral numbers) and adds the resulting term to the polynomial.
     (This will enable you to build a polynomial term-by-term.) It should throw an IllegalArgumentException if a negative power is passed to it.
     */

    /**
     * The addTerm function is adding new term into an existing polynomial.
     * @param coef coefficient
     * @param pow power
     * @return a new Polynomial after adding the new term
     * @throws IllegalArgumentException when power is negative
     */
    @Override
    public Polynomial addTerm(int coef, int pow) throws IllegalArgumentException {
        if (pow < 0) {
            throw new IllegalArgumentException("The exponent cannot be negative: " + pow);
        }
        PolynomialImpl another = new PolynomialImpl(coef, pow);
        return this.add(another);
    }


    /**
     * The removeTerm that takes a power and removes any and all terms in the polynomial with that power.
     * @param pow power
     */
    @Override
    public void removeTerm(int pow) {

    }

    /**
     * The getDegree that returns the degree of this polynomial.
     * @return the highest power in the polynomial
     */
    @Override
    public int getDegree() {
        return pow;
    }

    /**
     * The getCoefficient that takes a power and returns the coefficient for the term with that power.
     * @param pow an integer power
     * @return the cofficient of the give-power-term.
     */
    @Override
    public int getCoefficient(int pow) {
        return 0;
    }

    /**
     * The evaluate that takes a double-precision decimal number and returns a double-precision result.
     * @param precision a double number of the precision
     * @return a double number after setting the presion
     */
    @Override
    public double evaluate(double precision) {
        return 0;
    }


    /**
     * The add that takes another Polynomial object and returns the polynomial obtained by adding the two polynomials.
     * @param another a given polynomial
     * @return  a new polynomial after the addition
     * @throws IllegalArgumentException if the give polynomial is a null
     */
    @Override
    public Polynomial add(PolynomialImpl another) throws IllegalArgumentException {
        if (another == null) {
            throw new IllegalArgumentException("It's not a Polynomial object");
        }

        PolynomialImpl poly = new PolynomialImpl(0, Math.max(this.pow, another.pow));
        for (int i = 0; i <= this.pow; i++) poly.coef[i] += this.coef[i];
        for (int i = 0; i <= another.pow; i++) poly.coef[i] += another.coef[i];
        poly.reduce();
        return poly;
    }

    /**
     * The toString method is the format of the polynomial for printing out.
     * @return a string
     */
    @Override
    public String toString() {

        if      (pow == -1) return "0";
        else if (pow ==  0) return "" + coef[0];
        else if (pow ==  1) return coef[1] + "x + " + coef[0];
        String s = coef[pow] + "x^" + pow;
        for (int i = pow - 1; i >= 0; i--) {
            if      (coef[i] == 0) continue;
            else if (coef[i]  > 0) s = s + " + " + (coef[i]);
            else if (coef[i]  < 0) s = s + " - " + (-coef[i]);
            if      (i == 1) s = s + "x";
            else if (i >  1) s = s + "x^" + i;
        }
        return s;
    }


}
