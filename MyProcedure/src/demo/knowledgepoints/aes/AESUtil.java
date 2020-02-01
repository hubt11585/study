package demo.knowledgepoints.aes;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class AESUtil {
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//Ĭ�ϵļ����㷨

    /**
     * AES ���ܲ���
     * @param content ����������
     * @param key ������Կ
     * @return ����Base64ת���ļ�������
     */
    public static String encrypt(String content, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// ����������
        byte[] byteContent = content.getBytes("utf-8");
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key));// ��ʼ��Ϊ����ģʽ��������
        byte[] result = cipher.doFinal(byteContent);// ����
        return Base64.getEncoder().encodeToString(result);//ͨ��Base64ת�뷵��
    }

    /**
     * AES ���ܲ���
     * @param content
     * @param key
     * @return
     */
    public static String decrypt(String content, String key) throws Exception {
        //ʵ����
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        //ʹ����Կ��ʼ��������Ϊ����ģʽ
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));
        //ִ�в���
        byte[] result = cipher.doFinal(Base64.getDecoder().decode(content));
        return new String(result, "utf-8");
    }

    /**
     * ���ɼ�����Կ
     * @return
     */
    private static SecretKeySpec getSecretKey(final String key) throws Exception {
        //��������ָ���㷨��Կ�������� KeyGenerator ����
        KeyGenerator kg = null;
        kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        //AES Ҫ����Կ����Ϊ 128
        kg.init(128, new SecureRandom(key.getBytes()));
        //����һ����Կ
        SecretKey secretKey = kg.generateKey();
        return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// ת��ΪAESר����Կ
    }

    public static void main(String[] args) throws Exception {
        String content = "hello,����";
        String key = "VhthnDaIePJUXIJMGC8PWA";
        System.out.println("content:" + content);
        String s1 = AESUtil.encrypt(content, key);
        System.out.println("s1:" + s1);
        System.out.println("s2:"+AESUtil.decrypt(s1, key));
    }
}
