package c.string;

public class StringCompare {
    public static void main(String[] args) {
        StringCompare sample = new StringCompare();

        //sample.checkString();

        //sample.checkCompare();
        //sample.checkCompare2();

        sample.checkCompareTo();
    }


    public void checkCompareTo() {
        String text = "a";
        String text2 = "b";
        String text3 = "c";

        System.out.println(text2.compareTo(text));
        System.out.println(text2.compareTo(text3));
        System.out.println(text.compareTo(text3));

        //"abc" , "adf" 가 들어가면, a는 같기떄문에 비교가 안되고, b와 d가 비교됨..
        // return 은  'b' - 'd'가 리턴됨
        // 자매품 compareToIgnoreCase(String) 이 있다.

    }

    public void checkString() {

        String text = "You must know String Class.";
        //문자열의 길이를 확인
        System.out.println("text.length() = "+text.length());

        //문자열 공백여부 (길이가 0인 경우 true, Null인 경우에는 Exception, 공백만 있어도 false뜸 ""로 들어가있어야함)
        System.out.println("text.isEmpty() = "+text.isEmpty());
    }

    public void checkCompare() {
        String text = "Check Value";
        String text2 = "Check Value";

        if(text == text2) {
            System.out.println("text==text2 result is same");
        } else {
            System.out.println("text==text2 result is different");
        }

        if(text.equals("Check Value")) {
            System.out.println("text.equals(text2) result is same");
        }

        String text3 = "check value";
        //대소문자의 구분X
        if(text.equalsIgnoreCase(text3)) {
            System.out.println("text.equalsIgnoreCase(text3) result is same");
        }
    }

    public void checkCompare2() {
        String text = "Check Value";
        String text2 = new String("Check Value");

        if(text == text2) {
            System.out.println("text==text2 result is same");
        } else {
            System.out.println("text==text2 result is different");
        }

        if(text.equals("Check Value")) {
            System.out.println("text.equals(text2) result is same");
        }
    }
}
