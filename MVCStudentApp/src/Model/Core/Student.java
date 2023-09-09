package Model.Core;

/**
 * Класс Student.
 * Наследуется от класса Person.
 * 
 * Добавляет поле id, которое автоматически присваивается при создании экземпляра.
 * 
 * Реализован интерфейс Comparable, сравнивающий студентов по Имени, а если имена одинаковые, то по возрасту.
 *
 */
public class Student extends Person {

	/** Счетчик идентификаторов по всем объектам класса*/
	private static int generalId;

	/** Идентификатор текущего объекта */
	private int id;

	/**
	 * Создает нового студента
	 * @param name Имя
	 * @param age Возраст
	 */
	public Student(String name, int age) {
		super(name, age);
		this.id = ++generalId;
	}

	/** Возвращает id
	 * @return id
	 */
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Students [age=" + super.getAge() + ", name=" + super.getName() + ", id=" + id + "]";
	}

}
