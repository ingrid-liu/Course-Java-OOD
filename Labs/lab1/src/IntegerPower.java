public class IntegerPower {
    public static void main(String[] args) {
        int baseNum = 2;
        int exponentNum = 10;
        int result = 1;
        for (int i = 0; i < exponentNum; i++) {
            result = result * baseNum;
        }
        System.out.println(result);
    }
}
