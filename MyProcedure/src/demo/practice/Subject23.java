package demo.practice;

/**
 * ������23��
 * ��Ŀ����5��������һ���ʵ�����˶����ꣿ��˵�ȵ�4���˴�2�ꡣ�ʵ�4������������˵�ȵ�3���˴�2�ꡣ�ʵ������ˣ���˵�ȵ�2�˴����ꡣ�ʵ�2���ˣ�˵�ȵ�һ���˴����ꡣ����ʵ�һ���ˣ���˵��10�ꡣ���ʵ�����˶��
 */
public class Subject23 {
    public static void main(String[] args) {
        int ageNum = getAge(5);
        System.out.println("������˵����䣺"+ageNum);
    }

    /**
     * ��ȡ����
     * @param p0
     * @return
     */
    private static int getAge(int p0) {
        if(p0 == 1){
            return 10;
        }else{
            return getAge(p0-1)+2;
        }
    }


}
