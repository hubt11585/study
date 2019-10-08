package demo.algorithm.algorithm1;

/**
 * 给定一个数组：按照从小到大排序。
 * 思路：
 * 1. 获取第一个数放入临时变量data，将大于data的数放右边，小于data的数放在左边。
 * 2. data左边和右边的数组，使用第一点的方法类推。
 *
 * 第一点的具体实现：
 * 获取第一个数放入临时变量data，从右边开始遍历，获取第一个比data小的数，将这个数放入data原本的位置（位置角标为0，满足小于data的数放入
 * data左边的逻辑），然后从左开始遍历获取第一个大于data的数，放入刚刚空出来的位置（这个位置是右边是一定大于data的，所以将此数放入该位置
 * 满足大于data的数放右边的逻辑，再右边，再左边，直到左右重合停止，并最后将data放入最后的重合的空位中。）。
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
