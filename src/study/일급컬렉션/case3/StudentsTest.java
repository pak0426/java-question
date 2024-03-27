package study.일급컬렉션.case3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentsTest {

    @Test
    void setter를_사용() {
        List<Student> list = new ArrayList<>();
        Student studentA = new Student("A", 12);
        Student studentB = new Student("B", 12);
        list.add(studentA);
        list.add(studentB);
        Students students = new Students(list);

        for (Student s : students.getStudents()) {
            System.out.println("s = " + s.getName());
        }

        Student studentC = new Student("C", 12);
        list.add(studentC);
        students.setStudents(list);
        for (Student s : students.getStudents()) {
            System.out.println("s = " + s.getName());
        }
    }

    @Test
    void 일급컬렉션은_불변이_아니다() {
        // given
        List<Student> list = new ArrayList<>();
        list.add(new Student("A", 12));
        Students students = new Students(list);
        int size1 = students.getStudents().size();

        // when
        list.add(new Student("B", 12));
        int size2 = students.getStudents().size();

        // then
        System.out.println("size1 = " + size1);
        System.out.println("size2 = " + size2);
        assertNotEquals(size1, size2);
    }

    @Test
    void 일급컬렉션은_불변이_아니다2() {
        // given
        List<Student> list = new ArrayList<>();
        list.add(new Student("A", 12));
        Students students = new Students(list);
        int size1 = students.getStudents().size();

        // when
        students.getStudents().add(new Student("B", 12));
        int size2 = students.getStudents().size();

        // then
        System.out.println("size1 = " + size1);
        System.out.println("size2 = " + size2);
        assertNotEquals(size1, size2);
    }
}