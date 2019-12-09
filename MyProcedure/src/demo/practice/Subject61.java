package demo.practice;

/**
 * ��дһ�������������ַ��������е������ǰ׺��
 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
 */
public class Subject61 {

    public static void main(String[] args) {
        String[] strs = new String[]{"f","fl","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * �����ǰ׺
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs.length <= 0){
            return result;
        }
        boolean flag;
        char tmp ;
        int index = 0;
        while(true){
            flag = true;
            if(index >= strs[0].length()){
                break;
            }else{
                tmp = strs[0].charAt(index);
            }
            for (int i = 1 ;i < strs.length; i++) {
                if(index >= strs[i].length() || strs[i].charAt(index) != tmp){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result = result+tmp;
            }else{
                break;
            }
            index++;
        }
        return result;
    }
}
