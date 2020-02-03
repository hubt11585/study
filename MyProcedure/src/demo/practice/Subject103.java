package demo.practice;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
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
        /***按照第一个数字排序***/
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
        /**一次遍历的方法：插空法 定义一个data将arr[low][0]存起来，并把这个位置挖空*/
        while (low < high) {
            while (low < high && arr[high][0] >= data) {
                high--;
            }
            arr[low][0] = arr[high][0];
            arr[low][1] = arr[high][1];
            /**从high，也就是后面往前遍历 找到比键值小的数据 插入到前面留下的空中 high位再次留下空来*/
            while (low < high && arr[low][0] <= data) {
                low++;
            }
            arr[high][0] = arr[low][0];
            arr[high][1] = arr[low][1];
        }
        arr[low][0] = data;
        arr[low][1] = dataTmp;
        /**循环退出后 low和high重合 将将键值赋给第low，并将low返回*/
        return low;
    }

    public void QuickSort(int arr[][], int low, int high) {
        if(low<high) {
            //防止发生栈溢出异常
            int index = PartSort(arr, low, high);
            QuickSort(arr, low, index - 1);
            QuickSort(arr, index + 1, high);
        }
    }
}
