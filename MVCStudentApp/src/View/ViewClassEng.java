package View;

import Controller.DeleteResult;
import Controller.Interfaces.iGetView;
import Model.Core.Student;

import java.util.List;
import java.util.Scanner;

/**
 * Класс представления данных на руссоком языке
 */
public class ViewClassEng implements iGetView {

    @Override
    public void printAllStudent(List<Student> students) {
        System.out.println("**************Student list**************");
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
        System.out.println("Welcome to the Student Viewing program");
    }

    @Override
    public void printGoodbye() {
        System.out.println("Exiting program");
    }

    @Override
    public String textSelectCommand() {
        return "Type command:";
    }

    @Override
    public void printCommands() {
        System.out.println("LIST - print list");
        System.out.println("DELETE - delete record");
        System.out.println("HELP - print this help");
        System.out.println("EXIT - exit program");
    }

    @Override
    public void printDeleteResult(DeleteResult result) {
        if (result == DeleteResult.OK) {
            System.out.println("Student deleted");
        } else if (result == DeleteResult.ERROR) {
            System.out.println("Error. Student not deleted");
        } else if (result == DeleteResult.NOTFOUND) {
            System.out.println("Student not found");
        }
    }

    @Override
    public int getStudentNumber() {
        return Integer.decode(prompt("Enter student number:"));
    }

}
