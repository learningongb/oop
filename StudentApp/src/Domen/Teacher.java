package Domen;

public class Teacher extends Person {
	private String acadDegree;

	public Teacher(String firstName, int age, String acadDegree) {
		super(firstName, age);
		this.acadDegree = acadDegree;
	}

	@Override
	public String toString() {
		return super.toString() + "acadDegree='" + acadDegree + '\'';
	}
}
