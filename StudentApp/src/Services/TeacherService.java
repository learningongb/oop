package Services;

import Domen.PersonComparator;
import Domen.Teacher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TeacherService implements iPersonService<Teacher>{

    private int count;
    private List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<Teacher>();
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public void create(String name, int age) {
        Teacher teacher = new Teacher(name, age, "basic");
        count++;
        teachers.add(teacher);
    }

    public void print() {
        Collections.sort(this.teachers, new PersonComparator<Teacher>());
        for (Teacher teacher : this.teachers) {
            System.out.println(teacher);
        }
    }
}
