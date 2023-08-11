
import java.util.Objects;

public class Person {

    protected String name;
    protected String surname;
    protected int age;

    protected String city;


    //Contructor with an age and adress
    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    //Constructor without address
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    //Constructor without age and address
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    //Costructor without age

    public Person(String name, String surname, String city) {
        this.name = name;
        this.surname = surname;
        this.city = city;
    }

    public boolean hasAge() {
        return this.age != 0;
    }

    public boolean hasAddress() {
        return this.city != null;
    }

    public PersonBuilder newChildBuilder() {

        PersonBuilder pb = new PersonBuilder();

        if (this.name != null) {
            pb.setName(this.name);
        }
        if (this.surname != null) {
            pb.setSurname(this.surname);
        }

        if (this.age != 0) {
            pb.setAge(this.age - 20);
        }

        if (this.city != null) {
            pb.setAddress(this.city);
        }
        return pb;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalStateException("Возраст не может быть отрицательным!");
        }
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String city) {
        this.city = city;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void happyBirthday() {
        if (this.hasAge()) {
            this.age += 1;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (!this.hasAge() ? "Неизвестно" : age) +
                ", city='" + (!this.hasAddress() ? "Неизвестно" : city) + '\'' +
                '}';
    }


}
