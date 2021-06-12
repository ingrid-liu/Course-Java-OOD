public class TestMySList {

    public TestMySList() {
    }

    public static void main(String[] args) {
        // empty sentence(list):
        SNode word3 = new SNode("789");
        SNode word2 = new SNode("world", word3);
        SNode word1 = new SNode("Hello", word2);
        SListImpl sentence1 = new SListImpl(word1);
//        System.out.println("********* Test on creating new SList *********");
//        System.out.println(sentence1);

//        System.out.println("\n********* Test on size() method *********");
//        System.out.println("Size of the SList is: " + sentence1.size());
//
//        System.out.println("\n********* Test on get() method *********");
//        System.out.println("Index 0 word is: " + sentence1.get(0));
//        System.out.println("Index 2 word is: " + sentence1.get(2));
//
//        System.out.println("\n********* Test on add() method *********");
//        sentence1.add("Tom");
//        sentence1.add("and");
//        sentence1.add("cat");
//        System.out.println("New sentence after add() ---- " + sentence1);

        // todo check SList size < 2:
        sentence1.remove(2);
        System.out.println("After calling add(), size:" + sentence1.size());


        System.out.println("Here1 is the original sentence:\n\n" + sentence1);

        System.out.println("\n********* Test on evenWords() method *********");
//        System.out.println("Expected: " + sentence1.get(0) + " "+ sentence1.get(2) + " "+  sentence1.get(4));
        System.out.println(sentence1.oddWords());

//
//        System.out.println("\n********* Test on oddWords() method *********");
//        System.out.println("Expected: " + sentence1.get(1) + " "+ sentence1.get(3) + " "+  sentence1.get(5));
//        System.out.println(sentence1.oddWords());

//        System.out.println("\nTest on edge case: ");
//        SListImpl sentence0 = new SListImpl(null);
//        System.out.println(sentence0.evenWords());




//        System.out.println("oddWords() of an empty list: " + sentence0.oddWords());
//        System.out.println("evenWords() of an empty list: " + sentence0.evenWords());

//
//        sentence0.add("Wow-oh");
//        System.out.println("add() to a new sentence: ---- " + sentence0);
//
//        System.out.println("\n********* Test on remove() method *********");
//        sentence1.remove(0);
//        System.out.println("After remove index 0: " + sentence1);
//        sentence1.remove(2);
//        System.out.println("After remove index 2: " + sentence1);
//
//        System.out.println("\n********* Test on removeStr() method *********");
//        System.out.println("Before remove str, list: " + sentence1);
//        sentence1.removeStr("789");
//        System.out.println("After removeStr \"789\": " + sentence1.toString());
//        System.out.println("\nEdge test - remove the last str: \"cat\"");
//        sentence1.removeStr("cat");
//        System.out.println(sentence1.toString());

//        sentence1.remove(0);
//        System.out.println("\nTest on remove(): " + sentence1);


    }
}
