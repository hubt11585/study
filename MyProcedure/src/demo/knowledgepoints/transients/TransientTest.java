package demo.knowledgepoints.transients;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("Alexia");
        user.setPasswd("123456");

        System.out.println("user: " + user.toString());

        try{
            File file = new File("src\\demo\\knowledgepoints\\transients\\foo.txt");
            //�Ѷ�����Ϣд���ļ��С�
            ObjectOutputStream oout = new ObjectOutputStream (new FileOutputStream(file));
            oout.writeObject(user);
            oout.close();
            System.out.println("-----------------���л�ǰ��Ա�-----------------");
            //�Ѷ�����Ϣ���ļ��л�ȡ������
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
            User newUser = (User)oin.readObject(); // û��ǿ��ת����Person����
            oin.close();
            System.out.println("newUser: " + newUser.toString());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
