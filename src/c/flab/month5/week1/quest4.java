package c.flab.month5.week1;

public class quest4 {
    public static void main(String[] args) {
        finallyTest test = new finallyTest();
        System.out.println("as-is try");
        test.tryCatchFinallyTest();
        System.out.println("to-be try");
    }
}

class finallyTest {
    void tryCatchFinallyTest(){
        try {
            System.out.println("In Try");
            return;

            //JVM의 중지 또는 런타임의 중지는 finally블록을 실행하지 않는다.
            //System.exit(1);
            //Runtime.getRuntime().halt(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally Test");
        }
    }
}
