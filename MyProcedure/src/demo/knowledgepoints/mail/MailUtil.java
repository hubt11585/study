package demo.knowledgepoints.mail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class MailUtil {

    public static void sendMail(MailInfo mailInfo) throws Exception{

        Properties properties = new Properties();
        //�����û�����֤��ʽ
        properties.setProperty("mail.smtp.auth","true");
        //���ô���Э��
        properties.setProperty("mail.transport.protocol", "smtp");
        //���÷����˵�SMTP��������ַ
        properties.setProperty("mail.smtp.host", mailInfo.getSendSever());

        //2��������������Ӧ�ó�������Ļ�����Ϣ�� Session ����
        Session session = Session.getInstance(properties);
        //���õ�����Ϣ�ڿ���̨��ӡ����
        session.setDebug(true);

        //3�������ʼ���ʵ������
        Message message = getMimeMessage(session,mailInfo);
        //4������session�����ȡ�ʼ��������Transport
        Transport transport = session.getTransport();
        //���÷����˵��˻���������
        transport.connect(mailInfo.getSendUser(),BizSecurity.desDecrypt(mailInfo.getSenderPwd(),BizSecurity.key1,BizSecurity.key2,BizSecurity.key3));
        //�����ʼ��������͵������ռ��˵�ַ��message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
        transport.sendMessage(message,message.getAllRecipients());
        //���ֻ�뷢�͸�ָ�����ˣ���������д��
        //transport.sendMessage(message,new Address[]{new InternetAddress("")});
        //5���ر��ʼ�����
        transport.close();
    }


    public static MimeMessage getMimeMessage(Session session, MailInfo mailInfo) throws Exception {
        //1.����һ���ʼ���ʵ������
        MimeMessage mimeMessage = new MimeMessage(session);

        //2.���÷����˵�ַ
        mimeMessage.setFrom(new InternetAddress(mailInfo.getSenderAddress()));
        /**
         * 3.�����ռ��˵�ַ���������Ӷ���ռ��ˡ����͡����ͣ�����������һ�д�����д����
         * MimeMessage.RecipientType.TO:����
         * MimeMessage.RecipientType.CC������
         * MimeMessage.RecipientType.BCC������
         */
        String[] receivers = mailInfo.getReceiverAddress().split(",");

        List<InternetAddress> addressList =  Arrays.stream(receivers).filter(x->x.contains("@")).map(x-> {
            try {
                return new InternetAddress(x);
            } catch (AddressException e) {
                System.out.println("�����ʽ����ȷ��"+x);
                return null;
            }
        }).filter(x->x!=null).collect(Collectors.toList());

        InternetAddress[] receiverAddresses = new InternetAddress[addressList.size()];
        addressList.toArray(receiverAddresses);
        mimeMessage.setRecipients(MimeMessage.RecipientType.TO, receiverAddresses);
        //4.�����ʼ�����
        mimeMessage.setSubject(mailInfo.getTitle(),"UTF-8");

        // 6. �����ı�"�ڵ�"
        MimeBodyPart text = new MimeBodyPart();
        // Ϊ�ı��������
        text.setContent(mailInfo.getContent(),"text/html;charset=UTF-8");

        // 7. �����ı� �� ���� �Ĺ�ϵ���ϳ�һ����Ļ��"�ڵ�" / Multipart ��
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);

        //��Ӹ���
        for (int i = 0; i < 2 ; i++) {
            MimeBodyPart attachment = new MimeBodyPart();
            DataHandler dh = new DataHandler(new FileDataSource("src/demo/knowledgepoints/pdf/merge/pdf/1.docx"));
            attachment.setDataHandler(dh);
            attachment.setFileName(MimeUtility.encodeText("����.docx"));
            mm.addBodyPart(attachment); // ����ж�����������Դ������������
        }

        mm.setSubType("mixed");
        // 8. ���������ʼ��Ĺ�ϵ�������յĻ��"�ڵ�"��Ϊ�ʼ���������ӵ��ʼ�����
        mimeMessage.setContent(mm);

        //�����ʼ��ķ���ʱ��,Ĭ����������
        mimeMessage.setSentDate(new Date());

        return mimeMessage;
    }



}
