package demo.practice;

/**
 * ������20��
 * ��Ŀ����һ�������У�2/1��3/2��5/3��8/5��13/8��21/13�����������е�ǰ20��֮�͡�
 */
public class Subject20 {

    public static void main(String[] args) {
        double sumNum = sum(20);
        System.out.println("ǰ20������֮��Ϊ��"+sumNum);
    }

    /**
     * ǰnum�����ĺ�
     * @param num
     */
    public static double sum(int num){
        if(num == 1){
            return 2.0/1.0;
        }else{
            double a = getMolecule(num);
            double b = getMolecule(num-1);
            return sum(num-1)+ a/b;
        }
    }

    /**
     * ���չ��ɻ�ȡ����
     * @param num
     * @return
     */
    public static double getMolecule(int num){
        if(num == 1){
            return 2.0;
        }else if(num == 2){
            return 3.0;
        }else{
            return getMolecule(num-1) + getMolecule(num-2);
        }
    }
}
