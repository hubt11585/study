package demo.knowledgepoints.quicksort;

public class QuickSort {
    public static void main(String args[]){
        int[] num={4,5,2,9,6,4,0,2,4,7};
        new QuickSort().QuickSort(num,0,num.length-1);
        for(int n:num) {
            System.out.print(n+" ");
        }
    }

    public int PartSort(int arr[], int low, int high) {
        int data = arr[low];
        /**一次遍历的方法：插空法 定义一个data将arr[low]存起来，并把这个位置挖空*/
        while (low < high) {
            while (low < high && arr[high] >= data) {
                high--;
            }
            arr[low] = arr[high];
            /**从high，也就是后面往前遍历 找到比键值小的数据 插入到前面留下的空中 high位再次留下空来*/
            while (low < high && arr[low] <= data) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = data;
        /**循环退出后 low和high重合 将将键值赋给第low，并将low返回*/
        return low;
    }


    public void QuickSort(int arr[], int low, int high) {
        if(low<high) {
            //防止发生栈溢出异常
            int index = PartSort(arr, low, high);
            QuickSort(arr, low, index - 1);
            QuickSort(arr, index + 1, high);
        }
    }
}
