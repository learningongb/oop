package Domen;

import java.util.Iterator;
import java.util.List;

public class GroupIterator implements Iterator<StudentGroup>{

	private int counter;
	private List<StudentGroup> groups;
	public GroupIterator(List<StudentGroup> groups) {
		this.groups = groups;
	}
	@Override
	public boolean hasNext() {
		return counter < groups.size();
	}
	@Override
	public StudentGroup next() {
		return groups.get(counter++);
	}
	
}
