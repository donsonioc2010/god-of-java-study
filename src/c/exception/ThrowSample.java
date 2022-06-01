package c.exception;

public class ThrowSample {
    public static void main(String[] args) {
        ThrowSample sample = new ThrowSample();
        sample.throwException(13);
    }
    public void throwException(int number) {
        try {
            if(number > 12) {
                throw new Exception("Number is 12 Over");
            }
            System.out.println("Number is" + number);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
