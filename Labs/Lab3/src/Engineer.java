public class Engineer extends Person {
    private String favProLang;

    public Engineer(String name, int age, String SSN, String password, String favProLang) {
        super(name, age, SSN, password);
        this.favProLang = favProLang;
    }

    public static void main(String[] args) {
        Engineer e = new Engineer("Tom", 30, "abcdefg", "1222", "Java");
        System.out.println(e.getName() + ": " + e.getSSN());

        Manager m = new Manager("Mark", 60, "789789", "778899", 22);
        System.out.println(m.getName() + ": " + m.getPassword());

        System.out.println(e);
        System.out.println(m);

        System.out.println("\nTest equal():");
        Person p1 = new Person("Tom", 34, "111", "1111");
        Person p2 = new Person("Tom", 34, "111", "1111");
        System.out.println(p1.equals(p2));
        System.out.println("same attributes, but different memory locations");

        System.out.println("\n");
        // Use parent class to represent child object
        Person p3 = new Engineer("Tim", 21, "fcfcfc", "334455", "C++");
        System.out.println(p3);

        Person p4 = new Manager("Jessica", 22, "tctctc", "556677", 6);
        System.out.println(p4);

//        Scientist s1 = new Scientist("Einstein", 66, "enenen", "12345","Physics");
//        System.out.println(s1);
//        Scientist s2 = new Scientist("Newton", 50, "nenene", "54321");
//        s2.getSpecialty("Sitting under apple tree.");

//        CSuiteManager c1 = new CSuiteManager("Steve", 38, "sjsjsj", "apple", 1.0);
//        System.out.println(c1);


    }
}