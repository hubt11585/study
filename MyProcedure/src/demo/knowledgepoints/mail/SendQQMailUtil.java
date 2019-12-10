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
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("1050750201@qq.com"));
        // 设置收件人邮箱地址
        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("1050750201@qq.com"),new InternetAddress("862155275@qq.com")});
        // 设置邮件标题
        message.setSubject("xmqtest");
        // 设置邮件内容
        message.setText("邮件内容邮件内容邮件内容xmqtest");

        Multipart multipart = new MimeMultipart();//向multipart对象中添加邮件的各个部分内容，包括文本内容和附件

        BodyPart messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource("src/demo/knowledgepoints/pdf/merge/pdf/1.docx");
        messageBodyPart.setDataHandler(new DataHandler(source));//添加附件的内容
        sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();//添加附件的标题
        messageBodyPart.setFileName("=?GBK?B?"+ enc.encode("呼呼.docx".getBytes()) + "?=");
        multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);//将multipart对象放到message中

        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("1050750201@qq.com", "fvkrzukmawixbfag");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码

        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
