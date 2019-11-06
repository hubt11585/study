package demo.knowledgepoints.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizableDemo {
    public static void main(String[] args){
        BoxTmp boxTmp = new BoxTmp();
        boxTmp.setWidth("50");
        boxTmp.setHeight("30");

        try{
            File file = new File("src\\demo\\knowledgepoints\\file\\foo.txt");

            //把对象信息写入文件中。
            ObjectOutputStream oout = new ObjectOutputStream (new FileOutputStream(file));
            oout.writeObject(boxTmp);
            oout.close();

            //把对象信息从文件中获取出来。
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
            BoxTmp newBoxTmp = (BoxTmp)oin.readObject(); // 没有强制转换到Person类型
            oin.close();
            System.out.println(newBoxTmp);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
