package demo.design.mediator.imp;

import demo.design.mediator.abs.Mediator;

public class ColleagueA extends Colleague {
    // ����ͬ����̳���Colleague,�˿̾Ϳ������н���mediator����ͨ����
    public ColleagueA(String name, Mediator mediator) {
        super(name, mediator);
    }
    public void getMessage(String message){
        System.out.println("ͬ��A"+name+"�����Ϣ"+message);
    }
    //ͬ��A���н���ͨ��
    public void contact(String message){
        mediator.contact(message, this);
    }
}
