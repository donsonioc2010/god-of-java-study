package c.flab.month5.week2;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayToString {
    public static void main(String[] args) {
        Integer [] a = new Integer[]{1,2,3,4,5};
        //[Ljava.lang.Integer;@4554617c
        System.out.println(a.toString());

        int [] a1 = new int[]{1,2,3,4,5};
        //[I@74a14482
        System.out.println(a1.toString());

        String [] b = {"abc","def","ghi"};
        //[Ljava.lang.String;@1540e19d
        System.out.println(b.toString());

        System.out.println(Arrays.toString(b));
        //[Lc.flab.month5.week2.TestVO;@677327b6
        TestVO[] c = {new TestVO("a"), new TestVO("b"), new TestVO("c")};
        System.out.println(c.toString());

        //c.flab.month5.week2.TestVO@14ae5a5
        System.out.println(new TestVO("d").toString());

        ArrayList<String> listTest = new ArrayList<String>();
        listTest.add("a");
        System.out.println(a.toString());

    }
}
