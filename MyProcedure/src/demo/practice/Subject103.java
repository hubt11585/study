package demo.practice;

/**
 * ����һ������ļ��ϣ���ϲ������ص������䡣
 */
public class Subject103 {

    public static void main(String[] args) {
        int[][] arrs = new int[][]{{4,5},{1,4},{0,1}};   //,{15,18},{17,19},{20,21}
        arrs = new Subject103().merge(arrs);
        System.out.println(arrs);
    }

    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if(length <= 1){
            return intervals;
        }
        /***���յ�һ����������***/
        QuickSort(intervals,0,length-1);

        int start = intervals[0][0] ;
        int end = intervals[0][1] ;
        int newLength = 0;
        for (int i = 1; i < length; i++) {
            if(intervals[i][1] < end){
                continue;
            }else if(intervals[i][0] <= end){
                end = intervals[i][1];
            }else{
                intervals[newLength][0] = start;
                intervals[newLength][1] = end;
                start = intervals[i][0];
                end = intervals[i][1];
                newLength++;
            }
        }
        intervals[newLength][0] = start;
        intervals[newLength][1] = end;

        int[][] newIntervals = new int[newLength+1][2];
        for (int i = 0; i < newIntervals.length; i++) {
            newIntervals[i][0] = intervals[i][0];
            newIntervals[i][1] = intervals[i][1];
        }
        return newIntervals;
    }

    public int PartSort(int arr[][], int low, int high) {
        int data = arr[low][0];
        int dataTmp = arr[low][1];
        /**һ�α����ķ�������շ� ����һ��data��arr[low][0]���������������λ���ڿ�*/
        while (low < high) {
            while (low < high && arr[high][0] >= data) {
                high--;
            }
            arr[low][0] = arr[high][0];
            arr[low][1] = arr[high][1];
            /**��high��Ҳ���Ǻ�����ǰ���� �ҵ��ȼ�ֵС������ ���뵽ǰ�����µĿ��� highλ�ٴ����¿���*/
            while (low < high && arr[low][0] <= data) {
                low++;
            }
            arr[high][0] = arr[low][0];
            arr[high][1] = arr[low][1];
        }
        arr[low][0] = data;
        arr[low][1] = dataTmp;
        /**ѭ���˳��� low��high�غ� ������ֵ������low������low����*/
        return low;
    }

    public void QuickSort(int arr[][], int low, int high) {
        if(low<high) {
            //��ֹ����ջ����쳣
            int index = PartSort(arr, low, high);
            QuickSort(arr, low, index - 1);
            QuickSort(arr, index + 1, high);
        }
    }
}
