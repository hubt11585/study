package demo.knowledgepoints.pdf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class FileUtil {
    /**
     * �ļ�����
     * @param bis
     * @param file
     */
    public static void fileCopy(BufferedInputStream bis, String file){
        try{
            fileCopy(bis, new BufferedOutputStream(new FileOutputStream(file)));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * ͨ���������ļ�����
     * @param bis
     * @param bos
     */
    public static void fileCopy(BufferedInputStream bis, BufferedOutputStream bos){
        try{
            byte[] by = new byte[1024];
            while (bis.read(by)!=-1) {
                bos.write(by);
            }
            // ���������е�����ȫ��д��
            bos.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
