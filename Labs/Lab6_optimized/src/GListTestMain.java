public class GListTestMain {

    public static void testAddSize(String var, String exp, String act, int sizExp, int sizAct) {
        System.out.println(var + "expected: " + exp + ", actual: " + act);
        System.out.println("  Size expected: " + sizExp + ", actual size: " + sizAct);
    }

    public static void testOther(String call, String exp, String act) {
        System.out.println(call + "expected: " + exp + ", actual: " + act);
    }

    public static void main(String[] args) {
        System.out.println("Testing with G as String");
        GList<String> sl1 = new emptyGListImpl<>();
        testAddSize("sl1", "[Empty]", sl1.toString(), 0, sl1.size());
        Integer sl1Findval = sl1.find("Anything?");
        testOther("sl1.find(\"Anything\")? ", "-1", sl1Findval.toString());
        GList<String> sl2 = sl1.add("Hello");
        testAddSize("sl2", "Hello [Empty]", sl2.toString(), 1, sl2.size());
        GList<String> sl3 = sl2.add("World");
        testAddSize("sl3", "Hello World [Empty]", sl3.toString(), 2, sl3.size());
        GList<String> sl4 = sl3.add("Align!");
        testAddSize("sl4", "Hello World Align! [Empty]", sl4.toString(), 3, sl4.size());
        Integer sl4FindWorld = sl4.find("World");
        testOther("sl4.find(\"World\"): ", "1", sl4FindWorld.toString());
        Integer sl4FindAlign = sl4.find("Align!");
        testOther("sl4.find(\"Align!\"): ", "2", sl4FindAlign.toString());
        Integer sl4FindNada = sl4.find("Nada");
        testOther("sl4.find(\"Nada\"): ", "-1", sl1Findval.toString());
        String sl4val0 = sl4.getVal(0);
        testOther("sl4.getVal(0): ", "Hello", sl4val0);
        GList<String> sl5rem2 = sl4.remove(2);
        testOther("sl4.remove(2): ", "Hello World [EMPTY]", sl5rem2.toString());
        GList<String> sl6rem0 = sl4.remove(0);
        testOther("sl4.remove(0): ", "World [EMPTY]", sl6rem0.toString());
        try {
            GList<String> sl6remNeg1 = sl6rem0.remove(-1);
            testOther("sl6rem0.remove(-1): ", "?", sl6remNeg1.toString());
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("sl6remNeg1 Expected and Caught:\n" + e);
        }
        System.out.println("Final value of sl4: " + sl4);

        System.out.println("\nTesting with G as Integer");
        GList<Integer> il1 = new emptyGListImpl<>();
        testAddSize("il1", "[Empty]", il1.toString(), 0, il1.size());
        GList<Integer> il2 = il1.add(0);
        testAddSize("il2", "0 [Empty]", il2.toString(), 1, il2.size());
        GList<Integer> il3 = il2.add(1);
        testAddSize("il3", "0 1 [Empty]", il3.toString(), 2, il3.size());
        GList<Integer> il4 = il3.add(2);
        testAddSize("il4", "0 1 2 [Empty]", il4.toString(), 3, il4.size());
        Integer il4Find0 = il4.find(0);
        testOther("il4.find(0) ", "0", il4Find0.toString());
        Integer il4Find1 = il4.find(1);
        testOther("il4.find(1) ", "1", il4Find1.toString());
        Integer il4val2 = il4.getVal(2);
        testOther("il4.getval(2): ", "2", il4val2.toString());
        try {
            Integer il4val5 = il4.getVal(5);
            testOther("il4.getval(5): ", "?", il4val5.toString());
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("il4.getval(5) Expected and Caught:\n" + e);
        }
        try {
            GList<Integer> il5rem3 = il4.remove(3);
            testOther("il4.remove(3: ", "?", il5rem3.toString());
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("il4.getval(5) Expected and Caught:\n" + e);
        }
        System.out.println("Final value of il4: " + il4);
        System.out.println("After removing index 0: " + il4.remove(0).toString());
        try {
            System.out.println("Empty List: " + new emptyGListImpl().remove(0).toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot remove from empty GList:\n" + e);
        }
    }
}
