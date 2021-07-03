/**
 * This interface is a Polynomial that create a polynomial with terms in type TermNode.
 * @author  'Ingrid' Xiaoying Liu
 * @version 1.0
 * @since   2021-06-22
 */

public interface Polynomial {
    Polynomial addTerm(int coefficient, int pow) throws IllegalArgumentException;
    void removeTerm(int pow);
    int getDegree();                // return degree
    int getCoefficient(int pow);        // return the coefficient for the term with that power
    double evaluate(double precision);      //double check the data type for a double-precion decimal
    Polynomial add(PolynomialImpl another) throws IllegalArgumentException;


}
