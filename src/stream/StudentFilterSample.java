package stream;

import java.util.ArrayList;
import java.util.List;

public class StudentFilterSample {
    public static void main(String[] args) {
        StudentFilterSample sample = new StudentFilterSample();
        List<StudentDTO> studentList = new ArrayList<>();
        studentList.add(new StudentDTO("요다", 43, 99, 10));
        studentList.add(new StudentDTO("만듀", 30, 71, 85));
        studentList.add(new StudentDTO("찐빵", 32, 81, 75));
        //sample.filterWithScoreForLoop(studentList, 80);
        sample.filterWithScoreStream(studentList, 80);
    }

    private void filterWithScoreForLoop(List<StudentDTO> studentList, int scoreCutLine) {
        for(StudentDTO student : studentList) {
            if(student.getScoreMath() > scoreCutLine) {
                System.out.println(student.getName());
            }
        }
    }
    private void filterWithScoreStream(List<StudentDTO> studentList, int scoreCutLine) {
        studentList.stream().filter(x -> x.getScoreMath() > scoreCutLine).forEach(x -> System.out.println(x.getName()));
    }
}
