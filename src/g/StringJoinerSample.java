package g;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringJoinerSample {
    public static void main(String[] args) {
        StringJoinerSample sample = new StringJoinerSample();
        sample.joinStringOnlyComma(new String[]{"StudyHard", "GodOfJava", "Book"});
        sample.joinString(new String[]{"StudyHard", "GodOfJava", "Book"});
        sample.withCollector(new String[]{"StudyHard", "GodOfJava", "Book"});
    }

    public void joinString(String[] stringArray) {
        StringJoiner joiner = new StringJoiner(",","(",")");
        for(String string : stringArray) {
            joiner.add(string);
        }
        System.out.println(joiner);
    }

    public void joinStringOnlyComma(String[] stringArray) {
        StringJoiner joiner = new StringJoiner(",");
        for(String string : stringArray) {
            joiner.add(string);
        }
        System.out.println(joiner);
    }

    //람다, 스트림
    public void withCollector(String[] stringArray) {
        List<String> stringList = Arrays.asList(stringArray);
        String result = stringList.stream().collect(Collectors.joining(","));

        System.out.println(result);
    }

    private void predicateLambda() {
        Predicate<String> predicateLength5 = (a) -> a.length() > 5;
        Predicate<String> predicateContains = (a) -> a.contains("God");
        Predicate<String> predicateStart = (a) -> a.startsWith("God");
    }
}
