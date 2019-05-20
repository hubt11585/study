package demo.knowledgepoints;

public class BinarySystem {

    public static void main(String[] args) {
        String binary = "1100001 1100010 1100011";
        System.out.println(toString(binary));
    }

    public static String toString(String binary) {
        String[] tempStr=binary.split(" ");
        char[] tempChar=new char[tempStr.length];
        for(int i=0;i<tempStr.length;i++) {
            tempChar[i]=BinstrToChar(tempStr[i]);
        }
        return String.valueOf(tempChar);
    }


    //���������ַ���ת����int����
    public static int[] BinstrToIntArray(String binStr) {
        char[] temp=binStr.toCharArray();
        int[] result=new int[temp.length];
        for(int i=0;i<temp.length;i++) {
            result[i]=temp[i]-48;
        }
        return result;
    }


    //��������ת�����ַ�
    public static char BinstrToChar(String binStr){
        int[] temp=BinstrToIntArray(binStr);
        int sum=0;
        for(int i=0; i<temp.length;i++){
            sum +=temp[temp.length-1-i]<<i;
        }
        return (char)sum;
    }

    public static String toBinary(String str){
        //���ַ���ת���ַ�����
        char[] strChar=str.toCharArray();
        String result="";
        for(int i=0;i<strChar.length;i++){
            //toBinaryString(int i)���ر����Ķ����Ʊ�ʾ���ַ���
            //toHexString(int i) �˽���
            //toOctalString(int i) ʮ������
            result +=Integer.toBinaryString(strChar[i])+ "";
        }
        return result;
    }
}
