package View;

import Controller.DeleteResult;
import Model.Core.Student;
import Controller.Interfaces.iGetView;

import java.util.List;
import java.util.Scanner;

/**
 * Класс представления данных на руссоком языке
 */
public class ViewClass implements iGetView {

    @Override
    public void printAllStudent(List<Student> students) {
        System.out.println("**************Список студентов**************");
        int num = 1;
        for (Student student : students) {
            System.out.println(num++ + ". " + student);
        }
        System.out.println("********************************************");
    }

    @Override
    public String prompt(String s) {
        Scanner in = new Scanner(System.in);
        System.out.println(s);
        return in.nextLine();
    }

    @Override
    public void printHello() {
        System.out.println("Добро пожаловать в программу просмотра студентов");
    }

    @Override
    public void printGoodbye() {
        System.out.println("Выход из программы");
    }

    @Override
    public String textSelectCommand() {
        return "Введите команду:";
    }

    @Override
    public void printCommands() {
        System.out.println("LIST - вывести список");
        System.out.println("DELETE - удалить");
        System.out.println("HELP - вывод этой подсказки");
        System.out.println("EXIT - завершение работы");
    }

    @Override
    public void printDeleteResult(DeleteResult result) {
        if (result == DeleteResult.OK) {
            System.out.println("Студент удален");
        } else if (result == DeleteResult.ERROR) {
            System.out.println("Ошибка при удалении студента");
        } else if (result == DeleteResult.NOTFOUND) {
            System.out.println("Студент не найден");
        }
    }

    @Override
    public int getStudentNumber() {
        return Integer.decode(prompt("Введите номер студента:"));
    }
}
