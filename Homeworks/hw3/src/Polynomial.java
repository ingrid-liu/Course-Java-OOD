/**
 * Polynomial interface.
 * @author  'Ingrid' Xiaoying Liu
 * @version 1.0
 * @since   2021-06-22
 */
public interface Polynomial {
    Polynomial addTerm(int coefficient, int pow) throws IllegalArgumentException;
    void removeTerm(int pow);       // 也可以考虑返回删除后的结果
    int getDegree();                // return degree
    int getCoefficient(int pow);        // return the coefficient for the term with that power
    double evaluate(double precision);      //double check the data type for a double-precion decimal
    Polynomial add(PolynomialImpl another) throws IllegalArgumentException;


}
