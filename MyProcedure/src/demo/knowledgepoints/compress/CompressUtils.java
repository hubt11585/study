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
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class CompressUtils {

    public static void main(String[] args) {

        String zipPath = "src\\demo\\knowledgepoints\\compress\\file\\1.zip";
        String filePath = "src\\demo\\knowledgepoints\\compress\\file";
        zipToFile(zipPath,filePath);

        //需要压缩的文件路径
//        List<String> filePathList = new ArrayList<>();
//        filePathList.add("src\\demo\\knowledgepoints\\compress\\filezip\\1.docx");
//        filePathList.add("src\\demo\\knowledgepoints\\compress\\filezip\\1.pdf");
//
//        //压缩后的文件路径
//        String zipPath = "src/demo/knowledgepoints/compress/filezip/1.zip";
//        toZip(filePathList,zipPath);
    }

    /**
     * 压缩文件
     * @param filePathList
     * @param zipPath
     * @throws RuntimeException
     */
    public static void toZip(List<String> filePathList,String zipPath) throws RuntimeException {
        List<File> adjustFiles = new ArrayList<>();
        for (String filePath :filePathList){
            adjustFiles.add(new File(filePath));
        }

        ByteArrayOutputStream fos2 = new ByteArrayOutputStream();
        CompressUtils.toZip(adjustFiles, fos2);

        BufferedOutputStream output = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        byte[] fileBytes = fos2.toByteArray();
        try {
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(fileBytes);

            bis = new BufferedInputStream(byteInputStream);
            File file = new File(zipPath);
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
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (fos != null) {
                    fos.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException e0) {
                e0.printStackTrace();
            }
        }
    }

    /**
     * 压缩成ZIP
     * @param srcFiles 需要压缩的文件列表
     * @param out      压缩文件输出流
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public static void toZip(List<File> srcFiles, OutputStream out) throws RuntimeException {
        long start = System.currentTimeMillis();
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(out);
            for (File srcFile : srcFiles) {
                byte[] buf = new byte[1024];
                zos.putNextEntry(new ZipEntry(srcFile.getName()));
                int len;
                FileInputStream in = new FileInputStream(srcFile);
                while ((len = in.read(buf)) != -1) {
                    zos.write(buf, 0, len);
                }
                zos.closeEntry();
                in.close();
            }
            long end = System.currentTimeMillis();
            System.out.println("压缩完成，耗时：" + (end - start) + " ms");
        } catch (Exception e) {
            throw new RuntimeException("zip error from ZipUtils", e);
        } finally {
            if (zos != null) {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * zip解压过程
     * @param zipPath  压缩文件路径
     * @param filePath 解压后文件夹路径
     * @throws RuntimeException
     */
    public static void zipToFile(String zipPath, String filePath) throws RuntimeException {
        long startTime = System.currentTimeMillis();

        BufferedInputStream Bin = null;  //数据源缓存流
        ZipInputStream Zin = null;  //数据源
        FileOutputStream out = null;  //输出流
        BufferedOutputStream Bout = null;  //输出缓存流
        try {
            Zin = new ZipInputStream(new FileInputStream(zipPath));//输入源zip路径
            Bin = new BufferedInputStream(Zin);
            File Fout;
            ZipEntry entry;
            while ((entry = Zin.getNextEntry()) != null && !entry.isDirectory()) {
                Fout = new File(filePath, entry.getName());
                if (!Fout.exists()) {
                    new File(Fout.getParent()).mkdirs();
                }
                out = new FileOutputStream(Fout);
                Bout = new BufferedOutputStream(out);
                int bytes;
                while ((bytes = Bin.read()) != -1) {
                    Bout.write(bytes);
                }
                System.out.println(Fout + "解压成功");
            }
            long endTime = System.currentTimeMillis();
            System.out.println("耗费时间： " + (endTime - startTime) + " ms");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (Bin != null) {
                    Bin.close();
                }
                if (Zin != null) {
                    Zin.close();
                }
                if (Bout != null) {
                    Bout.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
