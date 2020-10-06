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
            //把对象信息写入文件中。
            ObjectOutputStream oout = new ObjectOutputStream (new FileOutputStream(file));
            oout.writeObject(user);
            oout.close();
            System.out.println("-----------------序列化前后对比-----------------");
            //把对象信息从文件中获取出来。
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
            User newUser = (User)oin.readObject(); // 没有强制转换到Person类型
            oin.close();
            System.out.println("newUser: " + newUser.toString());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
