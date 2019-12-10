package demo.knowledgepoints.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestBean {

    private static MessageDigest messageDigest = null;

    /**
     * ��ȡʵ��
     * @param str
     * @return
     */
    public static MessageDigest getInstance(String str){
        if(messageDigest == null){
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("��ȡmd5�㷨ʧ�ܣ�");
            }
        }
        return messageDigest ;
    }
}
