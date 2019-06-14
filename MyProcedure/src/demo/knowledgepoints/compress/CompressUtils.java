package demo.knowledgepoints.compress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressUtils {

    public static void main(String[] args) {

        List<File> adjustFiles = new ArrayList<>();
        adjustFiles.add(new File("E:/GitHub/study/MyProcedure/src/demo/knowledgepoints/pdf/merge/pdf/1.docx"));
        adjustFiles.add(new File("E:/GitHub/study/MyProcedure/src/demo/knowledgepoints/pdf/merge/pdf/2.pdf"));

        ByteArrayOutputStream fos2 = new ByteArrayOutputStream();
        CompressUtils.toZip(adjustFiles,  fos2);

        BufferedOutputStream  output = null;
        BufferedInputStream  bis = null;
        FileOutputStream   fos = null;
        byte[] fileBytes = fos2.toByteArray();
        try {
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(fileBytes);

            bis = new BufferedInputStream(byteInputStream);
            File file = new File("E:/GitHub/study/MyProcedure/src/demo/knowledgepoints/pdf/merge/pdf/1.zip");
            file.createNewFile();

            fos = new FileOutputStream(file);
            // 实例化OutputString 对象
            output = new BufferedOutputStream(fos);
            byte[] buffer = new byte[1024];
            int length = bis.read(buffer);
            while (length != -1) {
                output.write(buffer, 0, length);
                length = bis.read(buffer);
            }
            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bis.close();
                fos.close();
                output.close();
            } catch (IOException e0) {
                e0.printStackTrace();
            }
        }
    }

    /**
     * 压缩成ZIP 方法2
     * @param srcFiles 需要压缩的文件列表
     * @param out           压缩文件输出流
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public static void toZip(List<File> srcFiles , OutputStream out)throws RuntimeException {
        long start = System.currentTimeMillis();
        ZipOutputStream zos = null ;
        try {
            zos = new ZipOutputStream(out);
            for (File srcFile : srcFiles) {
                byte[] buf = new byte[1024];
                zos.putNextEntry(new ZipEntry(srcFile.getName()));
                int len;
                FileInputStream in = new FileInputStream(srcFile);
                while ((len = in.read(buf)) != -1){
                    zos.write(buf, 0, len);
                }
                zos.closeEntry();
                in.close();
            }
            long end = System.currentTimeMillis();
            System.out.println("压缩完成，耗时：" + (end - start) +" ms");
        } catch (Exception e) {
            throw new RuntimeException("zip error from ZipUtils",e);
        }finally{
            if(zos != null){
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
