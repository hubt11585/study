package demo.algorithm.algorithm1;

/**
 * ����һ�����飺���մ�С��������
 * ˼·��
 * 1. ��ȡ��һ����������ʱ����data��������data�������ұߣ�С��data����������ߡ�
 * 2. data��ߺ��ұߵ����飬ʹ�õ�һ��ķ������ơ�
 *
 * ��һ��ľ���ʵ�֣�
 * ��ȡ��һ����������ʱ����data�����ұ߿�ʼ��������ȡ��һ����dataС�����������������dataԭ����λ�ã�λ�ýǱ�Ϊ0������С��data��������
 * data��ߵ��߼�����Ȼ�����ʼ������ȡ��һ������data����������ոտճ�����λ�ã����λ�����ұ���һ������data�ģ����Խ����������λ��
 * �������data�������ұߵ��߼������ұߣ�����ߣ�ֱ�������غ�ֹͣ�������data���������غϵĿ�λ�С�����
 */
public class QuickSort {
    public static void main(String args[]){
        int[] num={4,5,2,9,6,4,0,2,4,7};
        new QuickSort().QuickSort(num,0,num.length-1);
        for(int n:num) {
            System.out.print(n+" ");
        }
        System.out.println();
    }

    public int PartSort(int arr[], int low, int high) {
        int data = arr[low];
        /**һ�α����ķ�������շ� ����һ��data��arr[low]���������������λ���ڿ�*/
        while (low < high) {
            while (low < high && arr[high] >= data) {
                high--;
            }
            arr[low] = arr[high];
            /**��high��Ҳ���Ǻ�����ǰ���� �ҵ��ȼ�ֵС������ ���뵽ǰ�����µĿ��� highλ�ٴ����¿���*/
            while (low < high && arr[low] <= data) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = data;
        /**ѭ���˳��� low��high�غ� ������ֵ������low������low����*/
        return low;
    }

    public void QuickSort(int arr[], int low, int high) {
        if(low<high) {
            //��ֹ����ջ����쳣
            int index = PartSort(arr, low, high);
            QuickSort(arr, low, index - 1);
            QuickSort(arr, index + 1, high);
        }
    }
}
