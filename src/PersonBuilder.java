
public class PersonBuilder {

    protected String name;
    protected String surname;
    protected int age;
    protected String city;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalStateException("Возраст не может быть отрицательным!");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Имя и фамилия обязательны для ввода!");
        } else if (this.age == 0 && this.city == null) {
            return new Person(this.name, this.surname);
        }

        if (this.age == 0) {
            return new Person(this.name, this.surname, this.city);
        } else if (this.city == null) {
            return new Person(this.name, this.surname, this.age);
        }

        return new Person(this.name, this.surname, this.age, this.city);


    }

}
