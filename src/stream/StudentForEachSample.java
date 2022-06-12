package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentForEachSample {
    public static void main(String[] args) {
        StudentForEachSample sample = new StudentForEachSample();
        List<StudentDTO> studentList = new ArrayList<>();
        studentList.add(new StudentDTO("요다", 43, 99, 10));
        studentList.add(new StudentDTO("만듀", 30, 71, 85));
        studentList.add(new StudentDTO("찐빵", 32, 81, 75));

        sample.printStudentName(studentList);
        sample.printStudentAge(studentList);
        sample.printStudentScoreMath(studentList);
        sample.printStudentScoreEnglish(studentList);
        sample.multipleThreeStream();
    }

    private void printStudentScoreEnglish(List<StudentDTO> students) {
        System.out.println("PrintStudentScoreEnglish");
        //students.stream().forEach(student -> System.out.println(student.getScoreEnglish()));
        //students.stream().map(student -> student.getScoreEnglish()).forEach(engScore -> System.out.println(engScore));
        students.stream().map(student -> student.getScoreEnglish()).forEach(System.out::println);
    }

    private void printStudentScoreMath(List<StudentDTO> students){
        System.out.println("PrintStudentScoreMath");
        students.stream().forEach(student -> System.out.println(student.getScoreMath()));
        students.stream().map(student -> student.getScoreMath()).forEach(mathScore -> System.out.println(mathScore));
    }

    private void printStudentAge(List<StudentDTO> students) {
        //SameCode
        System.out.println("PrintStudentAge");
        students.stream().forEach(student -> System.out.println(student.getAge()));
        students.stream().map(student -> student.getAge()).forEach(age -> System.out.println(age));
        students.stream().map(x -> x.getAge()).forEach(x -> System.out.println(x));
    }

    public void printStudentName(List<StudentDTO> students) {
        //Same Code
        System.out.println("PrintStudentName");
        students.stream().forEach(student -> System.out.println(student.getName()));
//        students.stream().map(student -> student.getName()).forEach(name -> System.out.println(name));
//        students.stream().map(student -> student.getName()).forEach(x -> System.out.println(x));
    }

    private void multipleThreeStream() {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //intList.stream().map(x -> x * 3).forEach(System.out::println);
        intList.stream().forEach(value -> System.out.println(value + " * 3 = " + (value* 3)));
    }

    private void collectStudentNameList(List<StudentDTO> students) {
        //Name만 List르 반한
        List<String> nameList = students.stream().map(student -> student.getName()).collect(Collectors.toList());

    }

}
