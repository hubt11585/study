package demo.practice;

/**
 * ������40��
 * ��Ŀ��809*??=800*??+9*??+1    �ĳ� 809*??=800*??+9*??
 * ����??�������λ��,8*??�Ľ��Ϊ��λ����9*??�Ľ��Ϊ3λ������??�������λ������809*??��Ľ��, ��Ŀ����
 */
public class Subject40 {
    public static void main(String[] args) {
        mathematicsFormula();
    }

    /**
     * ��ѧ��ʽ
     */
    private static void mathematicsFormula() {
        boolean flag = false;
        for (int i = 10; i < 100 ; i++) {
            if( 8*i < 100 && 9*i >100 && 809*i == 800*i+9*i){
                flag = true;
                System.out.println("??=" + i);
                System.out.println("809*?? = " + 809*i);
            }
        }
        if(!flag){
            System.out.println("Ϊ�ҵ����ʵ���");
        }
    }
}
