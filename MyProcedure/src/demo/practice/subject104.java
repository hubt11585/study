package demo.practice;

import java.util.LinkedList;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例 1:
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 */
public class subject104 {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {10,11};
        int[][] newIntervals = new subject104().insert(intervals,newInterval);
        System.out.println(newIntervals);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // init data
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, n = intervals.length;
        LinkedList<int[]> output = new LinkedList<int[]>();

        // 小于新加入的数组先放入列表
        while (idx < n && newStart > intervals[idx][0])
            output.add(intervals[idx++]);

        // 新数组
        int[] interval = new int[2];
        // 如果列表为空或者列表最后一个也小于新数组则加入新数组。 否则数组最后一位取和新数组大的一个，放入末尾。
        if (output.isEmpty() || output.getLast()[1] < newStart)
            output.add(newInterval);
        else {
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }

        // 继续将剩下的写入列表中
        while (idx < n) {
            interval = intervals[idx++];
            int start = interval[0], end = interval[1];
            // 如何新加入的数组已经小于后面的数组，则直接加入即可
            if (output.getLast()[1] < start) output.add(interval);
                // 把大的写列表最后。
            else {
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][2]);
    }
}
