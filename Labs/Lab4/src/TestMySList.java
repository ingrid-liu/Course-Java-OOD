public class TestMySList {


    public TestMySList() {
    }

    public static void main(String[] args) {
        // empty sentence(list):
        SNode word3 = new SNode("!");
        SNode word2 = new SNode("world", word3);
        SNode word1 = new SNode("Hello", word2);
        SListImpl sentence1 = new SListImpl(word1);
        System.out.println("********* Test on creating new SList *********");
        System.out.println(sentence1);

        System.out.println("\n********* Test on size() method *********");
        System.out.println("Size of the SList is: " + sentence1.size());

        System.out.println("\n********* Test on get() method *********");
        System.out.println("Index 0 word is: " + sentence1.get(0));
        System.out.println("Index 2 word is: " + sentence1.get(2));

        System.out.println("\n********* Test on add() method *********");
        sentence1.add("This");
        sentence1.add("is");
        sentence1.add("Ingrid");
        System.out.println("New sentence after add() ---- " + sentence1);
        System.out.println("After calling add(), size:" + sentence1.size());

//        SListImpl sentence0 = new SListImpl(null);
//        sentence0.add("Wow-oh");
//        System.out.println("add() to a new sentence: ---- " + sentence0);
//
//        System.out.println("\n********* Test on remove() method *********");
//        sentence1.remove(0);
//        System.out.println("After remove index 0: " + sentence1);
//        sentence1.remove(2);
//        System.out.println("After remove index 2: " + sentence1);

        System.out.println("\n********* Test on oddWords() method *********");
//        System.out.println("Target: " + sentence1.get(1) + " "+ sentence1.get(3) + " "+  sentence1.get(5));
        System.out.println(sentence1.oddWords());
        System.out.println("\n********* Test on evenWords() method *********");
//        System.out.println("Target: " + sentence1.get(0) + " "+ sentence1.get(2) + " "+  sentence1.get(4));
        System.out.println(sentence1.evenWords());






    }
}
