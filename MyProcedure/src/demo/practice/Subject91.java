package demo.practice;

/**
 * ����һ���ַ���(s) ��һ���ַ�ģʽ(p) ��ʵ��һ��֧��'?'��'*'��ͨ���ƥ�䡣
 * '?' ����ƥ���κε����ַ���
 * '*' ����ƥ�������ַ������������ַ�������
 * �����ַ�����ȫƥ�����ƥ��ɹ���
 */
public class Subject91 {
    public static void main(String[] args) {
        String str1 = "ho";
        String str2 = "ho**";
        System.out.println(new Subject91().isMatch(str1,str2));
    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();

        boolean first_match =  (!s.isEmpty() && (p.charAt(0) == '?' || s.charAt(0) == p.charAt(0)));

        if(first_match){
            return first_match && isMatch(s.substring(1), p.substring(1));
        }else{
            if(p.charAt(0) == '*'){
                if(p.length() < 2){
                    return true;
                }else{
                    char[] ch = s.toCharArray();

                    for (int i = 0; i < ch.length ; i++) {
                        if(p.charAt(1) == '?' || p.charAt(1) == '*' || s.charAt(i) == p.charAt(1)){
                            boolean flag = isMatch(s.substring(i), p.substring(1));
                            if(!flag){
                                continue;
                            }else{
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
