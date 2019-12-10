package demo.knowledgepoints.md5;

import java.math.BigInteger;
import java.util.Arrays;

public class MD5 {
    //标准的幻数
    private static final int A=0x67452301;
    private static final int B=0xefcdab89;
    private static final int C=0x98badcfe;
    private static final int D=0x10325476;

    //下面这些S11-S44实际上是一个4*4的矩阵，在四轮循环运算中用到
    static final int S11 = 7;
    static final int S12 = 12;
    static final int S13 = 17;
    static final int S14 = 22;

    static final int S21 = 5;
    static final int S22 = 9;
    static final int S23 = 14;
    static final int S24 = 20;

    static final int S31 = 4;
    static final int S32 = 11;
    static final int S33 = 16;
    static final int S34 = 23;

    static final int S41 = 6;
    static final int S42 = 10;
    static final int S43 = 15;
    static final int S44 = 21;

    //java不支持无符号的基本数据（unsigned）
    private int [] result={A,B,C,D};//存储hash结果，共4×32=128位，初始化值为（幻数的级联）
    //此重载方法是将传入的字符串加点特色(比如密码加密可以连同将用户名加入一起加密,这样就算密码和别人一样加密后的结果也不一样)
    private byte[] digest(String inputStr ,String salt) {
        return digest(salt+inputStr);
    }
    private byte[] digest(String inputStr){
        byte [] inputBytes=inputStr.getBytes();//将字符串转化成字节数组
        int byteLen=inputBytes.length;//长度（字节）
        int groupCount=0;//完整分组的个数
        groupCount=byteLen/64;//每组512位（64字节）
        int []groups=null;//每个小组(64字节)再细分后的16个小组(4字节)

        //处理每一个完整分组
        for(int step=0;step<groupCount;step++){
            groups=divGroup(inputBytes,step*64);//处理分组,将每一个完整分组16个小组(16×4)
            trans(groups);//处理分组，核心算法
        }

        //处理完整分组后的尾巴
        int rest=byteLen%64;//512位分组后的余数
        byte [] tempBytes=new byte[64];
        //余数小于<=56,先填充1,0数据,然后最后64位(8字节)储存长度
        if(rest<=56){
            //将尾巴先存储在临时数组中
            for(int i=0;i<rest;i++)
                tempBytes[i]=inputBytes[byteLen-rest+i];
            if(rest<56){
                //填充数据(448位之前第一个填充1,后面填充0)
                tempBytes[rest]=(byte)(1<<7);
                for(int i=1;i<56-rest;i++)
                    tempBytes[rest+i]=0;
            }
            //后64位储存原文实际长度(448-512),即8字节
            long len=byteLen<<3;//长度单位是bit 即原文字节数组长度×8
            for(int i=0;i<8;i++){
                tempBytes[56+i]=(byte)(len&0xFF);//每次取长度的低八位存入字节数组
                len=len>>8;//取完移除低八位
            }
            groups=divGroup(tempBytes,0);
            trans(groups);//处理分组
        }else{//余数大于56,需增加一组主循环,目的保证处理后的原文最后64位(8字节)储存长度
            for(int i=0;i<rest;i++)
                //将尾巴先存储在临时数组中
                tempBytes[i]=inputBytes[byteLen-rest+i];
            //填充数据(第一个填充1,后面填充0)
            tempBytes[rest]=(byte)(1<<7);
            for(int i=rest+1;i<64;i++)
                tempBytes[i]=0;
            groups=divGroup(tempBytes,0);
            trans(groups);//处理分组
            //前56元素填充0
            for(int i=0;i<56;i++)
                tempBytes[i]=0;
            //后64位储存原文实际长度(448-512),即8字节
            long len=(long)(byteLen<<3);
            for(int i=0;i<8;i++){
                tempBytes[56+i]=(byte)(len&0xFF);
                len=len>>8;
            }
            System.out.println(Arrays.toString(tempBytes));
            groups=divGroup(tempBytes,0);
            trans(groups);//处理分组
        }
        //将hash值转换成字节数组
        //int[] result={A,B,C,D};共4×32=128位,每八位转换一个byte类型,储存在一个结果集
        byte[] resultByte = new byte[16];
        for(int i = 0;i<4;i++) {
            for(int j = 0; j < 4; j++) {
                //每次取低八位
                resultByte[i*4+j] = (byte) (result[i] & 0xff);
                //取完移除
                result[i]=result[i]>>8;
            }
        }
        return resultByte;
    }

    /**
     * 从inputBytes的index开始取512位，作为新的分组
     * 将每一个512位的分组再细分成16个小组，每个小组64位（8个字节）
     * @param inputBytes
     * @param index
     * @return
     */
    private static int[] divGroup(byte[] inputBytes,int index){
        int [] temp=new int[16];
        for(int i=0;i<16;i++){
            //从byte数组中取四个元素组成一个int类型保存在数组中
            //b2iu方法是将byte的最高位符号位转化为代表数值位
            temp[i]=b2iu(inputBytes[4*i+index])|
                    (b2iu(inputBytes[4*i+1+index]))<<8|
                    (b2iu(inputBytes[4*i+2+index]))<<16|
                    (b2iu(inputBytes[4*i+3+index]))<<24;
        }
        //最后返回这分组
        return temp;
    }

    /**
     * 这时不存在符号位（符号位存储不再是代表正负），所以需要处理一下
     * @param b
     * @return
     */
    public static int b2iu(byte b){//0x7F + 128=0xff
        return b < 0 ? b & 0x7F + 128 : b;
    }

    /**
     * 主要的操作，四轮循环
     * @param groups--每一个分组512位（64字节）
     */
    private void trans(int[] groups) {
        int a = result[0], b = result[1], c = result[2], d = result[3];
        /*第一轮*/
        a = FF(a, b, c, d, groups[0], S11, 0xd76aa478); /* 1 */
        d = FF(d, a, b, c, groups[1], S12, 0xe8c7b756); /* 2 */
        c = FF(c, d, a, b, groups[2], S13, 0x242070db); /* 3 */
        b = FF(b, c, d, a, groups[3], S14, 0xc1bdceee); /* 4 */
        a = FF(a, b, c, d, groups[4], S11, 0xf57c0faf); /* 5 */
        d = FF(d, a, b, c, groups[5], S12, 0x4787c62a); /* 6 */
        c = FF(c, d, a, b, groups[6], S13, 0xa8304613); /* 7 */
        b = FF(b, c, d, a, groups[7], S14, 0xfd469501); /* 8 */
        a = FF(a, b, c, d, groups[8], S11, 0x698098d8); /* 9 */
        d = FF(d, a, b, c, groups[9], S12, 0x8b44f7af); /* 10 */
        c = FF(c, d, a, b, groups[10], S13, 0xffff5bb1); /* 11 */
        b = FF(b, c, d, a, groups[11], S14, 0x895cd7be); /* 12 */
        a = FF(a, b, c, d, groups[12], S11, 0x6b901122); /* 13 */
        d = FF(d, a, b, c, groups[13], S12, 0xfd987193); /* 14 */
        c = FF(c, d, a, b, groups[14], S13, 0xa679438e); /* 15 */
        b = FF(b, c, d, a, groups[15], S14, 0x49b40821); /* 16 */

        /*第二轮*/
        a = GG(a, b, c, d, groups[1], S21, 0xf61e2562); /* 17 */
        d = GG(d, a, b, c, groups[6], S22, 0xc040b340); /* 18 */
        c = GG(c, d, a, b, groups[11], S23, 0x265e5a51); /* 19 */
        b = GG(b, c, d, a, groups[0], S24, 0xe9b6c7aa); /* 20 */
        a = GG(a, b, c, d, groups[5], S21, 0xd62f105d); /* 21 */
        d = GG(d, a, b, c, groups[10], S22, 0x2441453); /* 22 */
        c = GG(c, d, a, b, groups[15], S23, 0xd8a1e681); /* 23 */
        b = GG(b, c, d, a, groups[4], S24, 0xe7d3fbc8); /* 24 */
        a = GG(a, b, c, d, groups[9], S21, 0x21e1cde6); /* 25 */
        d = GG(d, a, b, c, groups[14], S22, 0xc33707d6); /* 26 */
        c = GG(c, d, a, b, groups[3], S23, 0xf4d50d87); /* 27 */
        b = GG(b, c, d, a, groups[8], S24, 0x455a14ed); /* 28 */
        a = GG(a, b, c, d, groups[13], S21, 0xa9e3e905); /* 29 */
        d = GG(d, a, b, c, groups[2], S22, 0xfcefa3f8); /* 30 */
        c = GG(c, d, a, b, groups[7], S23, 0x676f02d9); /* 31 */
        b = GG(b, c, d, a, groups[12], S24, 0x8d2a4c8a); /* 32 */

        /*第三轮*/
        a = HH(a, b, c, d, groups[5], S31, 0xfffa3942); /* 33 */
        d = HH(d, a, b, c, groups[8], S32, 0x8771f681); /* 34 */
        c = HH(c, d, a, b, groups[11], S33, 0x6d9d6122); /* 35 */
        b = HH(b, c, d, a, groups[14], S34, 0xfde5380c); /* 36 */
        a = HH(a, b, c, d, groups[1], S31, 0xa4beea44); /* 37 */
        d = HH(d, a, b, c, groups[4], S32, 0x4bdecfa9); /* 38 */
        c = HH(c, d, a, b, groups[7], S33, 0xf6bb4b60); /* 39 */
        b = HH(b, c, d, a, groups[10], S34, 0xbebfbc70); /* 40 */
        a = HH(a, b, c, d, groups[13], S31, 0x289b7ec6); /* 41 */
        d = HH(d, a, b, c, groups[0], S32, 0xeaa127fa); /* 42 */
        c = HH(c, d, a, b, groups[3], S33, 0xd4ef3085); /* 43 */
        b = HH(b, c, d, a, groups[6], S34, 0x4881d05); /* 44 */
        a = HH(a, b, c, d, groups[9], S31, 0xd9d4d039); /* 45 */
        d = HH(d, a, b, c, groups[12], S32, 0xe6db99e5); /* 46 */
        c = HH(c, d, a, b, groups[15], S33, 0x1fa27cf8); /* 47 */
        b = HH(b, c, d, a, groups[2], S34, 0xc4ac5665); /* 48 */

        /*第四轮*/
        a = II(a, b, c, d, groups[0], S41, 0xf4292244); /* 49 */
        d = II(d, a, b, c, groups[7], S42, 0x432aff97); /* 50 */
        c = II(c, d, a, b, groups[14], S43, 0xab9423a7); /* 51 */
        b = II(b, c, d, a, groups[5], S44, 0xfc93a039); /* 52 */
        a = II(a, b, c, d, groups[12], S41, 0x655b59c3); /* 53 */
        d = II(d, a, b, c, groups[3], S42, 0x8f0ccc92); /* 54 */
        c = II(c, d, a, b, groups[10], S43, 0xffeff47d); /* 55 */
        b = II(b, c, d, a, groups[1], S44, 0x85845dd1); /* 56 */
        a = II(a, b, c, d, groups[8], S41, 0x6fa87e4f); /* 57 */
        d = II(d, a, b, c, groups[15], S42, 0xfe2ce6e0); /* 58 */
        c = II(c, d, a, b, groups[6], S43, 0xa3014314); /* 59 */
        b = II(b, c, d, a, groups[13], S44, 0x4e0811a1); /* 60 */
        a = II(a, b, c, d, groups[4], S41, 0xf7537e82); /* 61 */
        d = II(d, a, b, c, groups[11], S42, 0xbd3af235); /* 62 */
        c = II(c, d, a, b, groups[2], S43, 0x2ad7d2bb); /* 63 */
        b = II(b, c, d, a, groups[9], S44, 0xeb86d391); /* 64 */

        /*加入到之前计算的结果当中*/
        result[0] += a;
        result[1] += b;
        result[2] += c;
        result[3] += d;
        result[0]=result[0]&0xFFFFFFFF;
        result[1]=result[1]&0xFFFFFFFF;
        result[2]=result[2]&0xFFFFFFFF;
        result[3]=result[3]&0xFFFFFFFF;
    }

    /**
     * 下面是处理要用到的线性函数
     */
    private static int F(int x, int y, int z) {
        return (x & y) | ((~x) & z);
    }

    private static int G(int x, int y, int z) {
        return (x & z) | (y & (~z));
    }

    private static int H(int x, int y, int z) {
        return x ^ y ^ z;
    }

    private static int I(int x, int y, int z) {
        return y ^ (x | (~z));
    }

    private static int FF(int a, int b, int c, int d, int x, int s,
                          int ac) {
        a += (F(b, c, d)&0xFFFFFFFF) + x + ac;
        //<<<s表示循环左移s位,解决Java中无该运算符
        a = ((a&0xFFFFFFFF)<< s) | ((a&0xFFFFFFFF) >>> (32 - s));
        a += b;
        return (a&0xFFFFFFFF);
    }

    private static int GG(int a, int b, int c, int d, int x, int s,
                          int ac) {
        a += (G(b, c, d)&0xFFFFFFFF) + x + ac;
        a = ((a&0xFFFFFFFF) << s) | ((a&0xFFFFFFFF) >>> (32 - s));
        a += b;
        return (a&0xFFFFFFFF);
    }

    private static int HH(int a, int b, int c, int d, int x, int s,
                          long ac) {
        a += (H(b, c, d)&0xFFFFFFFF) + x + ac;
        a = ((a&0xFFFFFFFF) << s) | ((a&0xFFFFFFFF) >>> (32 - s));
        a += b;
        return (a&0xFFFFFFFF);
    }

    private static int II(int a, int b, int c, int d, int x, int s,
                          long ac) {
        a += (I(b, c, d)&0xFFFFFFFF) + x + ac;
        a = ((a&0xFFFFFFFF) << s) | ((a&0xFFFFFFFF) >>> (32 - s));
        a += b;
        return (a&0xFFFFFFFF);
    }
    //清除缓存,将int[] result={A,B,C,D},还原为初始状态
    public  void reset() {
        result[0] = A;
        result[1] = B;
        result[2] = C;
        result[3] = D;
    }

    public static void main(String []args){
        MD5 md=new MD5();
        byte[] digest = md.digest("姓名=蕾蕾，支付=1000，账户：123");
        String md5code = new BigInteger(1, digest).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        System.out.println(md5code);
    }
}
