/**
 * Created by  Xiaoying 'Ingrid' Liu on 6/6/2021
 *
 *
 */


public class PetRock {
    private String name;
    private boolean happy = false;
    private boolean vaccinated = false;

    public PetRock(String name, boolean happy, boolean vaccinated) {
        this.name = name;
        this.happy = happy;
        this.vaccinated = vaccinated;
    }

    public PetRock(String name) {
        if(name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isHappy() {
        return happy;
    }

    public String isUnhappy() {
        if (!happy){
            throw new IllegalStateException();
        }else{
            return "HAPPY!";
        }
    }

    public void playWithRock() {
        happy = true;
    }

    public String getHappyMessage() {
        if(!happy){
            throw new IllegalStateException();
        }
        return "I'm happy!";
    }

    public int getFavNumber() {
        return 42;
    }

    public void waitTillHappy() {
        if(!happy){
            // do nothing!
        }
    }

    public String getFavFood() {
        return "Meat ball!";
    }

    public void getVaccinated() {
        vaccinated = true;
    }

    public String checkVaccine() {
        if(vaccinated){
            return "I'm strong!";
        }else {
            throw new IllegalStateException();
        }
    }

    // Q4 Add a toString method in PetRock and JUnit
    public String toString() {
        return "We pickup a new PetRock!!" +
                "\nIts name: " + this.name +
                "\nIts happy condition: " + this.happy +
                "\nIts vaccinated condition: " + this.vaccinated + "\n";
    }

    public static void main(String[] args) {
        PetRock rocky = new PetRock("Piglet",true, true);
        System.out.println(rocky);

        // print out the default arguments
        PetRock defaultPet = new PetRock("Hello Kitty");
        System.out.println(defaultPet);
    }
}
