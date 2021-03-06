package c.string;


import java.nio.charset.StandardCharsets;

public class StringSample {
    public static void main(String[] args) {
        StringSample sample = new StringSample();
        //sample.convert();
        sample.convertUTF16();
    }

    public void printByteArray(byte[] array) {
        for(byte data : array) {
            System.out.println(data + " ");
        }
        System.out.println();
    }

    public void convertUTF16() {
        try {
            String korean = "한글";
            byte[] array1 = korean.getBytes(StandardCharsets.UTF_16);
            printByteArray(array1);
            //String korean2 = new String(array1); //���\�  글자 깨짐

            //정상작동 하게 하려면..아래.. (둘다 됨)
            //String korean2 = new String(array1, "utf-16");
            String korean2 = new String(array1, "UTF-16");

            System.out.println(korean2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void convert() {
        try{
            String korean="한글";

            byte[] array1 = korean.getBytes();

            for(byte data : array1) {
                System.out.println(data + " ");
            }
            System.out.println();

            String korean2 = new String(array1);
            System.out.println(korean2);

        } catch (Exception e) {
            e.printStackTrace();
        }

//        -19
//        -107
//        -100
//        -22
//        -72
//        -128
//
//        한글
    }
}
