import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Итератор списка студентов.
 * Создается на основании List<Student>.
 * Реализованы методы итератора hasNext() и next().
 *
 */
public class StudentIterator<T extends Comparable<T>, V> implements Iterator<Student<T, V>> {
	/** Номер следующего студента из переданного списка */
	private int counter;
	/** Список студентов */
	private final List<Student<T, V>> students;

	/**
	 * Создает итератор по переданному списку студентов
	 * @param students Список студентов
	 */
	public StudentIterator(List<Student<T, V>> students) {
		this.students = students;
		this.counter = 0;
	}

	@Override
	public boolean hasNext() {
		return counter < students.size();
	}

	@Override
	public Student<T, V> next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return students.get(counter++);
	}

}
