package demo.knowledgepoints.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableDemo {
    public static void main(String[] args){
        Box myBox = Box.getInstance();
        try{
            File file = new File("src\\demo\\knowledgepoints\\file\\foo.ser");

            //把对象信息写入文件中。
            ObjectOutputStream oout = new ObjectOutputStream (new FileOutputStream(file));
            oout.writeObject(myBox);
            oout.close();

            //把对象信息从文件中获取出来。
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
            Box newMyBox = (Box)oin.readObject(); // 没有强制转换到Person类型
            oin.close();
            System.out.println("newMyBox == myBox : "+(newMyBox == myBox));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
