package demo.design.memento;

public class Caretaker {
    private Memento memento;
    /**
     * ����¼��ȡֵ����
     */
    public Memento retrieveMemento(){
        return this.memento;
    }
    /**
     * ����¼�ĸ�ֵ����
     */
    public void saveMemento(Memento memento){
        this.memento = memento;
    }
}
