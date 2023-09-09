package Model;

import Controller.Interfaces.iGetModel;
import Model.Core.Student;

import java.util.List;

/**
 * Модель хранит данные в ArrayList
 */
public class ModelClassList implements iGetModel {
    /**
     * Студенты, хранящиеся в экземлпяре класса
     */
    private List<Student> students;

    /**
     * Конструктор на основании списка студентов
     * @param students
     */
    public ModelClassList(List<Student> students) {
        this.students = students;
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public boolean containsNumStudent(int numStudent) {
        return getStudents().size()  >= numStudent;
    }

    @Override
    public boolean deleteByNumber(int numStudent) {
        students.remove(numStudent - 1);
        return true;
    }
}
