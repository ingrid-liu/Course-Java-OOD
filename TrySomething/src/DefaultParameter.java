//// url: Java default parameters with method overloading
//// http://dolszewski.com/java/java-default-parameters/
//
//
//import javax.lang.model.type.NullType;
//import java.util.Objects;
//
//public class DefaultParameter {
//    private int ID;
//    private String para1;
//
//    public DefaultParameter(int ID){
//
//        this.ID = ID;
////        if (para1.isEmpty()){
////        if (para1==null || "".equals(para1)){
//        this.para1 = Objects.requireNonNullElse(para1, "Computer Science");
//    }
//
//    @Override
//    public String toString() {
//        return "DefaultParameter{" +
//                "ID=" + ID +
//                ", para1='" + para1 + '\'' +
//                '}';
//    }
//
//    public static void main(String[] args) {
////        System.out.println("Test");
////        DefaultParameter test1 = new DefaultParameter(5, "");
////        System.out.println(test1);
//
//        System.out.println("Test");
//        DefaultParameter test2 = new DefaultParameter(5);
//        System.out.println(test2);
//
////        System.out.println("Test");
////        DefaultParameter test3 = new DefaultParameter(5, "Data Science");
////        System.out.println(test3);
//
//    }
//}


/*
public void TestParameter(int level)
        {
        float money = 0.0f;
        boolean  ratable = true;
        TestParameter(level,  money ,ratable);

        }
public void TestParameter(int level, float money)
        {
        boolean  ratable = true;
        TestParameter(level,  money ,ratable);

        }
public void TestParameter(int level, float money , boolean ratable )
        {
        //最终实现在这里
        }

 */

