package demo.knowledgepoints.md5;

import java.io.IOException;

public class Md5Test {

    public static void main(String[] args) throws IOException {
        //���紫������б��۸ĺ����ס�
        //�������Ҳһ����ֻҪ�ñ���֪�����ܷ�ʽ���Ϳ����Ȼ�ԭ���޸ģ�����ͬ���ķ�ʽ���ܣ�һ���۸��˴�����Ϣ��
        // ���ݼ��ּ��ܷ�ʽ�Ϳ����Ƴ���ʹ�õļ��ܷ�ʽ��
        String str = "����=���٣�֧��=1000���˻���123";

        /**
         * ʹ��MD5�ǲ�������ܷ�ʽ��
         * ����ڿ�֪������MD5���ܵģ���Ҳ����ͨ�����ķ����ҵ�ԭ����ɶ��
         */
        String result = MD5Util.encryptionByMD5(str);
        System.out.println(result);
        System.out.println("-----------ʵ��ʹ�ó���------------");
        //��׼��һ��key ֻ�д��䷽�ͽ��շ�֪����
        String key = "AHINTGJLL&&HH$%^";
        // ��ԭ�ĺ�keyƴ�Ӻ�һ��ʹ��MD5����
        String resultMd5 = MD5Util.encryptionByMD5(str+key);
        //Ȼ��ԭ�ĺ�������ƴ�ӣ�Ȼ���䡣
        System.out.println(resultMd5);
        /**
         * ���������󣬺ڿ��õ�����������ݣ��ĵ�������˻������޷��޸���ļ��ܴ�����Ϊ���޷�֪������Լ����key:AHINTGJLL&&HH$%^.
         * ��ΪMD5�Ĳ������ԣ�Ҳ���Ա�֤���key �ǰ�ȫ�ģ����ܱ��ڿ�֪����
         */
        System.out.println("���䣺" +str+":"+resultMd5);
    }
}
