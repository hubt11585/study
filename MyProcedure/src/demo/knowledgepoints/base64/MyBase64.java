package demo.knowledgepoints.base64;

import java.util.Base64;

/**
 * RGJ6cSo1Njg5 088392  Uvqx+czO87！@#  Uvqx89#!hubt
 * Java 8的java.util套件中，新增了Base64的类别，可以用来处理Base64的编码与解码
 * 跟操作系统无关，因为我是64位系统。其实你打印的是 int 类型的， 1个int 4个字节 所以32位。
 * GBK采用双字节8位表示，总体编码范围为 8140 -- FEFE，首字节在 81 -- FE 之间，尾字节在 40 -- FE 之间。
 * ASCII是7位编码，只使用前7位，第8位补0，所以转换成整数始终为正数，而GBK是8位编码，也就是说一个字节中的第8位可以为1，如1010 1101，而将其转换成byte类型时，byte值为10101101，以补码存储，第8位被当成符号位，当然是负数了，值为：-83。
 * “何”字的GBK编码是：BA CE（1011 1010 1100 1110），两个字节第8位都为1，对byte类型来说，都被理解为最高位符号位。这样值就变成-70和-50了。
 */
public class MyBase64 {
    public static void main(String[] args) {
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            Base64.Encoder encoder = Base64.getEncoder();
            String text = "胡冰涛";
            byte[] textByte = text.getBytes("GBK");
            for(int i =0; i<textByte.length ;i++){
                System.out.println(intToByte8(textByte[i]));
            }
            //编码
            String encodedText = encoder.encodeToString(textByte);
            System.out.println(encodedText);
            //解码
            System.out.println(new String(decoder.decode(encodedText), "GBK"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印字节对应二进制
     * @param num
     * @return
     */
    public static String intToByte8(int num) {
        String str = "";
        byte[] arr = new byte[8];
        for (int i = 7; i >= 0; i--) {
            // &1 也可以改为num&0x01,表示取最地位数字.
            arr[i] = (byte) (num & 1);
            // 右移一位.
            num >>= 1;
        }
        for(int i = 0;i< arr.length; i++){
            str = str + arr[i];
        }
        return str;
    }
}
