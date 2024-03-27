package study.일급컬렉션.case1;

import java.util.List;
import java.util.Optional;

class BClass {
    private List<Student> students;

    public void validateSize(List<Student> students) {
        if (students.size() > 30) {
            throw new IllegalArgumentException("학생 수가 30명이 넘으면 안됩니다!");
        }
    }

    public Student findStudentByName(String name) {
        return students.stream()
                .filter(student -> student.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("이름을 찾을 수 없습니다."));
    }
}
