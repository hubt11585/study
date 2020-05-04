package demo.knowledgepoints.introspector;

public class Bean {
    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAgedddd(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
