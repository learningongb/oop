package Model;

import Controller.Interfaces.iGetModel;
import Model.Core.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Модель хранит данные в hashmap. В качестве ключа используется id студента
 */
public class ModelClassHash implements iGetModel {
    /**
     * Студенты, хранящиеся в экземлпяре класса
     */
    private HashMap<Long, Student> students;

    /**
     * Конструктор на основании списка студентов
     * @param students
     */
    public ModelClassHash(List<Student> students) {
        this.students = new HashMap<Long, Student>();
        for (Student student : students) {
            this.students.put(((long) student.getId()), student);
        }
    }

    @Override
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        for (Long key : students.keySet()) {
            studentList.add(students.get(key));
        }
        return studentList;
    }

    @Override
    public boolean containsNumStudent(int numStudent) {
        return students.keySet().size()  >= numStudent;
    }

    @Override
    public boolean deleteByNumber(int numStudent) {
        students.remove(students.keySet().toArray()[numStudent - 1]);
        return true;
    }
}
