import java.util.*;

/**
 * Practice using iterator to print and remove.
 */
public class RemoveVowels {
    public static void main(String[] args) {
        List<Character> capLetters = new ArrayList<>();
        for (char i = 65; i <= 90 ; i++) {
            capLetters.add(i);
        }

        Iterator<Character> itr1 = capLetters.iterator();
        Iterator<Character> itr2 = capLetters.iterator();
        Set<Character> vowels = new HashSet<>();
        vowels.add('A');vowels.add('E');vowels.add('I');vowels.add('O');vowels.add('U');

        System.out.println("\nPrint all letters by using iterator:");

        /**
         * Use iterator to print out the capital letter list.
         */
        while (itr1.hasNext())
            System.out.print("'" + itr1.next() + "' ");
        System.out.println();


        /**
         * Use iterator to remove all the vowels.
         */
        while (itr2.hasNext()) {
            char letter = itr2.next();
            if (vowels.contains(letter))
                itr2.remove();
        }
        System.out.println("\nAfter removing vowels:");
        Iterator<Character> itr3 = capLetters.iterator();
        while (itr3.hasNext())
            System.out.print("'" + itr3.next() + "' ");

        //System.out.println("\nExpected answer:\n'B' 'C' 'D' 'F' 'G' 'H' 'J' 'K' 'L' 'M' 'N' 'P' 'Q' 'R' 'S' 'T' 'V' 'W' 'X' 'Y' 'Z' ");

    }
}

/*
 * Reference reading:
 * https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
 * https://www.geeksforgeeks.org/iterating-arraylists-java/
 */