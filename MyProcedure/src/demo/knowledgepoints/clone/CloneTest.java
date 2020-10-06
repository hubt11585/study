package demo.knowledgepoints.clone;

public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        /*************** 设置好原对象信息 *****************/
        Dog dogSource = new Dog(12,"li");
        DogSchool dogSchool = new DogSchool();
        dogSchool.setAddress("hangzhou");
        dogSource.setDogSchool(dogSchool);

        /*************** 进行对象拷贝，并且修改原对象的值 *****************/
        Dog dogTarget = (Dog) dogSource.clone();
        dogSource.getDogSchool().setAddress("shanghai");
        dogSource.setAge(14);

        System.out.println("dogSource.age:"+dogSource.getAge());
        System.out.println("dogSource.dogSchool.address:"+dogSource.getDogSchool().getAddress());
        System.out.println("dogTarget.age:"+dogTarget.getAge());
        System.out.println("dogTarget.dogSchool.address:"+dogTarget.getDogSchool().getAddress());
        System.out.println("dogTarget.dog:"+dogSource.getDogSchool());
        System.out.println("dogTarget.dog:"+dogTarget.getDogSchool());
    }
}
