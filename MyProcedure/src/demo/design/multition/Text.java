package demo.design.multition;

public class Text {
    public static void main(String[] arg){
        //��ȡ10�η����������
        for(int i = 0 ;i< 10; i++){
            Country country = Country.getInstance();
            country.getName();
        }
    }
}
