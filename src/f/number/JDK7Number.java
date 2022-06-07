package f.number;

// Java 6과 7
public class JDK7Number {
    public static void main(String[] args) {
        JDK7Number sample = new JDK7Number();
        sample.jdk6();
        System.out.println("-----------");
        sample.jdk7();
        System.out.println("-----------");
        sample.jdk7UnderScore();
    }

    //6에서는 3가지의 표현밖에 안됨
    public void jdk6() {
        int decVal = 1106;  //10
        int octVal = 02122; //8
        int hexVal = 0x452; //16

        System.out.println(decVal);
        System.out.println(octVal);
        System.out.println(hexVal);
    }
    //7부터 2진수의 표현이 가능
    public void jdk7() {
        int binaryVal = 0b10001010010;
        System.out.println(binaryVal);
    }

    //_를 사용해서 숫자를 넣어도 상관이없어짐
    private void jdk7UnderScore() {
        int binaryVal = 0b0100_0101_0010;
        int million = 1_000_000;
        System.out.println(binaryVal);
        System.out.println(million);
    }

}
