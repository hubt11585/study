package demo.practice;

/***
 * ������3��
 * ��Ŀ����ӡ�����еġ�ˮ�ɻ���������ν��ˮ�ɻ�������ָһ����λ�������λ���������͵��ڸ����������磺153��һ����ˮ�ɻ���������Ϊ153=1�����η���5�����η���3�����η���
 */
public class Subject3 {
    public static void main(String[] args) {
        for(int i= 100 ; i<=999;i++){
            if(isNarcissus(i)){
                System.out.println("ˮ�ɻ�����"+i);
            }
        }
    }

    public static boolean  isNarcissus(int a){

        int num1 = 0;  //��λ
        int num2 = 0;  //ʮλ
        int num3 = 0;  //��λ
        num3 = a/100;
        num2 = (a - num3*100)/10;
        num1 = a - num3*100 - num2*10;

        if(Math.pow(num1,3) + Math.pow(num2,3) + Math.pow(num3,3) ==a){
            return true;
        }
        return false;
    }
}
