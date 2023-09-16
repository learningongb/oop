/**
 * Класс Student.
 * Наследуется от класса Person.
 * 
 * Добавляет поле id, которое автоматически присваивается при создании экземпляра.
 * 
 * Реализован интерфейс Comparable, сравнивающий студентов по Имени, а если имена одинаковые, то по возрасту.
 *
 */
public class Student<T extends Comparable<T>, V> extends Person<T, V> implements Comparable<Student<T, V>> {

	/** Счетчик идентификаторов по всем объектам класса*/
	private V generalId;

	/** Идентификатор текущего объекта */
	private V id;

	/**
	 * Создает нового студента
	 * @param name Имя
	 * @param age Возраст
	 */
	public Student<T extends Comparable<T>, V>(T name, V age_) {
		super(name, age_);
//		this.id = generalId++;
	}

	@Override
	public int compareTo(Student o) {
		return 1;//super.getName().compareTo(o.getName());
//		if (super.getAge() == o.getAge()) {
//			if (id == o.id)
//				return 0;
//			if (id > o.id)
//				return 1;
//			else
//				return -1;
//		}

//		if (super.getAge() > o.getAge())
//			return 1;
//		else
//			return -1;
	}

	/** Возвращает id
	 * @return id
	 */
	public V getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Students [age=" + super.getAge() + ", name=" + super.getName() + ", id=" + id + "]";
	}

}
