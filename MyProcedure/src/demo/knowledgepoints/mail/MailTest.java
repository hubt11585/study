package demo.knowledgepoints.mail;

public class MailTest {

    public static void main(String[] args) {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setContent("율율율율율율율");
        mailInfo.setReceiverAddress("hubt11585@hundsun.com");
        mailInfo.setTitle("율율율율");
        mailInfo.setSenderPwd("837501AA5F9233DBF05D16921DA4769B9CE9D6CBAA293CDE");
        mailInfo.setSenderAddress("hubt11585@hundsun.com");
        mailInfo.setSendSever("mail.hundsun.com");
        mailInfo.setSendUser("hubt11585");
        try {
            MailUtil.sendMail(mailInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
