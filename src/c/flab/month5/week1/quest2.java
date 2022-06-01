package c.flab.month5.week1;

public class quest2 {
    /**
        ==와 .equals의 차이 직접구현해보기

        공통점 : 양쪽 모두의 내용을 비교하며 boolean으로 값을 Return받음

        차이점 :
            ==연산자 :
                객체의 주솟값을 비교하는 역할, 비교하는 객체가 동일한 객체인지를 판별함
                Primitive Type의 객체에 대해서는 값 비교가 가능하고, Reference Type에 대해서는 주소 비교를 수행한다
                Primitive Type의 객체는 Constant Pool의 특정한 값을 참조하는 변수여서, 동앨 주소를 비교함

            euqlas메소드 :
                Object클래스의 메소드로 ==연산자와 동일하게 주소값의 비교를 수행하는 메소드임
                Stirng의 equals메소드는 오버라이딩을 하여 문자열 비교가 가능한 것

     */
    public static String A = "abc";

    public static void main(String[] args) {
//        String a = "abc";
//
//        if(a.equals(A)) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
//
//        quest2 q2 = new quest2();
//        //q2.equalsTest();
//
//
//        Value v1 = new Value(10);
//        Value v2 = new Value(10);
//
//        if(v1.equals(v2)) {
//            System.out.println("주소값 같음");
//        }else {
//            System.out.println("주소값 다름");
//        }
//
//        v2 = v1;
//        if(v1.equals(v2)) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
        ExampleEquals exam1 = new ExampleEquals("sample");
        ExampleEquals exam2 = new ExampleEquals("sample");

        System.out.println(exam1.equals(exam2));
    }

    void equalsTest() {
        String text1 = "sample";
        String text2 = text1;
        String text3 = new String("sample");
        String text4 = new String("sample");
        int a = 1;
        int b = new Integer(1);
        Integer c = new Integer(1);

        System.out.println("equalsTest()");
        System.out.println(text1 == text2);
        System.out.println(text1.equals(text2));
        System.out.println(text3==text4);
        System.out.println(text3.equals(text4));
        System.out.println(a==b);
        System.out.println(c.equals(a));
    }
}


class Value {
    int value;
    Value(int value) {
        this.value = value;
    }
}

class ExampleEquals {
    String name;

    public ExampleEquals(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        else
            if(obj instanceof ExampleEquals) return name == ((ExampleEquals)obj).name;
            else return false;
    }
}