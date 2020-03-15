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

public class SendQQMailUtil {


    static String FROM = "1050750201@qq.com"; // �����˵�ַ
    static String AFFIX = "src/demo/knowledgepoints/pdf/merge/pdf/1.docx"; // ������ַ
    static String AFFIXNAME = "����.docx"; // ��������
    static String USER = "1050750201@qq.com"; // �û���
    static String PWD = "fvkrzukmawixbfag"; // QQ����Ȩ��
    static String SUBJECT = "������"; // �ʼ�����
    static String[] TOS = new String[]{"1050750201@qq.com","862155275@qq.com"};  // �ռ��˵�ַ
    static String context = "�ʼ�����";   //�ʼ�����

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// ����Э��
        properties.put("mail.smtp.host", "smtp.qq.com");// ������
        //properties.put("mail.smtp.port", 25);// �˿ں�
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// �����Ƿ�ʹ��ssl��ȫ���� ---һ�㶼ʹ��
        properties.put("mail.debug", "true");// �����Ƿ���ʾdebug��Ϣ true ���ڿ���̨��ʾ�����Ϣ
        // �õ��ػ�����
        Session session = Session.getInstance(properties);
        // ��ȡ�ʼ�����
        Message message = new MimeMessage(session);
        try {
            // ���÷����������ַ
            message.setFrom(new InternetAddress(FROM));
            // �����ռ��������ַ
            InternetAddress[] sendTo = new InternetAddress[TOS.length]; // �����ռ��˵�ַ
            for (int i = 0; i < TOS.length; i++) {
                sendTo[i] = new InternetAddress(TOS[i]);
            }
            message.setRecipients(Message.RecipientType.TO, sendTo);
            // �����ʼ�����
            message.setSubject(SUBJECT);

            Multipart multipart = new MimeMultipart();//��multipart����������ʼ��ĸ����������ݣ������ı����ݺ͸���
            // �����ʼ�����
            BodyPart contentPart = new MimeBodyPart();//�����ʼ����ı�����
            contentPart.setText(context);
            multipart.addBodyPart(contentPart);
            BodyPart messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(AFFIX);
            messageBodyPart.setDataHandler(new DataHandler(source));//��Ӹ���������
            sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();//��Ӹ����ı���
            messageBodyPart.setFileName("=?GBK?B?"+ enc.encode(AFFIXNAME.getBytes()) + "?=");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);//��multipart����ŵ�message��

            // �õ��������
            Transport transport = session.getTransport();
            // �����Լ��������˻�
            transport.connect(USER, PWD);// ����ΪQQ���俪ͨ��stmp�����õ��Ŀͻ�����Ȩ��

            // �����ʼ�
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
