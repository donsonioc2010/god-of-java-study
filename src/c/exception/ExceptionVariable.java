package c.exception;

public class ExceptionVariable {
    public static void main(String[] args) {
        ExceptionVariable sample = new ExceptionVariable();
        sample.checkVariable();
    }

    public void checkVariable() {
        //int[] intArray = new int[5];
        int[] intArray = null;
        try {
            //여기서 변수선언 시에는 catch에서 Exception
            //int[] intArray = new int[5];
            intArray = new int[5];
            System.out.println(intArray[5]);
        } catch (Exception e) {
            System.out.println(intArray.length);
        }
        System.out.println("This code must run");
    }
}
