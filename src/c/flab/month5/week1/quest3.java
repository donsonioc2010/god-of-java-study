package c.flab.month5.week1;

public class quest3 {
    public static void main(String[] args) {
        int[] exam = new int[20];

        integerArray intAry = new integerArray();
        intAry.exampleArray(exam);
    }

}

class integerArray {
    void exampleArray(int[] ary) {
        int [] sample = new int[10];
        System.out.println(sample.length + " " + sample.toString());
        sample = new int[ary.length];
        System.out.println(sample.length+ " " + sample.toString());
    }
}