import Controller.ControllerClass;
import Controller.Interfaces.iGetModel;
import Model.Core.Student;
import Model.ModelClassFile;
import Model.ModelClassHash;
import Model.ModelClassList;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<iGetModel> models = new ArrayList<>();

        List<Student> students = new ArrayList<>();
        Student s1 = new Student("Сергей-", 21);
        Student s2 = new Student("Андрей-", 25);
        Student s3 = new Student("Иван-", 24);
        Student s4 = new Student("Дарья-", 23);
        Student s5 = new Student("Света-", 22);
        Student s6 = new Student("Игорь-", 21);
        Student s7 = new Student("Мария-", 21);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
        models.add(new ModelClassList(students));

        models.add(new ModelClassFile("StudentDB.csv"));

        List<Student> studentsM = new ArrayList<>();
        Student s11 = new Student("Сергей*", 21);
        Student s21 = new Student("Андрей*", 25);
        Student s31 = new Student("Иван*", 24);
        Student s41 = new Student("Дарья*", 23);
        Student s51 = new Student("Света*", 22);
        Student s61 = new Student("Игорь*", 21);
        Student s71 = new Student("Мария*", 21);
        studentsM.add(s11);
        studentsM.add(s21);
        studentsM.add(s31);
        studentsM.add(s41);
        studentsM.add(s51);
        studentsM.add(s61);
        studentsM.add(s71);
        models.add(new ModelClassHash(studentsM));

        //        iGetModel fModel = new ModelClassFile("StudentDB.csv");
//        fModel.saveAllStudentToFile(students);

//        ModelClassList model = new ModelClassList(students);
//        ViewClass view = new ViewClass();

        ControllerClass controller = new ControllerClass(models);
//        ControllerClass controller = new ControllerClass(fModel, view);
//        ControllerClass controller = new ControllerClass(model, view);
        controller.run();

//        ControllerClass controller2 = new ControllerClass(new ModelClassList(new ArrayList<Student>()), view);
//        controller2.update();
    }

}
