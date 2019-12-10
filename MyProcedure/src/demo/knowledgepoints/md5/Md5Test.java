package demo.knowledgepoints.md5;

import java.io.IOException;

public class Md5Test {

    public static void main(String[] args) throws IOException {
        //网络传输过程中被篡改很容易。
        //可逆加密也一样，只要让别人知道加密方式，就可以先还原再修改，再以同样的方式加密，一样篡改了传输信息。
        // 根据几种加密方式就可以推出你使用的加密方式。
        String str = "姓名=蕾蕾，支付=1000，账户：123";

        /**
         * 使用MD5是不可逆加密方式。
         * 就算黑客知道我是MD5加密的，他也不能通过密文反推我的原文是啥。
         */
        String result = MD5Util.encryptionByMD5(str);
        System.out.println(result);
        System.out.println("-----------实际使用场景------------");
        //先准备一个key 只有传输方和接收方知道。
        String key = "AHINTGJLL&&HH$%^";
        // 将原文和key拼接和一起使用MD5加密
        String resultMd5 = MD5Util.encryptionByMD5(str+key);
        //然后将原文和密文再拼接，然后传输。
        System.out.println(resultMd5);
        /**
         * 这样操作后，黑客拿到这个传输数据，改的了你的账户，金额，无法修改你的加密串，因为他无法知道你们约定的key:AHINTGJLL&&HH$%^.
         * 因为MD5的不可逆性，也可以保证你的key 是安全的，不能被黑客知晓。
         */
        System.out.println("传输：" +str+":"+resultMd5);
    }
}
