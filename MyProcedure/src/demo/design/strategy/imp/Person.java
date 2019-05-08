package demo.design.strategy.imp;

/**
 *
 * @ClassName   : Person
 * @Description : Ӧ�ó�����
 *
 */
public class Person {

    private String name;    //����
    private Integer age;    //����
    private Car car;        //ӵ�г�

    public void driver(Car car){
        System.out.print(name +"  "+ age+" �� "+" ����");
        car.run();
    }

    public Person(String name,Integer age) {
        this.name=name;
        this.age=age;
    }
}
