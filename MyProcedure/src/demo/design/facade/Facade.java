package demo.design.facade;

public class Facade {

    private SubSystemA obj1 = null;
    private SubSystemB obj2 = null;
    private SubSystemC obj3 = null;
    // ¹¹Ôìº¯Êý
    public Facade(){
        obj1 = new SubSystemA();
        obj2 = new SubSystemB();
        obj3 = new SubSystemC();
    }

    public void Method()
    {
        obj1.MethodA();
        obj2.MethodB();
        obj3.MethodC();
    }
}
