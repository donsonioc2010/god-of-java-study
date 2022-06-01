package d.generic;

import java.util.*;

public class GenericWildcardSample {
    public static void main(String[] args) {
        GenericWildcardSample sample = new GenericWildcardSample();
        sample.callGenericMethod();

        String str1 = new String("aaa");
        String str2 = new String("aaa");

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        List<String> a = new ArrayList<String>();
        a.add("a");
        //a.add(123);
    }

    public void callGenericMethod() {
        WildcardGeneric<String> wildcard = new WildcardGeneric<String>();
        genericMethod(wildcard, "Data");
    }

    public <T> void genericMethod(WildcardGeneric<T> c , T addValue) {
        c.setWildcard(addValue);
        T value = c.getWildcard();
        System.out.println(value);
    }
}
