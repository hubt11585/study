package demo.design.state.inf;

public interface State {
    /*²åÈëÓ²±Ò*/
    public void insertCoin();
    /*Å¤Ò»Å¤*/
    public void returnCoin();
    /*ÍË±Ò*/
    public void turnCrank();
    /*½á¹û*/
    public void dispense();
    /*´òÓ¡×´Ì¬*/
    public void printstate();
}
