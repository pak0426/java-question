package study.일급컬렉션.case3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Students {
    private List<Student> students;

    public Students(List<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    @Override
    public String toString() {
        return "Students{" +
                "students=" + students +
                '}';
    }
}
