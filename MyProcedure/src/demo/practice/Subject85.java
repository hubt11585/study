package demo.practice;

/**
 * ����������һ���������У��������е�������˳����б������õ���һ��������ǰ�������£�
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1������"one 1"("һ��һ") , ��11��
 * 11 ������"two 1s"("����һ"��, ��21��
 * 21 ������"one 2", "one 1"��"һ����","һ��һ"), ��1211��
 * ����һ�������� n��1 ��n�� 30��������������еĵ� n �
 */
public class Subject85 {

    public static void main(String[] args) {
        System.out.println(new Subject85().countAndSay(6));
    }

    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }else{
            String str = countAndSay(n-1);
            char[] chArr = str.toCharArray();
            StringBuilder strTmp = new StringBuilder("");
            char ch = chArr[0] ;
            int count = 0;
            for (int i = 0; i < chArr.length; i++) {
                if(ch == chArr[i]){
                    count++;
                }else{
                    strTmp.append(count).append(ch);
                    ch = chArr[i];
                    count = 1;
                }
            }
            strTmp.append(count).append(ch);
            return strTmp.toString();
        }
    }
}
