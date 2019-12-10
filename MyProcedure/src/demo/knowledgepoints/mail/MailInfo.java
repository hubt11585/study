package demo.knowledgepoints.mail;

import java.util.Objects;

public class MailInfo {

    String title;
    String content;
    String sendSever;
    String senderAddress;
    String senderPwd;

    String sendUser;
    String receiverAddress;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendSever() {
        return sendSever;
    }

    public void setSendSever(String sendSever) {
        this.sendSever = sendSever;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderPwd() {
        return senderPwd;
    }

    public void setSenderPwd(String senderPwd) {
        this.senderPwd = senderPwd;
    }

    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailInfo mailInfo = (MailInfo) o;
        return Objects.equals(title, mailInfo.title) &&
                Objects.equals(content, mailInfo.content) &&
                Objects.equals(sendSever, mailInfo.sendSever) &&
                Objects.equals(senderAddress, mailInfo.senderAddress) &&
                Objects.equals(senderPwd, mailInfo.senderPwd) &&
                Objects.equals(receiverAddress, mailInfo.receiverAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, content, sendSever, senderAddress, senderPwd, receiverAddress);
    }
}
