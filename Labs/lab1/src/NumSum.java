import java.util.Scanner;

public class NumSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the 1st number: ");
        int myInteger1 = sc.nextInt();
        System.out.println("Enter the 2nd number: ");
        int myInteger2 = sc.nextInt();

        int numSum = myInteger1 + myInteger2;
        System.out.println("The sum is: " + numSum);

        sc.close();
    }
}
