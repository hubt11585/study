package demo.practice;

/**
 * ����һ���ַ���(s) ��һ���ַ�ģʽ(p) ��ʵ��һ��֧��'?'��'*'��ͨ���ƥ�䡣
 * '?' ����ƥ���κε����ַ���
 * '*' ����ƥ�������ַ������������ַ�������
 * �����ַ�����ȫƥ�����ƥ��ɹ���
 */
public class Subject91 {
    public static void main(String[] args) {
        String str1 = "abbabaaabababbaababbabbbbbabbbabb";
        String str2 = "**aa*abb***";
        System.out.println(new Subject91().isMatch(str1,str2));
    }

    boolean isMatch(String str, String pattern) {

        int s = 0, p = 0, match = 0, starIdx = -1;
        //���������ַ���
        while (s < str.length()){
            // һ��һƥ�䣬��ָ��ͬʱ���ơ�
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // ���� *��������ƥ��մ��������� startIdx ��¼ * ��λ�ã���¼��ǰ�ַ�����λ�ã�p ����
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // ��ǰ�ַ���ƥ�䣬����Ҳû�� *������
            // p �ص� * ����һ��λ��
            // match ���µ���һ��λ��
            // s �ص����º�� match
            // �ⲽ������ * ƥ����һ���ַ�
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //�ַ���ƥ�䣬Ҳû�� *������ false
            else return false;
        }

        //��ĩβ����� * ֱ��ƥ��մ� ���� text = ab, pattern = a*******
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
}
