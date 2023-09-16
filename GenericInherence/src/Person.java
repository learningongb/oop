public class Person<T extends Comparable<T>, V> {
    /** Имя */
    private T name;
    /** Возраст */
    private V age;

    /**
     * Конструктор принимает параметры name и age
     * @param name имя
     * @param age возраст
     */
    public Person<T, V>(T _name, V _age) {
        this.name = _name;
        this.age = _age;
    }

    /**
     * Возвращает name
     * @return name
     */
    public T getName() {
        return name;
    }

    /**
     * Изменяет name
     */
    public void setName(T name) {
        this.name = name;
    }

    /**
     * Возвращает age
     * @return age
     */
    public V getAge() {
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
