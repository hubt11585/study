package demo.knowledgepoints.mail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class MailUtil {

    static String FROM = "hubt11585@hundsun.com"; // �����˵�ַ
    static String AFFIX = "src/demo/knowledgepoints/pdf/merge/pdf/1.docx"; // ������ַ
    static String AFFIXNAME = "����"; // ��������
    static String USER = "hubt11585"; // �û���
    static String PWD = "Hbt1068877"; // ����
    static String SUBJECT = "ssssss"; // �ʼ�����
    static String[] TOS = new String[]{"hubt11585@hundsun.com"};  // �ռ��˵�ַ
    static String context = "ddddddddddddd";   //�ʼ�����

    public static void main(String[] args) {
        Properties props = new Properties();  //smtp������
        props.put("mail.smtp.host", "mail.hundsun.com");//���÷����ʼ����ʼ������������ԣ�����ʹ�����׵�smtp��������
        props.put("mail.smtp.auth", "true");  //��Ҫ������Ȩ��Ҳ�����л����������У�飬��������ͨ����֤��һ��Ҫ����һ����
        props.put("mail.debug", "true");// �����Ƿ���ʾdebug��Ϣ true ���ڿ���̨��ʾ�����Ϣ

        Session session = Session.getDefaultInstance(props);//��props���󹹽�һ��session
        MimeMessage message = new MimeMessage(session);//��sessionΪ����������Ϣ����
        try {
            message.setFrom(new InternetAddress(FROM));// ���ط����˵�ַ
            InternetAddress[] sendTo = new InternetAddress[TOS.length]; // �����ռ��˵�ַ
            for (int i = 0; i < TOS.length; i++) {
                sendTo[i] = new InternetAddress(TOS[i]);
            }
            message.addRecipients(Message.RecipientType.TO,sendTo);
            message.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(FROM));//�����ڷ��͸�������֮ǰ���Լ������ͷ�������һ�ݣ���Ȼ�ᱻ���������ʼ�����554��
            message.setSubject(SUBJECT);//���ر���
            Multipart multipart = new MimeMultipart();//��multipart����������ʼ��ĸ����������ݣ������ı����ݺ͸���
            BodyPart contentPart = new MimeBodyPart();//�����ʼ����ı�����
            contentPart.setText(context);
            multipart.addBodyPart(contentPart);
            if(!AFFIX.isEmpty()){//��Ӹ���
                BodyPart messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(AFFIX);
                messageBodyPart.setDataHandler(new DataHandler(source));//��Ӹ���������
                sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();//��Ӹ����ı���
                messageBodyPart.setFileName("=?GBK?B?"+ enc.encode(AFFIXNAME.getBytes()) + "?=");
                multipart.addBodyPart(messageBodyPart);
            }
            message.setContent(multipart);//��multipart����ŵ�message��
            message.saveChanges(); //�����ʼ�
            Transport transport = session.getTransport("smtp");//�����ʼ�
            transport.connect(USER, PWD);//���ӷ�����������
            transport.sendMessage(message, message.getAllRecipients());//���ʼ����ͳ�ȥ
            transport.close();//�ر�����
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
