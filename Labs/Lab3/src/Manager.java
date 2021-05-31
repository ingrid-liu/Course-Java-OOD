public class Manager extends Person{
    private int numSubordinates;

    public Manager(String name, int age, String SSN, String password, int numSubordinates) {
        super(name, age, SSN, password);
        this.numSubordinates = numSubordinates;
    }

    public int getNumSubordinates(){
        return this.numSubordinates;        // this can be called directly
    }


    @Override
    public String toString() {
        return "This is a Manger. Name: "+ getName() + "; Age: " + getAge();
    }


}
