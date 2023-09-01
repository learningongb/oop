package Domen;

public class Emploee extends Person{

    String specialty;

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Emploee(String name, int age, String specialty) {
        super(name, age);
        this.specialty = specialty;
    }
}
