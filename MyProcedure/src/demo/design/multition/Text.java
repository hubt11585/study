package demo.design.multition;

public class Text {
    public static void main(String[] arg){
        //获取10次方法测试情况
        for(int i = 0 ;i< 10; i++){
            Country country = Country.getInstance();
            country.getName();
        }
    }
}
