package demo.design.state.inf;

public interface State {
    /*����Ӳ��*/
    public void insertCoin();
    /*ŤһŤ*/
    public void returnCoin();
    /*�˱�*/
    public void turnCrank();
    /*���*/
    public void dispense();
    /*��ӡ״̬*/
    public void printstate();
}
