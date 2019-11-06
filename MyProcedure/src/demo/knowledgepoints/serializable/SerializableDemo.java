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

            //�Ѷ�����Ϣд���ļ��С�
            ObjectOutputStream oout = new ObjectOutputStream (new FileOutputStream(file));
            oout.writeObject(myBox);
            oout.close();

            //�Ѷ�����Ϣ���ļ��л�ȡ������
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
            Box newMyBox = (Box)oin.readObject(); // û��ǿ��ת����Person����
            oin.close();
            System.out.println("newMyBox == myBox : "+(newMyBox == myBox));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
