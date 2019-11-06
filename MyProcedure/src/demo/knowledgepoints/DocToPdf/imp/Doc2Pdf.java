package demo.knowledgepoints.DocToPdf.imp;

import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import com.aspose.words.*;

public class Doc2Pdf {

    /*****
     * 需要引入jar包：aspose-words-15.8.0-jdk16.jar
     * @param args
     */
    public static void main(String[] args) {
        doc2pdf("src/demo/knowledgepoints/DocToPdf/PDF/2019年全国I卷理科数学高考真题.docx","src/demo/knowledgepoints/DocToPdf/PDF/pdf1.pdf");
    }

    public static boolean getLicense() {
        boolean result = false;
        try {
            File file = new File("src/demo/knowledgepoints/DocToPdf/imp/license.xml"); // 新建一个空白pdf文档
            InputStream is = new FileInputStream(file); // license.xml找个路径放即可。
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void doc2pdf(String inPath, String outPath) {
        if (!getLicense()) { // 验证License 若不验证则转化出的pdf文档会有水印产生
            return;
        }
        try {
            long old = System.currentTimeMillis();
            File file = new File(outPath); // 新建一个空白pdf文档
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(inPath); // Address是将要被转化的word文档
            doc.save(os, SaveFormat.PDF);// 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF,
            // EPUB, XPS, SWF 相互转换
            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); // 转化用时
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
