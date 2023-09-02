import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Domen.Student;
import Domen.StudentGroup;
import Domen.StudentSteam;

public class App {
	public static void main(String[] args) throws Exception {
		Student s1 = new Student("Иван", 25);
		Student s2 = new Student("Игорь", 23);
		Student s3 = new Student("Иван", 22);
		Student s4 = new Student("Игорь", 23);
		Student s5 = new Student("Даша", 23);
		Student s6 = new Student("Лена", 23);

		List<Student> listStud = new ArrayList<Student>();
		listStud.add(s1);
		listStud.add(s2);
		listStud.add(s3);
		listStud.add(s4);
		listStud.add(s5);
		listStud.add(s6);

		StudentGroup group4580 = new StudentGroup(listStud, 4580);
		System.out.println("Вывод StudentGroup.toString() =========================================================");
		System.out.println(group4580);
//
//		for (Student std : group4580) {
//			System.out.println(std);
//		}
//
//		System.out.println("=========================================================");
//
//		Collections.sort(group4580.getGroup());
//
//		for (Student std : group4580.getGroup()) {
//			System.out.println(std);
//		}
		StudentSteam steam1 = new StudentSteam(5);
		steam1.add(group4580);
		
		StudentGroup group4581 = new StudentGroup(4581);
		group4581.add(new Student("Яков", 22));
		group4581.add(new Student("Михаил", 21));
		steam1.add(group4581);
		
		System.out.println();
		System.out.println("Вывод StudentSteam.toString() =========================================================");
		System.out.println(steam1);
		
		System.out.println();
		System.out.println("Вывод StudentSteam.forEach() + StudentGroup.toString() =========================================================");
		for (StudentGroup gr: steam1) {
			System.out.println(gr);
		}
		
		Collections.sort(steam1.getGroups());
		System.out.println();
		System.out.println("Вывод StudentSteam.toString() после сортировки =========================================================");
		System.out.println(steam1);
		
		steam1.sortSteam();
		System.out.println();
		System.out.println("Вывод StudentSteam.toString() после сортировки групп и студентов в них =========================================================");
		System.out.println(steam1);
		
	}
}
