package Domen;

/**
 * Абстрактный класс. Содержит поля:
 * name: String - имя
 * age: int - возраст
 * 
 * Реализованые геттеры и сеттеры полей, а так же метод toString,
 * возвращающий представление вида "Person [name=<name>, age=<age>]".
 *
 */
public abstract class Person<T extends Person> {
	/** Имя */
	private String name;
	/** Возраст */
	private int age;

	/**
	 * Конструктор принимает параметры name и age
	 * @param name имя
	 * @param age возраст
	 */
	public <T>Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * Возвращает name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Изменяет name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Возвращает age
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Изменяет age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
