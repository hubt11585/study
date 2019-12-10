package demo.knowledgepoints.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestBean {

    private static MessageDigest messageDigest = null;

    /**
     * 获取实例
     * @param str
     * @return
     */
    public static MessageDigest getInstance(String str){
        if(messageDigest == null){
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("获取md5算法失败！");
            }
        }
        return messageDigest ;
    }
}
