package Domen;

/**
 * Класс Teacher.
 * Наследуется от класса Person.
 *
 * Добавляет поле acadDegree, которое хранит ученую степень.
 *
 */
public class Teacher<T extends Teacher> extends Person<Person> {
	/**
	 * Ученая степень
	 */
	private String acadDegree;

	/**
	 * Конструктор, заполняющий все поля класса
	 * @param firstName имя
	 * @param age возвраст
	 * @param acadDegree ученая степень
	 */
	public <T>Teacher(String firstName, int age, String acadDegree) {
		super(firstName, age);
		this.acadDegree = acadDegree;
	}

	@Override
	public String toString() {
		return super.toString() + "acadDegree='" + acadDegree + '\'';
	}
}
