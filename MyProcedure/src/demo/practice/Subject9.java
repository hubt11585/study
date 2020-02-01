package demo.practice;

import java.util.ArrayList;
        import java.util.List;

/***
 * ������9��
 * ��Ŀ��һ�������ǡ�õ�����������֮�ͣ�������ͳ�Ϊ��������������6=1��2��3.����ҳ�1000���ڵ�����������
 */
public class Subject9 {
    public static void main(String[] args) {
        for (int i = 0; i <1000 ; i++) {
            perfectNum(i);
        }
    }

    /**
     * �ж��Ƿ�������
     */
    public static void perfectNum(int num){
        List<Integer> list = decompose(num);
        int sum = 0;
        for(int i :list){
            sum = sum + i;
        }
        if(num == sum && num != 1){
            System.out.println("������"+num);
        }
    }

    /**
     * �ֽ�������
     * @param num
     * @return
     */
    public static List decompose(int num){
        List<Integer> list = new ArrayList();
        list.add(1);
        int tmp = num/2;
        for(int i=2;i <= tmp ;i++){
            if(num%i == 0){
                list.add(i);
                continue;
            }
        }
        return list;
    }
}
