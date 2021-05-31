import org.w3c.dom.css.CSSPrimitiveValue;

public class Person extends PrimitivePerson {

    private String SSN;
    private String password;

    public Person(String name, int age, String SSN, String password) {
        super(name, age);
        this.SSN = SSN;
        this.password = password;
    }


    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person Name " + getName();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person otherPerson = (Person) obj;
            String thisSSN = this.getSSN();
            String otherSSN = otherPerson.SSN;
            return thisSSN.equals(otherSSN);
        }else{
            return false;
        }
    }
}
