package demo.test;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {

        return this.name.hashCode() + age * 37;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age == p.age;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Person@name:" + this.name + " age:" + this.age;
    }

    @Override
    public int compareTo(Person p) {
        if (this.age > p.age) {
            return 1;
        } else if (this.age < p.age) {
            return -1;
        }
        return this.name.compareTo(p.name);
    }
}
