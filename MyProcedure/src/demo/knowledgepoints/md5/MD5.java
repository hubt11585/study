package demo.knowledgepoints.md5;

import java.math.BigInteger;
import java.util.Arrays;

public class MD5 {
    //��׼�Ļ���
    private static final int A=0x67452301;
    private static final int B=0xefcdab89;
    private static final int C=0x98badcfe;
    private static final int D=0x10325476;

    //������ЩS11-S44ʵ������һ��4*4�ľ���������ѭ���������õ�
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

    //java��֧���޷��ŵĻ������ݣ�unsigned��
    private int [] result={A,B,C,D};//�洢hash�������4��32=128λ����ʼ��ֵΪ�������ļ�����
    //�����ط����ǽ�������ַ����ӵ���ɫ(����������ܿ�����ͬ���û�������һ�����,������������ͱ���һ�����ܺ�Ľ��Ҳ��һ��)
    private byte[] digest(String inputStr ,String salt) {
        return digest(salt+inputStr);
    }
    private byte[] digest(String inputStr){
        byte [] inputBytes=inputStr.getBytes();//���ַ���ת�����ֽ�����
        int byteLen=inputBytes.length;//���ȣ��ֽڣ�
        int groupCount=0;//��������ĸ���
        groupCount=byteLen/64;//ÿ��512λ��64�ֽڣ�
        int []groups=null;//ÿ��С��(64�ֽ�)��ϸ�ֺ��16��С��(4�ֽ�)

        //����ÿһ����������
        for(int step=0;step<groupCount;step++){
            groups=divGroup(inputBytes,step*64);//�������,��ÿһ����������16��С��(16��4)
            trans(groups);//������飬�����㷨
        }

        //��������������β��
        int rest=byteLen%64;//512λ����������
        byte [] tempBytes=new byte[64];
        //����С��<=56,�����1,0����,Ȼ�����64λ(8�ֽ�)���泤��
        if(rest<=56){
            //��β���ȴ洢����ʱ������
            for(int i=0;i<rest;i++)
                tempBytes[i]=inputBytes[byteLen-rest+i];
            if(rest<56){
                //�������(448λ֮ǰ��һ�����1,�������0)
                tempBytes[rest]=(byte)(1<<7);
                for(int i=1;i<56-rest;i++)
                    tempBytes[rest+i]=0;
            }
            //��64λ����ԭ��ʵ�ʳ���(448-512),��8�ֽ�
            long len=byteLen<<3;//���ȵ�λ��bit ��ԭ���ֽ����鳤�ȡ�8
            for(int i=0;i<8;i++){
                tempBytes[56+i]=(byte)(len&0xFF);//ÿ��ȡ���ȵĵͰ�λ�����ֽ�����
                len=len>>8;//ȡ���Ƴ��Ͱ�λ
            }
            groups=divGroup(tempBytes,0);
            trans(groups);//�������
        }else{//��������56,������һ����ѭ��,Ŀ�ı�֤������ԭ�����64λ(8�ֽ�)���泤��
            for(int i=0;i<rest;i++)
                //��β���ȴ洢����ʱ������
                tempBytes[i]=inputBytes[byteLen-rest+i];
            //�������(��һ�����1,�������0)
            tempBytes[rest]=(byte)(1<<7);
            for(int i=rest+1;i<64;i++)
                tempBytes[i]=0;
            groups=divGroup(tempBytes,0);
            trans(groups);//�������
            //ǰ56Ԫ�����0
            for(int i=0;i<56;i++)
                tempBytes[i]=0;
            //��64λ����ԭ��ʵ�ʳ���(448-512),��8�ֽ�
            long len=(long)(byteLen<<3);
            for(int i=0;i<8;i++){
                tempBytes[56+i]=(byte)(len&0xFF);
                len=len>>8;
            }
            System.out.println(Arrays.toString(tempBytes));
            groups=divGroup(tempBytes,0);
            trans(groups);//�������
        }
        //��hashֵת�����ֽ�����
        //int[] result={A,B,C,D};��4��32=128λ,ÿ��λת��һ��byte����,������һ�������
        byte[] resultByte = new byte[16];
        for(int i = 0;i<4;i++) {
            for(int j = 0; j < 4; j++) {
                //ÿ��ȡ�Ͱ�λ
                resultByte[i*4+j] = (byte) (result[i] & 0xff);
                //ȡ���Ƴ�
                result[i]=result[i]>>8;
            }
        }
        return resultByte;
    }

    /**
     * ��inputBytes��index��ʼȡ512λ����Ϊ�µķ���
     * ��ÿһ��512λ�ķ�����ϸ�ֳ�16��С�飬ÿ��С��64λ��8���ֽڣ�
     * @param inputBytes
     * @param index
     * @return
     */
    private static int[] divGroup(byte[] inputBytes,int index){
        int [] temp=new int[16];
        for(int i=0;i<16;i++){
            //��byte������ȡ�ĸ�Ԫ�����һ��int���ͱ�����������
            //b2iu�����ǽ�byte�����λ����λת��Ϊ������ֵλ
            temp[i]=b2iu(inputBytes[4*i+index])|
                    (b2iu(inputBytes[4*i+1+index]))<<8|
                    (b2iu(inputBytes[4*i+2+index]))<<16|
                    (b2iu(inputBytes[4*i+3+index]))<<24;
        }
        //��󷵻������
        return temp;
    }

    /**
     * ��ʱ�����ڷ���λ������λ�洢�����Ǵ�����������������Ҫ����һ��
     * @param b
     * @return
     */
    public static int b2iu(byte b){//0x7F + 128=0xff
        return b < 0 ? b & 0x7F + 128 : b;
    }

    /**
     * ��Ҫ�Ĳ���������ѭ��
     * @param groups--ÿһ������512λ��64�ֽڣ�
     */
    private void trans(int[] groups) {
        int a = result[0], b = result[1], c = result[2], d = result[3];
        /*��һ��*/
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

        /*�ڶ���*/
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

        /*������*/
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

        /*������*/
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

        /*���뵽֮ǰ����Ľ������*/
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
     * �����Ǵ���Ҫ�õ������Ժ���
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
        //<<<s��ʾѭ������sλ,���Java���޸������
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
    //�������,��int[] result={A,B,C,D},��ԭΪ��ʼ״̬
    public  void reset() {
        result[0] = A;
        result[1] = B;
        result[2] = C;
        result[3] = D;
    }

    public static void main(String []args){
        MD5 md=new MD5();
        byte[] digest = md.digest("����=���٣�֧��=1000���˻���123");
        String md5code = new BigInteger(1, digest).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        System.out.println(md5code);
    }
}
