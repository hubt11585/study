package demo.practice;


import java.util.ArrayList;
import java.util.List;

/**
 * ������53��
 * ��һ�������ַ������ݸ������������Դ������¡������ҽ���  ��������
 *
 * ����: s = "LEETCODEISHIRING", numRows =4
 * ���:"LDREOEIIECIHNTSG"
 * ����:
 *   L     D     R
 *   E   O E   I I
 *   E C   I H   N
 *   T     S     G
 */
public class Subject53 {
    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 4;
        String str = convert(s,numRows);
        System.out.println(str);
    }

    /**
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s,int numRows){
        if(numRows <= 1){
            return s;
        }
        char[] arr = s.toCharArray();
        //����numRows���ַ���
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            StringBuilder stringBuffer = new StringBuilder();
            list.add(stringBuffer);
        }

        int flag = 0; // 0��ʾ˳��1��ʾ����
        int size = 1; //�ڵڼ���
        for (int i = 0; i < arr.length; i++) {
            if(size == numRows){
                flag = 1;
            }
            if(size == 1){
                flag = 0;
            }
            list.get(size-1).append(arr[i]);

            if(flag == 0){
                size++;
            }
            if(flag == 1){
                size--;
            }
        }

        StringBuilder newStringBuffer = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            newStringBuffer.append(list.get(i));
        }
        return newStringBuffer.toString();
    }
}
