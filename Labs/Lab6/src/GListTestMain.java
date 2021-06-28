public class GListTestMain {
    public static void main(String[] args) {

        System.out.println("********** Test emptyGList ***********");
        emptyGListImpl<Integer> emptyGList = new emptyGListImpl<>();
        System.out.println("emptyGList: " + emptyGList.toString());

        System.out.println("size: " + emptyGList.size());
        //System.out.println("getVal: " + emptyGList.getVal(0));   // expected Exception
        System.out.println("getNext: " + emptyGList.getNext());
        System.out.println("isEmpty: " + emptyGList.isEmpty());
        System.out.println("find: " + emptyGList.find(666));
        //System.out.println("remove: " + emptyGList.remove(1));  // expected Exception
        System.out.println("add: " + emptyGList.add(1));

        System.out.println("\n********** Test GList ***********");
        GList<String> StrList = new GListImpl<String>("a");
        System.out.println("StrList: " + StrList);
        StrList.add("b");
        System.out.println("after add('b'): " + StrList);
        System.out.println("size: " + StrList.size());
        System.out.println("getVal(0): " + StrList.getVal(0));
        System.out.println("getVal(1): " + StrList.getVal(1));
        //System.out.println("getVal(2): " + StrList.getVal(2));  // expected Exception
        System.out.println("getNext(): " + StrList.getNext());
        System.out.println("isEmpty(): " + StrList.isEmpty());
        System.out.println(StrList);

        System.out.println("find(\"a\"): " + StrList.find("a"));
        System.out.println("find(\"b\"): " + StrList.find("b"));

        System.out.println("remove: " + StrList.remove(1));


    }

}
