package demo.knowledgepoints.pdf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class FileUtil {
    /**
     * 文件复制
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
     * 通过流进行文件复制
     * @param bis
     * @param bos
     */
    public static void fileCopy(BufferedInputStream bis, BufferedOutputStream bos){
        try{
            byte[] by = new byte[1024];
            while (bis.read(by)!=-1) {
                bos.write(by);
            }
            // 将缓冲区中的数据全部写出
            bos.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
