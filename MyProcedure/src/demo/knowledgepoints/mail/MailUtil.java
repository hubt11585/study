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
        //设置用户的认证方式
        properties.setProperty("mail.smtp.auth","true");
        //设置传输协议
        properties.setProperty("mail.transport.protocol", "smtp");
        //设置发件人的SMTP服务器地址
        properties.setProperty("mail.smtp.host", mailInfo.getSendSever());

        //2、创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getInstance(properties);
        //设置调试信息在控制台打印出来
        session.setDebug(true);

        //3、创建邮件的实例对象
        Message message = getMimeMessage(session,mailInfo);
        //4、根据session对象获取邮件传输对象Transport
        Transport transport = session.getTransport();
        //设置发件人的账户名和密码
        transport.connect(mailInfo.getSendUser(),BizSecurity.desDecrypt(mailInfo.getSenderPwd(),BizSecurity.key1,BizSecurity.key2,BizSecurity.key3));
        //发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message,message.getAllRecipients());
        //如果只想发送给指定的人，可以如下写法
        //transport.sendMessage(message,new Address[]{new InternetAddress("")});
        //5、关闭邮件连接
        transport.close();
    }


    public static MimeMessage getMimeMessage(Session session, MailInfo mailInfo) throws Exception {
        //1.创建一封邮件的实例对象
        MimeMessage mimeMessage = new MimeMessage(session);

        //2.设置发件人地址
        mimeMessage.setFrom(new InternetAddress(mailInfo.getSenderAddress()));
        /**
         * 3.设置收件人地址（可以增加多个收件人、抄送、密送），即下面这一行代码书写多行
         * MimeMessage.RecipientType.TO:发送
         * MimeMessage.RecipientType.CC：抄送
         * MimeMessage.RecipientType.BCC：密送
         */
        String[] receivers = mailInfo.getReceiverAddress().split(",");

        List<InternetAddress> addressList =  Arrays.stream(receivers).filter(x->x.contains("@")).map(x-> {
            try {
                return new InternetAddress(x);
            } catch (AddressException e) {
                System.out.println("邮箱格式不正确："+x);
                return null;
            }
        }).filter(x->x!=null).collect(Collectors.toList());

        InternetAddress[] receiverAddresses = new InternetAddress[addressList.size()];
        addressList.toArray(receiverAddresses);
        mimeMessage.setRecipients(MimeMessage.RecipientType.TO, receiverAddresses);
        //4.设置邮件主题
        mimeMessage.setSubject(mailInfo.getTitle(),"UTF-8");

        // 6. 创建文本"节点"
        MimeBodyPart text = new MimeBodyPart();
        // 为文本添加内容
        text.setContent(mailInfo.getContent(),"text/html;charset=UTF-8");

        // 7. 设置文本 和 附件 的关系（合成一个大的混合"节点" / Multipart ）
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);

        //添加附件
        for (int i = 0; i < 2 ; i++) {
            MimeBodyPart attachment = new MimeBodyPart();
            DataHandler dh = new DataHandler(new FileDataSource("src/demo/knowledgepoints/pdf/merge/pdf/1.docx"));
            attachment.setDataHandler(dh);
            attachment.setFileName(MimeUtility.encodeText("啦啦.docx"));
            mm.addBodyPart(attachment); // 如果有多个附件，可以创建多个多次添加
        }

        mm.setSubType("mixed");
        // 8. 设置整个邮件的关系（将最终的混合"节点"作为邮件的内容添加到邮件对象）
        mimeMessage.setContent(mm);

        //设置邮件的发送时间,默认立即发送
        mimeMessage.setSentDate(new Date());

        return mimeMessage;
    }



}
