package demo.test;

public class var {
    public static void main(String[] args) {
        String s1 = "hello";
        //�ַ���ת���ַ�����
        char[] arr = s1.toCharArray();
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        //ת�����ֽ�
        byte[] b1 = s1.getBytes();
        for (int i = 0; i < b1.length ; i++) {
            System.out.print(b1[i] + " ");
        }
        System.out.println();
        //�ַ��滻
        String s2 = s1.replace("ll","LL");
        System.out.println("�滻����ַ���Ϊ"+s2);
    }
}
