package demo.practice;

import java.util.LinkedList;

/**
 * ����һ�����ص��� ������������ʼ�˵�����������б�
 * ���б��в���һ���µ����䣬����Ҫȷ���б��е�������Ȼ�����Ҳ��ص�������б�Ҫ�Ļ������Ժϲ����䣩��
 * ʾ�� 1:
 * ����: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * ���: [[1,5],[6,9]]
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

        // С���¼���������ȷ����б�
        while (idx < n && newStart > intervals[idx][0])
            output.add(intervals[idx++]);

        // ������
        int[] interval = new int[2];
        // ����б�Ϊ�ջ����б����һ��ҲС������������������顣 �����������һλȡ����������һ��������ĩβ��
        if (output.isEmpty() || output.getLast()[1] < newStart)
            output.add(newInterval);
        else {
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }

        // ������ʣ�µ�д���б���
        while (idx < n) {
            interval = intervals[idx++];
            int start = interval[0], end = interval[1];
            // ����¼���������Ѿ�С�ں�������飬��ֱ�Ӽ��뼴��
            if (output.getLast()[1] < start) output.add(interval);
                // �Ѵ��д�б����
            else {
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][2]);
    }
}
