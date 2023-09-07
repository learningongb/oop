package Domen;

/**
 * Класс Employee.
 * Наследуется от класса Person.
 *
 * Добавляет поле special, которое хранит название специальности работника.
 *
 */
public class Employee<T extends Employee> extends Person<Employee>{
    /**
     * Название специальности
     */
    private String special;

    /**
     * Конструктор, заполняющий все поля класса
     * @param firstName имя
     * @param age возвраст
     * @param special специальность
     */
    public <T>Employee(String firstName, int age, String special) {
        super(firstName, age);
        this.special = special;
    }
}
