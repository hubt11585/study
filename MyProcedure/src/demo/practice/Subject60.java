package demo.practice;

/**
 * ������60��
 * ��������ת���������֣��������ְ������������ַ��� I�� V�� X�� L��C��D �� M��
 */
public class Subject60 {
    public static void main(String[] args) {
        System.out.println(romanToInt("V"));
    }

    public static int romanToInt(String s) {
        // I X C M �ֱ����1��10��100��1000
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] == 'I' || arr[i] == 'X' || arr[i] == 'C' || arr[i] == 'M' ){

            }
        }
    }
}
