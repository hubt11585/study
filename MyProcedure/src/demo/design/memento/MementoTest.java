package demo.design.memento;

public class MementoTest {
    public static void main(String[] args) {

        Originator o = new Originator();
        Caretaker c = new Caretaker();
        //�ı为���˶����״̬
        o.setState("On");
        //��������¼���󣬲��������˶����״̬��������
        c.saveMemento(o.createMemento());
        //�޸ķ����˵�״̬
        o.setState("Off");
        //�ָ������˶����״̬
        o.restoreMemento(c.retrieveMemento());

        System.out.println(o.getState());
    }
}
