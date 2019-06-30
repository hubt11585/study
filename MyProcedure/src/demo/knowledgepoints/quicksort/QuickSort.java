package demo.knowledgepoints.quicksort;

public class QuickSort {
    public static void main(String args[]){
        int[] num={1,2,1,2,3};
        new QuickSort().QuickSort(num,0,num.length-1);
        for(int n:num) {
            System.out.print(n+" ");
        }
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
