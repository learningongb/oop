package Domen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StudentSteam implements Iterable<StudentGroup>{

	private int steamNumber;
	
	private List<StudentGroup> groups;
	

	public StudentSteam(int steamNumber) {
		groups = new ArrayList<StudentGroup>();
		this.steamNumber = steamNumber;
	}
	
	public void add(StudentGroup group) {
		groups.add(group);
	}
	
	public boolean remove(StudentGroup group) {
		if (groups.contains(group)) {
			groups.remove(group);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Номер потока: ");
		sb.append(this.steamNumber);
		sb.append(", количество групп: ");
		sb.append(this.groups.size());
		sb.append("\n");
		for (StudentGroup gr: groups) {
			for (Student s: gr) {
				sb.append(s.getName() + ", группа: " + gr.getIdGroup() + "\n");
			}
		}
		return sb.toString();
	}

	@Override
	public Iterator<StudentGroup> iterator() {
		return new GroupIterator(groups);
	}
	
	
	
}
