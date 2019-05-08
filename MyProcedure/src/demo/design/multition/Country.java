package demo.design.multition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Country {

    private static int maxNumOfCountry = 2; // 存在两个国家
    private static List<Country> countryList = new ArrayList<Country>(); // 存在两个国家
    private String countryName = "";
    private Country(){
        //私有构造函数
    }

    private Country(String countryName){
        this.countryName = countryName;
    }
    //使用静态代码块：创建两个国家放入list中
    static {
        countryList.add(new Country("中国"));
        countryList.add(new Country("美国"));
    }
    public static Country getInstance(){
        Random random = new Random(); //随机数
        int randomNumber = random.nextInt(maxNumOfCountry);
        System.out.println("获取的随机数为："+randomNumber);
        return countryList.get(randomNumber);
    }
    public void getName(){
        System.out.println("国家名称为："+countryName);
    }
}
