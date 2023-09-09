package Controller.Interfaces;

import Model.Core.Student;

import java.util.List;

/**
 * Интерфейс работы с моделью
 */
public interface iGetModel {
    /**
     * Получить список студентов модели
     * @return список студентов модели
     */
    public List<Student> getStudents();

    /**
     * Номер студента есть в списке студентов модели
     * @param numStudent номер студента
     * @return
     */
    boolean containsNumStudent(int numStudent);

    /**
     * Удаляет студента из модели по номеру элемента
     * @param numStudent номер элемента
     * @return
     */
    boolean deleteByNumber(int numStudent);
}
