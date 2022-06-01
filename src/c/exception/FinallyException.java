package c.exception;

public class FinallyException {
    public static void main(String[] args) {
        FinallyException sample = new FinallyException();
        sample.finallySample();
    }

    public void finallySample() {
        int[] intArray = new int[5];
        try {
            System.out.println(intArray[5]);
        } catch (Exception e) {
            System.out.println(intArray.length);
        } finally {
            System.out.println("Here is Finally");
        }

        System.out.println("This code must run");
    }
}
