package demo.knowledgepoints.base64;

import java.util.Base64;

/**
 * Java 8��java.util�׼��У�������Base64����𣬿�����������Base64�ı��������
 *
 * ������ϵͳ�޹أ���Ϊ����64λϵͳ����ʵ���ӡ���� int ���͵ģ� 1��int 4���ֽ� ����32λ��
 *
 * GBK����˫�ֽ�8λ��ʾ��������뷶ΧΪ 8140 -- FEFE�����ֽ��� 81 -- FE ֮�䣬β�ֽ��� 40 -- FE ֮�䡣
 * ASCII��7λ���룬ֻʹ��ǰ7λ����8λ��0������ת��������ʼ��Ϊ��������GBK��8λ���룬Ҳ����˵һ���ֽ��еĵ�8λ����Ϊ1����1010 1101��������ת����byte����ʱ��byteֵΪ10101101���Բ���洢����8λ�����ɷ���λ����Ȼ�Ǹ����ˣ�ֵΪ��-83��
 * ���Ρ��ֵ�GBK�����ǣ�BA CE��1011 1010 1100 1110���������ֽڵ�8λ��Ϊ1����byte������˵���������Ϊ���λ����λ������ֵ�ͱ��-70��-50�ˡ�
 */
public class MyBase64 {
    public static void main(String[] args) {
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            Base64.Encoder encoder = Base64.getEncoder();
            String text = "ͨ������";
            byte[] textByte = text.getBytes("UTF-8");
            for(int i =0; i<textByte.length ;i++){
                System.out.println(intToByte8(textByte[i]));
            }
            //����
            String encodedText = encoder.encodeToString(textByte);
            System.out.println(encodedText);
            //����
            System.out.println(new String(decoder.decode(encodedText), "UTF-8"));

            System.out.println(intToByte8(112));

            System.out.println(intToByte8(112));
            System.out.println(intToByte8(97));
            System.out.println(intToByte8(103));
            System.out.println(intToByte8(101));
            System.out.println(intToByte8(78));
            System.out.println(intToByte8(111));
            System.out.println(intToByte8(61));
            System.out.println(intToByte8(49));
            System.out.println(intToByte8(38));
            System.out.println(intToByte8(112));
            System.out.println(intToByte8( 97));
            System.out.println(intToByte8(103));
            System.out.println(intToByte8(101));
            System.out.println(intToByte8(83));
            System.out.println(intToByte8(105));
            System.out.println(intToByte8(122));
            System.out.println(intToByte8(101));
            System.out.println(intToByte8(61));
            System.out.println(intToByte8(49));
            System.out.println(intToByte8(48));
            System.out.println(intToByte8(48));
            System.out.println(intToByte8(38));
            System.out.println(intToByte8(102));
            System.out.println(intToByte8(117));
            System.out.println(intToByte8(110));
            System.out.println(intToByte8(100));
            System.out.println(intToByte8(73));
            System.out.println(intToByte8(100));
            System.out.println(intToByte8(61));
            System.out.println(intToByte8(38));
            System.out.println(intToByte8(98));
            System.out.println(intToByte8(117));
            System.out.println(intToByte8(115));
            System.out.println(intToByte8(105));
            System.out.println(intToByte8(110));
            System.out.println(intToByte8(101));
            System.out.println(intToByte8(115));
            System.out.println(intToByte8(115));
            System.out.println(intToByte8(67));
            System.out.println(intToByte8(108));
            System.out.println(intToByte8(97));
            System.out.println(intToByte8(115));
            System.out.println(intToByte8(115));
            System.out.println(intToByte8(61));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ӡ�ֽڶ�Ӧ������
     * @param num
     * @return
     */
    public static String intToByte8(int num) {
        String str = "";
        byte[] arr = new byte[8];
        for (int i = 7; i >= 0; i--) {
            // &1 Ҳ���Ը�Ϊnum&0x01,��ʾȡ���λ����.
            arr[i] = (byte) (num & 1);
            // ����һλ.
            num >>= 1;
        }
        for(int i = 0;i< arr.length; i++){
            str = str + arr[i];
        }
        return str;
    }
}
