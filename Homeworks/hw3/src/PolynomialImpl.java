import java.security.spec.RSAOtherPrimeInfo;

/**
 * This class implements a Polynomial that creates a polynomial with terms in type TermNode.
 * @author  'Ingrid' Xiaoying Liu
 * @version 1.0
 * @since   2021-06-22
 */


public class PolynomialImpl implements Polynomial{
    /**
     * The head is the first Term in the polynomial.
     */
    TermNode head;

    /**
     * This constructor is taking no parameter and creates a null polynomial.
     */
    public PolynomialImpl() {
        this.head = null;
    }

    /**
     * This constructor is taking a string and creates a polynomial.
     * @param polyStr an expression of a polynomial in String type.
     */
    public PolynomialImpl(String polyStr) {
        String[] terms = polyStr.split(" ");        // "5x^2 -5x^1 +2x^0" → 5x^2, 5x^1, 2x^0

        for (int i = 0; i < terms.length; i++) {
            int coef = new Integer(terms[i].split("x")[0]);
            int pow = new Integer(terms[i].split("x")[1].replace("^",""));
            this.addTerm(coef, pow);
        }
    }

    /**
     * This addTerm is taking a coefficient and a power and add it as a term into the polynomial.
     * @param coefficient   an integer
     * @param power an integer
     * @return  a polynomial
     * @throws IllegalArgumentException when the power passed is a negative value
     */
    @Override
    public Polynomial addTerm(int coefficient, int power) throws IllegalArgumentException {
        if (power < 0) {
            throw new IllegalArgumentException("can't pass a negative power to addTerm: " + power);
        }
        TermNode newAddTerm = new TermNode(coefficient, power);
        TermNode currTerm = head;
        TermNode dummyTerm = new TermNode();
        dummyTerm.link = currTerm;

        if (currTerm == null || currTerm.pow == -1) {
            this.head = new TermNode(coefficient, power);
            return this;
        }

        if (this.powExists(power)) {
            if (power == this.getDegree()) {
                this.head.setCoef(this.head.coef + coefficient);
                return this;
            }
            if (power < this.getDegree()) {
                //currTerm = currTerm.link;
                while (currTerm.link != null) {
                    if (currTerm.link.pow == power) {
                         currTerm.link.setCoef(currTerm.link.coef + coefficient);
                        head = dummyTerm.link;
                        return this;
                    }
                    currTerm = currTerm.link;
                }
            }
        } else {
            if (power > this.getDegree()) {
                dummyTerm.link = newAddTerm;
                newAddTerm.link = head;
                head = dummyTerm.link;
                return this;
            } else {
                while (currTerm.link != null) {
                    if (currTerm.link.pow > power) {}
                    else {
                        TermNode tempTerm = currTerm.link;
                        currTerm.link = newAddTerm;
                        newAddTerm.link = tempTerm;
                        head = dummyTerm.link;
                        return this;
                    }
                    currTerm = currTerm.link;
                }
                currTerm.link = newAddTerm;
            }
        }
        return this;
    }

    /**
     * This add method is taking a polynomial attribute and add two polynomials into one result.
     * @param another a Polynomial
     * @return a result Polynomial
     * @throws IllegalArgumentException when the parameter passed is not a Polynomial class object.
     */
    @Override
    public PolynomialImpl add(PolynomialImpl another) throws IllegalArgumentException {
        PolynomialImpl result = new PolynomialImpl();

        result.head = this.head;
        TermNode currTerm = another.head;

        if (another instanceof Polynomial){
            if (currTerm == null || currTerm.pow == -1) {
                return result;
            }

            while (currTerm!= null) {
                int coef = currTerm.coef;
                int pow = currTerm.pow;
                result.addTerm(coef, pow);
                currTerm = currTerm.link;
            }
            return result;

        } else throw new IllegalArgumentException("The added object is not a Polynomial" + another.getClass());
    }

    /**
     * This removeTerm method is taking a pow value and remove the term whit that pow.
     * @param pow an integer
     * @throws IllegalArgumentException when the pow passed is negative
     */
    @Override
    public void removeTerm(int pow) throws IllegalArgumentException{
        if (pow < 0) {
            throw new IllegalArgumentException("Term to add can't be given a negative power: " + pow);
        }
        if (!this.powExists(pow)) {}

        else {
            TermNode currentTerm = head;
            while (currentTerm != null) {
                if (currentTerm.pow == pow) currentTerm.coef = 0;
                currentTerm = currentTerm.link;
            }
        }
    }

    /**
     * This getDegree method gets the highest power in the polynomial.
     * @return an integer, the degree of the polynomial
     */
    @Override
    public int getDegree() {
        int size = this.size();
        int tempMaxPow = 0;
        for (int i = 0; i < size; i++) {
            // if the polynomial has no terms, degree returns -1
            if (size == 0) return -1;
            if (size < 2) return head.pow;
            else {
                TermNode currTerm = new TermNode();
                currTerm = head;
                if(size == 2) return Math.max(currTerm.pow, currTerm.link.pow);
                while (currTerm.link != null) {
                    if (currTerm.pow > tempMaxPow) tempMaxPow = currTerm.pow;
                    currTerm = currTerm.link;
                }
            }
        }
        return tempMaxPow;
    }

    /**
     * This getCoefficient method is taking a power and return the coefficient of the term with that power.
     * @param pow a non-negative integer
     * @return  an integer, the coefficient of the term with the power
     * @throws IllegalArgumentException when the pow passed is negatvie
     */
    @Override
    public int getCoefficient(int pow) throws IllegalArgumentException {
        if (pow < 0) {
            throw new IllegalArgumentException("can't pass a negative power to addTerm: " + pow);
        }
        if (!this.powExists(pow)) return 0;

        TermNode currTerm = head;
        if (currTerm == null) return 0;
        if (currTerm.pow == pow && currTerm.link == null) return currTerm.coef;
        else {
            while (currTerm.link != null){
                if (currTerm.pow == pow) return currTerm.coef;
                currTerm = currTerm.link;
            }
            if (currTerm.pow == pow) return currTerm.coef;
        }
        return 0;
    }

    /**
     * This evaluate method is taking a double number of x and evaluate the polynomial's value
     * @param x a double number
     * @return a double number of the evaluation result
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
        if (this.head == null) return 0;
        TermNode currTerm = this.head;
        while (currTerm != null) {
            result += currTerm.evaluateTerm(x);
            currTerm = currTerm.link;
        }
        result = Math.round(result * 100.0) / 100.0;
        return result;
    }

    /**
     * The toString method is convert the object into an expression in String.
     * @return a String
     */
    @Override
    public String toString() {
        String expression;
        TermNode currentTerm = head;
        if (currentTerm == null || currentTerm.pow == -1) return null;
        if (currentTerm.link == null) return currentTerm.toString();
        else {
            expression = currentTerm.toString();
            while (currentTerm.link != null) {
                if (currentTerm.link.coef > 0)
                    expression = expression + " " + "+" + currentTerm.link.toString();
                else
                    expression =  expression + " " + currentTerm.link.toString();
                currentTerm = currentTerm.link;
            }
            return expression;
        }
    }

    /**
     * This helper method size is getting the terms num of the polynomial.
     * @return an integer, the num of the terms
     */
    private int size() {
        int counter = 0;
        TermNode currentTerm = head;
        if (currentTerm == null || currentTerm.pow == -1) {
            return 0;
        }
        else{
            while (currentTerm != null) {
                counter++;
                currentTerm = currentTerm.link;
            }
        }
        return counter;
    }

    /**
     * This helper method is taking a target power and check if it is existed in the polynomial.
     * @param targetPow a non-negative integer
     * @return boolean result, true if exists, false otherwise
     * @throws IllegalArgumentException when target power is negative
     */
    private boolean powExists(int targetPow) throws  IllegalArgumentException {
        if (targetPow < 0) {
            throw new IllegalArgumentException("powExists method can't detect negative power you passed");
        }
        TermNode currTerm = new TermNode();
        currTerm = head;
        if (currTerm == null) return false;
        if (currTerm.link == null) return currTerm.pow == targetPow;
        else {
            while (currTerm.link != null){
                if (currTerm.pow == targetPow) return true;
                currTerm = currTerm.link;
            }
            return currTerm.pow == targetPow;
        }
    }

    public static void main(String[] args) {
        System.out.println("main function runs...");
        TermNode termA0 = new TermNode();
        // TermNode termA1 = new TermNode();
        TermNode termA1 = new TermNode(5, 4);
        TermNode termA2 = new TermNode(2, 3);
        TermNode termA3 = new TermNode(3, 2);
        TermNode termB1 = new TermNode(-5, 5);
        TermNode termB2 = new TermNode(-5, 2);

        termA1.link = termA2;
        termA2.link = termA3;
        // termA3.link = termB1;
        termB1.link = termB2;

        // todo Question: why I can't use Polynomial p1 = new PolynomialImpl();!!!!! so annoying!!!![○･｀Д´･ ○]
        PolynomialImpl p1 = new PolynomialImpl();
        p1.head = termA1;
        System.out.println("p1 = " + p1);

        PolynomialImpl p2 = new PolynomialImpl();
        p2.head = termB1;
        System.out.println("p2 = " + p2);

        PolynomialImpl p0 = new PolynomialImpl();
        System.out.println("** p0 = " + p0);
        System.out.println("** p0's size: " + p0.size());


        /** addTerm finally works!!!  (╥╯^╰╥)*/
        p0.addTerm(-2,2);
        System.out.println("** after addTerm to empty poly:                        " + p0);

        p0.addTerm(3,3);
        p0.addTerm(-1,4);
        p0.addTerm(3,5);
        System.out.println("** after addTerm with nonExist bigger pow,  p0=        " + p0);

        System.out.print("p0= " + p0 + "        addTerm(3x^5)=        ");
        p0.addTerm(3,5);
        System.out.println(p0);

        System.out.print("p0= " + p0 + "        addTerm(3x^3)=        ");
        p0.addTerm(3,3);
        System.out.println(p0);

        System.out.print("p0= " + p0 + "         addTerm(3x^2)=       ");
        p0.addTerm(3,2);
        System.out.println(p0);

        System.out.print("p0= " + p0 + "         addTerm(3x^10)=       ");
        p0.addTerm(3,10);
        System.out.println(p0);

        System.out.print("p0= " + p0 + "    addTerm(3x^7)=      ");
        p0.addTerm(3,7);
        System.out.println(p0);

        System.out.print("p0= " + p0 + "   addTerm(3x^1)= ");
        p0.addTerm(3,1);
        System.out.println(p0);


        System.out.println("\n**********");
        System.out.println("p0=  " + p0 );
        System.out.println("p1=  " + p1 );
        System.out.println("p2=  " + p2 );

//        System.out.println("\n**********");
//        System.out.println("Test class of the object");
//        System.out.println(p0.getClass());

        System.out.println("\n**********");
        System.out.println("p1 + p2 =       " + p1.add(p2));

        System.out.println("*** after calling add:");
        System.out.println("p1=  " + p1 + " ******* LAST NODE SHOULD BE +3x^2 !");
        System.out.println("p2=  " + p2 );



        // todo
//        System.out.println("p0 + p1 =       " + p1.add(p2));
//        System.out.println("p0 + p2 =       " + p1.add(p2));

//        TermNode C1 = new TermNode(4,1);
//        //TODO QUESTION: why I cant set a polynomial object
//        // Polynomial p3 = new PolynomialImpl(C1);
//        PolynomialImpl p3 = new PolynomialImpl();
//        p3.head = C1;
//        System.out.println("\np3=  " + p3 );
//        System.out.println("p1 + p3 =       " + p1.add(p3));

        TermNode termTest = new TermNode(3, 2);
        PolynomialImpl pTest = new PolynomialImpl();
        pTest.head = termTest;
        System.out.println("\n*** test:");
        System.out.println("p1: " + p1 + " + pTest: " + pTest + "=");
        System.out.println(p1.add(pTest));
        System.out.println("After calling add, p1 = " + p1 + " ******* LAST NODE IS CHANGED!");


        System.out.println("\n************");
        System.out.println("Test parsing strPoly:");
        //String testStr = "-5x^6 +5x^2 +2x^1";        // works!
        //String testStr = "5x^2 +2x^1";              // works!
        //String testStr = "7x^8 -5x^6 +5x^2 +2x^1";   // works!
        String testStr = "3x^5 -1x^4 +3x^3 -2x^2";      // works!!
        // String testStr = "3x^5 -1x^4 +3x^3 -2x^2";      // todo doesn't work!
        Polynomial testPoly = new PolynomialImpl(testStr);
        System.out.println("original string: " + testStr);
        System.out.println("testPoly " + testPoly.toString()  );


        /** evaluate works!*/
        System.out.println("\n************");
        System.out.println("Test evaluate:");
        System.out.println("p1 = " + p1 + " (x=" + 2.0 + ") result = " + p1.evaluate(2.0));
        System.out.println("p1 = " + p1 + " (x=" + -1 + ") result = " + p1.evaluate(-1));

        /** getCoef works!*/
//        System.out.println("\nTest on getCoef");
//        System.out.println("coef of pow 10: " + p0.getCoefficient(10));
//        System.out.println("coef of pow 5 : " + p1.getCoefficient(5));
//        System.out.println("coef of pow 2 : " + p2.getCoefficient(2));
//
//        System.out.println("coef of pow 8 : " + p0.getCoefficient(8));
//        System.out.println("coef of pow 4 : " + p1.getCoefficient(4));
//        System.out.println("coef of pow 1 : " + p2.getCoefficient(1));


        // todo Question why this add method doesn't work?
//        System.out.println("p1 + p2 = " + p1.add(p2));

        // todo Question why this String parse constructor doesn't work?
//        System.out.println("\nTest horrible string sparse method: ");
//        PolynomialImpl pStr = new PolynomialImpl("5x^2 -5x^1 +2x^0");
//        System.out.println(pStr);

        /** addTerm works */
//        p1.addTerm(5, 3);
//        System.out.println("addTerm into p1: " + p1);

        /** getDegree works well!!! */
//        System.out.println("Test degree: " + p1.getDegree());
//

        /** removeTerm works well!! */
//        p1.removeTerm(2);
//        System.out.println("\nTesting on removePow:" + p1);


//        System.out.println("\nTesting on degree: " + p1.getDegree());

//        p1.addTerm(2,1);
//        System.out.println(p1);
//        System.out.println(p1.addTerm(2,2));
//        p1.addTerm(-3, 2);
//        System.out.println(p1);


//        System.out.println("p1: " + p1.toString());
//
//        Polynomial p2 = new PolynomialImpl(termB1);
//        System.out.println("p2: " + p2.toString());

//        System.out.println("p1 + 3x^2: " + p1.addTerm(3, 2).toString());

        // todo "5x^2 +4x^1 +2x^0"
//        Polynomial pStr = new PolynomialImpl("5x^2");
//        System.out.println("pStr: " + pStr.toString());



        /**
         * helper methods:
         */

        /** getTail works well */
//        System.out.println("Test getTail: " + p1.getTail());

        // size works well!!
//        System.out.println("size: " + p1.size());

        /** powExist works */
//        System.out.println("check if pow 0 exist");
//        System.out.println(p1.powExists(0));
//        System.out.println("check if pow 2 exist");
//        System.out.println(p1.powExists(2));
//        System.out.println("check if pow 3 exist");
//        System.out.println(p1.powExists(3));

//        System.out.println("\n*** powExist method: ");
//        System.out.println("p1= " + p1);
//        System.out.println(p1.powExists(2));
//        System.out.println(p1.powExists(3));
//        System.out.println(p1.powExists(1));

//        System.out.print("p0= " + p0 + "        addTerm(-4x^6)=        ");
//        p0.addTerm(-4,6);
//        System.out.println(p0);
//
//        System.out.print("p0= " + p0 + "    addTerm(3x)=        ");
//        p0.addTerm(3,1);
//        System.out.println(p0);



    }

}
