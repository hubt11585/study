package demo.practice;

/**
 * ������44��
 * ��Ŀ�������ַ������ӳ��򣨸���ΪC������Ŀ����ʹ��C��ʽʵ�ָó���
 */
public class Subject44 {
    public static void main(String[] args) {
        String str1 = "����";
        String str2 = "������";
        splicingStr(str1,str2);
    }

    private static void splicingStr(String str1, String str2) {
        /*****javaʵ��***************/
        System.out.println("javaʵ�֣�"+str1 + str2);
        /*****Cʵ��,C�����ַ������������Ҫʹ��char[] ���鱣��ģ�����Ͳ��ٴ���д��***************/
        char[] arrStr1 = str1.toCharArray();
        char[] arrStr2 = str2.toCharArray();
        char[] arrStrSum = new char[arrStr1.length + arrStr2.length];
        for (int i = 0; i < arrStrSum.length; i++) {
            if(i < str1.length()){
                arrStrSum[i] = arrStr1[i];
            }else{
                arrStrSum[i] = arrStr2[i-str1.length()];
            }
        }
        System.out.print("C���Է�ʽʵ�֣�");
        printArray(arrStrSum);
    }
    /**
     * ��ӡ����
     * @param arr
     */
    private static void printArray(char[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
