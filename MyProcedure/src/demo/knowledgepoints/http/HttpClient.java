package demo.knowledgepoints.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpClient {

    static String PostURL = "http://192.168.163.218:9091/getData.json";
    static String getURL = "https://www.baidu.com";

    public static void main(String[] args) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name","����");
        params.put("age","18");
        String dd = HttpClient.post(PostURL,params);
        System.out.println(dd);

        String str = HttpClient.get(getURL);
        System.out.println(str);
    }

    // ;charset=utf-8 ����Ҫ����Ȼ���������
    /**
     * ������ <br/>
     * <br/>
     * �ڷ���ǰ���������ַ���Ĭ�ϣ�<br/>
     * <br/>
     * application/x-www-form-urlencoded;charset=utf-8
     */
    public static String CONTENT_TYPE_FORM_URLENCODED = "application/x-www-form-urlencoded;charset=utf-8";

    /**
     * ������ <br/>
     * <br/>
     * �����ַ����롣��ʹ�ð����ļ��ϴ��ؼ��ı�ʱ������ʹ�ø�ֵ <br/>
     * <br/>
     * multipart/form-data;charset=utf-8
     */
    public static String CONTENT_TYPE_FORM_DATA = "multipart/form-data;charset=utf-8";

    /** text/plain;charset=utf-8 */
    public static String CONTENT_TYPE_PLAIN = "text/plain;charset=utf-8";
    /** application/json;charset=utf-8 */
    public static String CONTENT_TYPE_JSON = "application/json;charset=utf-8";

    /**
     * @Name: post��
     * @Description: ����post���󣬲�������Ӧ���ݡ�
     * @Parameters: URL��Ҫ���ʵ�url��
     * @Parameters: parms�����ʲ���,Map��ʽ��
     * @Return: String����Ӧ���ݡ�
     * @Author: PeiFeng
     * @Version: V1.00
     * @Create Date: 2019-8-8
     */
    public static String post(String URL, Map<String, String> params) {
        StringBuilder parm = new StringBuilder();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                parm.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        System.out.println(parm.toString());
        return post(URL, "{\"name\":\"����\",\"age\":\"18\"}");
    }

    /**
     * @Name: post��
     * @Description: ����post���󣬲�������Ӧ���ݡ�
     * @Parameters: URL��Ҫ���ʵ�url��
     * @Parameters: parm�����ʲ�����
     * @Return: String����Ӧ���ݡ�
     * @Author: PeiFeng
     * @Version: V1.00
     * @Create Date: 2019-8-8
     */
    public static String post(String URL, String parm) {

        HttpURLConnection conn = null;
        // ��������������������Ϣ
        DataOutputStream dataOut = null;
        // �����������������������Ӧ����
        BufferedReader dataIn = null;

        try {
            URL url = new URL(URL);

            // ��url��open�������ص�urlConnection����ǿתΪHttpURLConnection����(��ʶһ��url�����õ�Զ�̶�������)
            // ��ʱcnnectionֻ��Ϊһ�����Ӷ���,��������
            conn = (HttpURLConnection) url.openConnection();

            // �������������Ϊtrue,Ĭ��false (post�����������ķ�ʽ��ʽ�Ĵ��ݲ���)
            conn.setDoOutput(true);
            // ��������������Ϊtrue
            conn.setDoInput(true);
            // ��������ʽΪpost
            conn.setRequestMethod("POST");
            // post���󻺴���Ϊfalse
            conn.setUseCaches(false);
            // ���ø�HttpURLConnectionʵ���Ƿ��Զ�ִ���ض���
            conn.setInstanceFollowRedirects(true);

            // �������ݵ�����,����Ϊ����urlEncoded�������from����
            conn.setRequestProperty("Content-Type", HttpClient.CONTENT_TYPE_FORM_URLENCODED);
            conn.setRequestProperty("accept", "*/*");
            // conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;
            // MSIE 6.0; Windows NT 5.1;SV1)");

            // ��������
            // (����δ��ʼ,ֱ��connection.getInputStream()��������ʱ�ŷ���,���ϸ��������������ڴ˷���֮ǰ����)
            conn.connect();

            // �������������,�����������������Я���Ĳ���,(�������Ϊ?���������)
            dataOut = new DataOutputStream(conn.getOutputStream());
            // ���������������
            dataOut.writeBytes(parm != null ? parm : "");
            // �����ɺ�ˢ�²��ر���
            dataOut.flush();

            //���������Ϣ��ʵ��ʹ��ʱȥ��
            outConnInfo(conn, url);

            // ���ӷ�������,�����������Ӧ (�����ӻ�ȡ������������װΪbufferedReader)
            dataIn = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            // �����洢��Ӧ����
            StringBuilder sb = new StringBuilder();
            // ѭ����ȡ��
            while ((line = dataIn.readLine()) != null) {
                sb.append(line).append(System.getProperty("line.separator"));
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // ��Ҫ���׺��Բ��� (�ر���,�м�!)
                if (dataOut != null) {
                    dataOut.close();
                }
                if (dataIn != null) {
                    dataIn.close();
                }
                // ��������
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /** ���������Ϣ */
    private static void outConnInfo(HttpURLConnection conn, URL url) throws IOException {
        // url��url = conn.getURL()�ǵȼ۵�
        System.out.println("conn.getResponseCode():" + conn.getResponseCode());
        System.out.println("conn.getURL():" + conn.getURL());
        System.out.println("conn.getRequestMethod():" + conn.getRequestMethod());
        System.out.println("conn.getContentType():" + conn.getContentType());
        System.out.println("conn.getReadTimeout():" + conn.getReadTimeout());
        System.out.println("conn.getResponseMessage():" + conn.getResponseMessage());
        System.out.println("url.getDefaultPort():" + url.getDefaultPort());
        System.out.println("url.getFile():" + url.getFile());
        System.out.println("url.getHost():" + url.getHost());
        System.out.println("url.getPath():" + url.getPath());
        System.out.println("url.getPort():" + url.getPort());
        System.out.println("url.getProtocol():" + url.getProtocol());
        System.out.println("url.getQuery():" + url.getQuery());
        System.out.println("url.getRef():" + url.getRef());
        System.out.println("url.getUserInfo():" + url.getUserInfo());
    }

    /**
     * @Name: get��
     * @Description: ����get���󣬲�������Ӧ���ݡ�
     * @Parameters: URL��Ҫ���ʵ�url��
     * @Return: String����Ӧ���ݡ�
     * @Author: PeiFeng
     * @Version: V1.00
     * @Create Date: 2017-8-8
     */
    public static String get(String URL) {

        HttpURLConnection conn = null;
        BufferedReader dataIn = null;

        try {
            // ���ַ���ת��ΪURL�����ַ
            URL url = new URL(URL);
            // ������
            conn = (HttpURLConnection) url.openConnection();
            // ���ӻỰ
            conn.connect();
            // ��ȡ������
            dataIn = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = dataIn.readLine()) != null) {// ѭ����ȡ��
                sb.append(line);
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // ��Ҫ���׺��Բ��� (�ر���,�м�!)
                if (dataIn != null) {
                    dataIn.close();
                }
                // ��������
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
