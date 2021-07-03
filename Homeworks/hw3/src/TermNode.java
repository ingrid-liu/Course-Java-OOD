/**
 * Class TermNode.
 * @author  'Ingrid' Xiaoying Liu
 * @version 1.0
 * @since   2021-06-22
 */

/**
 * This class TermNode creates term node with coefficient, power and link.
 */
public class TermNode {
    /**
     * int coef: coefficient of the term
     * int pow: power of the term
     * TermNode link: link to its next term
     */
    int coef;       // coefficient
    int pow;        // power
    TermNode link;      // link to its following Term


    /**
     * This constructor creates term object without passing any parameter
     * coef initialized as 0 when the term is empty
     * pow initialized as -1 when the term is empty
     * link initialized as null when the term is empty
     */
    public TermNode() {
        this.coef = 0;
        this.pow = -1;
        this.link = null;
    }

    /**
     * This constructor creates a termNode by passing coef and pow.
     * @param coef  an integer
     * @param pow  an non-negative integer
     * @throws IllegalArgumentException when the pow value is negative
     */
    public TermNode(int coef, int pow) throws IllegalArgumentException {
        if (pow < 0) {
            throw new IllegalArgumentException("exponent cannot be negative: " + pow);
        }
        this.coef = coef;
        this.pow = pow;
        this.link = null;
    }

    /**
     * This constructor creates a termNode by passing coef, pow and link.
     * @param coef  an integer
     * @param pow   an non-negative integer
     * @param link  a termNode
     * @throws IllegalArgumentException when the pow passed is negative
     */
    public TermNode(int coef, int pow, TermNode link) throws IllegalArgumentException {
        if (pow < 0) {
            throw new IllegalArgumentException("exponent cannot be negative: " + pow);
        }
        this.coef = coef;
        this.pow = pow;
        this.link = link;
    }

    /**
     * This evaluateTerm method evaluates the values of each termNode
     * @param x a double number
     * @return a double result
     */
    public double evaluateTerm(double x) {
        return this.coef * Math.pow(x, pow);
    }

    /**
     * The toString method is convert the object into an expression in String.
     * @return a String
     */
    public String toString() {
        String expression;
        if (coef != 0 && pow > 0) {
            expression = this.coef + "x^" + this.pow;

            if (coef == 1) expression = "x^" + this.pow;
            if (coef == -1) expression = "-x^" + this.pow;

        }
        else if (coef != 0 && pow == 0) expression = this.coef + "";
        else expression = "";
        return expression;
    }

    /**
     * The getter method of coefficient is getting the coef value.
     * @return coef
     */
    public int getCoef() {
        return coef;
    }

    /**
     * The setter method of coefficient is taking an integer and set it as the coefficient.
     * @param coef an integer
     */
    public void setCoef(int coef) {
        this.coef = coef;
    }

    /**
     * The getter method of power is getting the pow value.
     * @return power
     */
    public int getPow() {
        return pow;
    }
    /**
     * The setter method of pow is taking an integer and set it as the power.
     * @param pow an integer
     */
    public void setPow(int pow) {
        this.pow = pow;
    }

    /**
     * The getter method of link is getting the link value.
     * @return a TermNode
     */
    public TermNode getLink() {
        return link;
    }
    /**
     * The setter method of link is taking a TermNode and set it as the link's node.
     * @param link a TermNode
     */
    public void setLink(TermNode link) {
        this.link = link;
    }

}
