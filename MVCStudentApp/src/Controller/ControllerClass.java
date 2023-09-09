package Controller;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Core.Student;
import View.ViewClass;
import View.ViewClassEng;

import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер, управляющий связью модели и представления.
 * Поддерживает работу со списком моделей.
 */
public class ControllerClass {

    /**
     * Список моделей
     */
    private List<iGetModel> models;

    /**
     * Используемое представление
     */
    private iGetView view;

    /**
     * Список студентов - (сейчас не используется)
     */
    private List<Student> students = new ArrayList<Student>();

    /**
     * Конструктор использующий список моделей и заданное представление данных
     * @param models
     * @param view
     */
    public ControllerClass(List<iGetModel> models, iGetView view) {
        newControllerClass(models, view);
    }

    /**
     * Конструктор использующий одну модель. Используемое представление данных будет запрошено у пользователя.
     * @param model
     */
    public ControllerClass(iGetModel model) {
        iGetView selectedView = selectView();
        newControllerClass(model, selectedView);
    }

    /**
     * Конструктор использующий список моделей. Используемое представление данных будет запрошено у пользователя.
     * @param models
     */
    public ControllerClass(List<iGetModel> models) {
        iGetView selectedView = selectView();
        newControllerClass(models, selectedView);
    }

    /**
     * Конструктор использующий одну модель и заданное представление данных
     * @param model
     * @param view
     */
    public ControllerClass(iGetModel model, iGetView view) {
        List<iGetModel> newModels = new ArrayList<>();
        newModels.add(model);
        newControllerClass(newModels, view);
    }

    /**
     * Запрашивает у пользователя используемое представление данных.
     * По-умолчанию будет использоваться русский язык.
     * @return выбранное пользователем представление.
     */
    private iGetView selectView() {
        iGetView selectedView = new ViewClass();;
        String language = selectedView.prompt("Выберите язык (En, Ru) (по-умолчанию Ru):").toUpperCase();
        if (language.equals("EN")) selectedView = new ViewClassEng();
        selectedView.printHello();
        return selectedView;
    }

    /**
     * Заполняет созданный контролер одной моделью. Вызвается из констукторов.
     * @param model
     * @param view
     */
    private void newControllerClass(iGetModel model, iGetView view) {
        List<iGetModel> newModels = new ArrayList<>();
        newModels.add(model);
        newControllerClass(newModels, view);
    }
    /**
     * Заполняет созданный контролер списком моделей. Вызвается из констукторов.
     * @param models
     * @param view
     */
    private void newControllerClass(List<iGetModel> models, iGetView view) {
        this.models = models;
        this.view = view;
    }

    /**
     * Проверяет заполнение списка студентов. Не используется
     * @param stud
     * @return
     */
    private boolean testData(List<Student> stud) {
        if (stud.size()>0)
            return true;
        return false;
    }

    /**
     * Выводит список студентов. Не используется.
     */
    public void update() {
        // MVC
        // Данные сразу передаются из модели во вьюшку
        //view.printAllStudent(model.getStudents());

        // MVP
        students = models.get(0).getStudents();
        // Какие-то действия с данными
        if(testData(students)) {
            view.printAllStudent(students);
        } else {
            System.out.println("Список студентов пуст!");
        }
    }

    /**
     * Выполняет попытку удаления студента из общего списка по номеру.
     * Фактически элемент удаляется из той модели, в которой находится этот номер.
     * Возвращает результат удаления.
     * @param numStudent
     * @return
     */
    private DeleteResult deleteStudent(int numStudent) {
        DeleteResult result = DeleteResult.NOTFOUND;
        for (iGetModel model : models) {
            if (model.containsNumStudent(numStudent)) {
                if (model.deleteByNumber(numStudent)) {
                    result = DeleteResult.OK;
                } else {
                    result = DeleteResult.ERROR;
                }
                break;
            } else {
                numStudent -= model.getStudents().size();
            }
        }
        return result;
    }

    /**
     * Возвращает список студентов из всех моделей
     * @return
     */
    private List<Student> getStudents() {
        List<Student> allStudents = new ArrayList<>();
        for (iGetModel model : models) {
            allStudents.addAll(model.getStudents());
        }
        return allStudents;
    }

    /**
     * Ожидает команду пользователя и выполняет ее, пока не встерит команду exit
     */
    public void run() {
        Command com = Command.NONE;
        boolean getNewIter = true;
        while (getNewIter) {
            String command = view.prompt(view.textSelectCommand());
            com = Command.valueOf(command.toUpperCase());
            switch (com)
            {
                case EXIT:
                    getNewIter = false;
                    view.printGoodbye();
                    break;
                case LIST:
                    // Модель MVC
                    view.printAllStudent(getStudents());
                    break;
                case DELETE:
                    int numStudent = view.getStudentNumber();
                    view.printDeleteResult(deleteStudent(numStudent));
                    break;
                case HELP:
                    view.printCommands();
                    break;
            }
        }
    }

}
