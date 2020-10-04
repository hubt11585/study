package demo.clone;

public class Dog implements Cloneable{
    public int age;
    public String name;
    public DogSchool dogSchool;

    public Dog(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DogSchool getDogSchool() {
        return dogSchool;
    }

    public void setDogSchool(DogSchool dogSchool) {
        this.dogSchool = dogSchool;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Dog dog = (Dog)super.clone();
        dog.setDogSchool((DogSchool)this.dogSchool.clone());
        return dog;
    }
}
