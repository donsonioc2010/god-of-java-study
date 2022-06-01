package c.exception;

public class ExceptionSample {
    public static void main(String[] args) {
        ExceptionSample sample = new ExceptionSample();
        //sample.arrayOutOfBounds();
        sample.arrayOutOfBoundsTryCatch();
    }

    public void arrayOutOfBounds() {
        int[] intArray = new int[5];
        System.out.println(intArray[5]);
    }

    public void arrayOutOfBoundsTryCatch() {
        int[] intArray = new int[5];
        try {
            System.out.println(intArray[5]);
            System.out.println("This Code Should Run.");
        } catch (Exception e) {
            System.out.println("Exception occured");
            //e.printStackTrace();
        }
        System.out.println("This Code Must Run");
    }
}
