package demo.knowledgepoints.cglib;

public class BaseDemo {

    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "BaseDemo{" +
                "Name='" + Name + '\'' +
                '}';
    }
}
