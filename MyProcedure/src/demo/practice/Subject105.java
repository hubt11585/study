package demo.practice;

/**
 * ����һ����������Сд��ĸ�Ϳո�' '���ַ��� s�����������һ�����ʵĳ��ȡ�
 * ����ַ����������ҹ�����ʾ����ô���һ�����ʾ��������ֵĵ��ʡ�
 * ������������һ�����ʣ��뷵�� 0��
 * ˵����һ��������ָ������ĸ��ɡ��������κοո�� ������ַ�����
 */
public class Subject105 {

    public static void main(String[] args) {
        String str = "Hello World";
        int i= new Subject105().lengthOfLastWord(str);
        System.out.println(i);
    }

    public int lengthOfLastWord(String s) {
        String[] arr =  s.split(" ");
        if(arr.length > 0){
            return arr[arr.length-1].length();
        }else{
            return 0;
        }
    }
}
