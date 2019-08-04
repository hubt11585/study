package demo.knowledgepoints;

public class BinarySystem {

    public static void main(String[] args) {
        String binary = "1100001 1100010 1100011";
        System.out.println(toString(binary));

        System.out.println(BinstrToChar("01110000"));
        System.out.println(BinstrToChar("01110000"));
        System.out.println(BinstrToChar("01100001"));
        System.out.println(BinstrToChar("01100111"));
        System.out.println(BinstrToChar("01100101"));
        System.out.println(BinstrToChar("01001110"));
        System.out.println(BinstrToChar("01101111"));
        System.out.println(BinstrToChar("00111101"));
        System.out.println(BinstrToChar("00110001"));
        System.out.println(BinstrToChar("00100110"));
        System.out.println(BinstrToChar("01110000"));
        System.out.println(BinstrToChar("01100001"));
        System.out.println(BinstrToChar("01100111"));
        System.out.println(BinstrToChar("01100101"));
        System.out.println(BinstrToChar("01010011"));
        System.out.println(BinstrToChar("01101001"));
        System.out.println(BinstrToChar("01111010"));
        System.out.println(BinstrToChar("01100101"));
        System.out.println(BinstrToChar("00111101"));
        System.out.println(BinstrToChar("00110001"));
        System.out.println(BinstrToChar("00110000"));
        System.out.println(BinstrToChar("00110000"));
        System.out.println(BinstrToChar("00100110"));
        System.out.println(BinstrToChar("01100110"));
        System.out.println(BinstrToChar("01110101"));
        System.out.println(BinstrToChar("01101110"));
        System.out.println(BinstrToChar("01100100"));
        System.out.println(BinstrToChar("01001001"));
        System.out.println(BinstrToChar("01100100"));
        System.out.println(BinstrToChar("00111101"));
        System.out.println(BinstrToChar("00100110"));
        System.out.println(BinstrToChar("01100010"));
        System.out.println(BinstrToChar("01110101"));
        System.out.println(BinstrToChar("01110011"));
        System.out.println(BinstrToChar("01101001"));
        System.out.println(BinstrToChar("01101110"));
        System.out.println(BinstrToChar("01100101"));
        System.out.println(BinstrToChar("01110011"));
        System.out.println(BinstrToChar("01110011"));
        System.out.println(BinstrToChar("01000011"));
        System.out.println(BinstrToChar("01101100"));
        System.out.println(BinstrToChar("01100001"));
        System.out.println(BinstrToChar("01110011"));
        System.out.println(BinstrToChar("01110011"));
        System.out.println(BinstrToChar("00111101"));
    }

    public static String toString(String binary) {
        String[] tempStr=binary.split(" ");
        char[] tempChar=new char[tempStr.length];
        for(int i=0;i<tempStr.length;i++) {
            tempChar[i]=BinstrToChar(tempStr[i]);
        }
        return String.valueOf(tempChar);
    }


    //将二进制字符串转换成int数组
    public static int[] BinstrToIntArray(String binStr) {
        char[] temp=binStr.toCharArray();
        int[] result=new int[temp.length];
        for(int i=0;i<temp.length;i++) {
            result[i]=temp[i]-48;
        }
        return result;
    }


    //将二进制转换成字符
    public static char BinstrToChar(String binStr){
        int[] temp=BinstrToIntArray(binStr);
        int sum=0;
        for(int i=0; i<temp.length;i++){
            sum +=temp[temp.length-1-i]<<i;
        }
        return (char)sum;
    }

    public static String toBinary(String str){
        //把字符串转成字符数组
        char[] strChar=str.toCharArray();
        String result="";
        for(int i=0;i<strChar.length;i++){
            //toBinaryString(int i)返回变量的二进制表示的字符串
            //toHexString(int i) 八进制
            //toOctalString(int i) 十六进制
            result +=Integer.toBinaryString(strChar[i])+ "";
        }
        return result;
    }
}
