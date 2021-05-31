public class Scientist extends Person{

    private String specialty;
    public Scientist(String name, int age, String SSN, String password) {
        super(name, age, SSN, password);
        this.specialty = "Computer Science";
    }
    public Scientist(String name, int age, String SSN, String password,String specialty) {
        super(name, age, SSN, password);
        if (specialty.isEmpty()){
            throw new IllegalArgumentException("Specialty can't be empty string.");
        }
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "This is a Scientist. " + "Name: " + getName() + "; Age: " + getAge() +
                "; Specialty: " + this.specialty;
    }

    public void setSpecialty(String specialty) {
        if (specialty.isEmpty()) {
            throw new IllegalArgumentException("Specialty can't be empty string.");
        }
        this.specialty = specialty;
    }
    public String getSpecialty(){
        return this.specialty;
    }
}
