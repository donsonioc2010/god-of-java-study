package d.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TestCollection {
    public static void main(String[] args) {
        //Collection<String> collection = new HashSet<>();
        //Collection<String> collection1 = new HashSet<>();
        String a = new String("testCollection");
        String b = new String("testCollection");
        //collection.add(new String("testCollection"));
        //collection1.add(b);
        //will return true if both the collections are equal
        //boolean val=collection.contains(new String("testCollection"));
        // System.out.println(val);

        /**
        List<TestVO> listA = new ArrayList<TestVO>();
        List<TestVO> listB = new ArrayList<TestVO>();
        TestVO ta = new TestVO(a);
        TestVO tb = new TestVO(b);
        listA.add(ta);
        listB.add(tb);
        boolean result = listA.contains(tb);
        */
        List<String> listA = new ArrayList<String>();
        List<String> listB = new ArrayList<String>();

        listA.add(new String("bcdeff"));
        listB.add(new String("bcdeff"));

        String sa = new String("bcdeff");
        System.out.println( Integer.toHexString(listA.get(0).hashCode()));
        System.out.println(Integer.toHexString(sa.hashCode()));

        //boolean result = listA.contains(new String("bcdeff"));
        boolean result = listA.contains(sa);

        //contains 는 동등성 검사는 맞음 Object의 equals를 사용중이었슴.
        System.out.println(result);


    }
}
