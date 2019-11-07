package demo.knowledgepoints.annotation;

import java.io.Serializable;

@MyAnnotaion("student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @MyFieldAnnotaion(value = "1",type = "int",lengths = "10")
    String id;
    @MyFieldAnnotaion(value = "¿Ÿ¿Ÿ",type = "String" ,lengths = "200")
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
