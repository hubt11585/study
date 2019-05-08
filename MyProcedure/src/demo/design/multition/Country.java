package demo.design.multition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Country {

    private static int maxNumOfCountry = 2; // ������������
    private static List<Country> countryList = new ArrayList<Country>(); // ������������
    private String countryName = "";
    private Country(){
        //˽�й��캯��
    }

    private Country(String countryName){
        this.countryName = countryName;
    }
    //ʹ�þ�̬����飺�����������ҷ���list��
    static {
        countryList.add(new Country("�й�"));
        countryList.add(new Country("����"));
    }
    public static Country getInstance(){
        Random random = new Random(); //�����
        int randomNumber = random.nextInt(maxNumOfCountry);
        System.out.println("��ȡ�������Ϊ��"+randomNumber);
        return countryList.get(randomNumber);
    }
    public void getName(){
        System.out.println("��������Ϊ��"+countryName);
    }
}
