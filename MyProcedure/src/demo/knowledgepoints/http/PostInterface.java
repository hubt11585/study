package demo.knowledgepoints.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.nio.charset.Charset;

/**
 * ������
 */
public class PostInterface {

    public static JSONObject postJson(String url, JSONObject json) {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        JSONObject response = null;
        try {
            //����ʹ��UTF-8��������������
            StringEntity s = new StringEntity(json.toString(), Charset.forName("GBK"));
            s.setContentType("application/json");//����json������Ҫ����contentType
            post.setEntity(s);

            HttpResponse res = httpclient.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result = EntityUtils.toString(res.getEntity());// ����json��ʽ��
                response = new JSONObject(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public static String doGet(String url,String charset){
        if(null == charset){
            charset = "utf-8";
        }
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpGet httpGet = null;
        String result = null;
        try {
            httpGet = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpGet);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
