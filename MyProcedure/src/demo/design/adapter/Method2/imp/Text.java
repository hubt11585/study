package demo.design.adapter.Method2.imp;

public class Text {
    public static void main(String[] args) {

        Videophone videophone = new Videophone(new MobilePhone());
        videophone.currency();
    }
}
