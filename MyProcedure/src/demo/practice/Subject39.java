package demo.practice;

/**
 * ������39��
 * ��Ŀ����̲����һ�����ӣ���ֻ�������֡���һֻ���Ӱ��������ƾ�ݷ�Ϊ��ݣ�����һ������ֻ���ӰѶ��һ�����뺣�У�������һ�ݡ��ڶ�ֻ���Ӱ�ʣ�µ�������ƽ���ֳ���ݣ��ֶ���һ������ͬ���Ѷ��һ�����뺣�У�������һ�ݣ����������ġ�����ֻ���Ӷ����������ģ��ʺ�̲��ԭ�������ж��ٸ����ӣ�
 */
public class Subject39 {

    private static int count = 0;  //���Ҵ���
    private static int tmp = 0;    //��������

    public static void main(String[] args) {
        averagePeachTot();
    }

    /**
     * ѭ����ȡ��������
     */
    private static void averagePeachTot() {
        int frequency = 4;
        while(true){
            if(count == 6){
                System.out.println(tmp);
                break;
            }
            count =0;
            averagePeach(frequency);
            frequency+=4;
        }
    }

    /**
     * ƽ������
     */
    private static void averagePeach(int num) {
        count++;
        if(num%4 == 0 && count<=5){
            tmp = num + 1 + num/4;
            averagePeach( tmp);
        }
    }
}
