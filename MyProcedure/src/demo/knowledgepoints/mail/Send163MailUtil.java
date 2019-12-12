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

public class Send163MailUtil {
    static String FROM = "18767126115@163.com"; // 发件人地址
    static String AFFIX = "src/demo/knowledgepoints/pdf/merge/pdf/1.docx"; // 附件地址
    static String AFFIXNAME = "呼呼.docx"; // 附件名称
    static String USER = "18767126115@163.com"; // 用户名
    static String PWD = "hubt11585"; // 163的授权码
    static String SUBJECT = "呼呼呼"; // 邮件标题
    static String[] TOS = new String[]{"18767126115@163.com"};  // 收件人地址
    static String context = "邮件正文";   //邮件正文
    /**
     * 发送邮件
     */
    public static void main(String[] args) {
        Properties props = new Properties();  //smtp服务器
        props.put("mail.smtp.host", "smtp.163.com");//设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
        props.put("mail.smtp.auth", "true");  //需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        props.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        props.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        props.put("mail.smtp.port", 465);// 端口号

        Session session = Session.getDefaultInstance(props);//用props对象构建一个session
        MimeMessage message = new MimeMessage(session);//用session为参数定义消息对象
        try {
            message.setFrom(new InternetAddress(FROM));// 加载发件人地址
            InternetAddress[] sendTo = new InternetAddress[TOS.length]; // 加载收件人地址
            for (int i = 0; i < TOS.length; i++) {
                sendTo[i] = new InternetAddress(TOS[i]);
            }
            message.addRecipients(Message.RecipientType.TO,sendTo);
            message.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(FROM));//设置在发送给收信人之前给自己（发送方）抄送一份，不然会被当成垃圾邮件，报554错
            message.setSubject(SUBJECT);//加载标题
            Multipart multipart = new MimeMultipart();//向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            BodyPart contentPart = new MimeBodyPart();//设置邮件的文本内容
            contentPart.setText(context);
            multipart.addBodyPart(contentPart);
            if(!AFFIX.isEmpty()){//添加附件
                BodyPart messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(AFFIX);
                messageBodyPart.setDataHandler(new DataHandler(source));//添加附件的内容
                sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();//添加附件的标题
                messageBodyPart.setFileName("=?GBK?B?"+ enc.encode(AFFIXNAME.getBytes()) + "?=");
                multipart.addBodyPart(messageBodyPart);
            }
            message.setContent(multipart);//将multipart对象放到message中
            message.saveChanges(); //保存邮件
            Transport transport = session.getTransport("smtp");//发送邮件
            transport.connect(USER, PWD);//连接服务器的邮箱
            transport.sendMessage(message, message.getAllRecipients());//把邮件发送出去
            transport.close();//关闭连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
