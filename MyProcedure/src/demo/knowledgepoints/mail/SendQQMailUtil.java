package demo.knowledgepoints.mail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendQQMailUtil {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// ����Э��
        properties.put("mail.smtp.host", "smtp.qq.com");// ������
        properties.put("mail.smtp.port", 465);// �˿ں�
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// �����Ƿ�ʹ��ssl��ȫ���� ---һ�㶼ʹ��
        properties.put("mail.debug", "true");// �����Ƿ���ʾdebug��Ϣ true ���ڿ���̨��ʾ�����Ϣ
        // �õ��ػ�����
        Session session = Session.getInstance(properties);
        // ��ȡ�ʼ�����
        Message message = new MimeMessage(session);
        // ���÷����������ַ
        message.setFrom(new InternetAddress("1050750201@qq.com"));
        // �����ռ��������ַ
        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("1050750201@qq.com"),new InternetAddress("862155275@qq.com")});
        // �����ʼ�����
        message.setSubject("xmqtest");
        // �����ʼ�����
        message.setText("�ʼ������ʼ������ʼ�����xmqtest");

        Multipart multipart = new MimeMultipart();//��multipart����������ʼ��ĸ����������ݣ������ı����ݺ͸���

        BodyPart messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource("src/demo/knowledgepoints/pdf/merge/pdf/1.docx");
        messageBodyPart.setDataHandler(new DataHandler(source));//��Ӹ���������
        sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();//��Ӹ����ı���
        messageBodyPart.setFileName("=?GBK?B?"+ enc.encode("����.docx".getBytes()) + "?=");
        multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);//��multipart����ŵ�message��

        // �õ��ʲ����
        Transport transport = session.getTransport();
        // �����Լ��������˻�
        transport.connect("1050750201@qq.com", "fvkrzukmawixbfag");// ����ΪQQ���俪ͨ��stmp�����õ��Ŀͻ�����Ȩ��

        // �����ʼ�
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
