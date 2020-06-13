package demo.knowledgepoints.jsr;

import javax.validation.constraints.NotNull;

public class Jsr {

    @NotNull
    private int id;
    @NotNull
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return "Jsr{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Jsr().toString());
    }
}
