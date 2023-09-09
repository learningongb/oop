package Model;

import Controller.Interfaces.iGetModel;
import Model.Core.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Модель читает данные из файла и сохраняет в файл
 */
public class ModelClassFile implements iGetModel {
    /**
     * Имя файла со списком студентов
     */
    private String fileName;

    /**
     * Создает экземпляр класса.
     * При создании проверяется возможность записи в файл.
     * @param fileName
     */
    public ModelClassFile(String fileName) {
        this.fileName = fileName;

        try(FileWriter fw = new FileWriter(fileName, true))
        {
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // @Override
    public List<Student> getStudents() {
        List<Student> students  = new ArrayList<Student>();
        try
        {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null)
            {
                String[] param = line.split(" ");
                Student pers = new Student(param[0], Integer.parseInt(param[1]));
                students.add(pers);
                line = reader.readLine();
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return students;
    }

    @Override
    public boolean containsNumStudent(int numStudent) {
        return getStudents().size() >= numStudent;
    }

    @Override
    public boolean deleteByNumber(int numStudent) {
        List<Student> students = getStudents();
        students.remove(numStudent - 1);
        saveAllStudentToFile(students);
        return true;
    }

    /**
     * Сохраняет переданный список студентов в файл
     * @param students
     */
    public void saveAllStudentToFile(List<Student> students)
    {
        try(FileWriter fw = new FileWriter(fileName, true))
        {
            for(Student pers : students)
            {
                fw.write(pers.getName()+" "+pers.getAge()+" "+pers.getId());
                fw.append('\n');
            }
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
