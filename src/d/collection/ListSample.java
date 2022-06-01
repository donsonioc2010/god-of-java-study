package d.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListSample {
    public static void main(String[] args) {
        ListSample sample = new ListSample();
        //sample.checkArrayList1();
        //sample.checkArrayList5();
        //sample.checkArrayList6();
        //sample.checkArrayList7();
        sample.checkArrayList8();
    }

    public void checkArrayList1() {
        ArrayList<String> list1 = new ArrayList<>();
        //list1.add(new Object());
        list1.add("ArrayListSample");
        //list1.add(new Double(1));
    }
    public void checkArrayList5() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        int listSize = list.size();
        for(int loop = 0; loop < listSize; loop++) {
            System.out.println("list.get("+loop+")="+list.get(loop));
        }
        int a = list.indexOf(null);
        System.out.println(a);
    }
    public void checkArrayList6() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        String[] strList = list.toArray(new String[0]);
        System.out.println(strList[0]);
    }
    public void checkArrayList7() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        String[] tempArray = new String[2];
        String[] strList = list.toArray(tempArray);

        for(String temp : strList) {
            System.out.println(temp);
        }
    }
    public void checkArrayList8() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");
        //System.out.println("Removed" + list.remove(0));
        //System.out.println(list.remove("A"));
        ArrayList<String> temp = new ArrayList<>();
        temp.add("A");
        list.removeAll(temp);
        for(int loop = 0; loop < list.size(); loop++) {
            System.out.println("list.get("+loop+")="+ list.get(loop));
        }

    }
}
