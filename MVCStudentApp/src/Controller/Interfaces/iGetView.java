package Controller.Interfaces;

import Controller.DeleteResult;
import Model.Core.Student;

import java.util.List;

/**
 * Интерфейс для работы с представлением данных
 */
public interface iGetView {
    /**
     * Вывести список студентов
     * @param students список студентов
     */
    void printAllStudent(List<Student> students);

    /**
     * Запросить ввод данных от пользователя
     * @param s текст командной строки
     * @return
     */
    String prompt(String s);

    /**
     * Напечатать приветстиве при начале работы программы
     */
    void printHello();

    /**
     * Напечатать сообщение о завершении работы программы
     */
    void printGoodbye();

    /**
     * Текст предложения ввода команды
     * @return
     */
    String textSelectCommand();

    /**
     * Вывести список команд
     */
    void printCommands();

    /**
     * Вывести результат удаления записи пользователю
     * @param result результат удаления записи
     */
    void printDeleteResult(DeleteResult result);

    /**
     * Получить от пользователя номер студента
     * @return номер студента
     */
    int getStudentNumber();
}
