package demo.knowledgepoints.DocToPdf.imp;

import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import com.aspose.words.*;

public class Doc2Pdf {

    public static void main(String[] args) {
        doc2pdf("E:/WorkSpace/MyProcedure/src/demo/knowledgepoints/DocToPdf/PDF/�ʽ���Ӫƽ̨����˵����V2.65.docx","E:/WorkSpace/MyProcedure/src/demo/knowledgepoints/DocToPdf/PDF/pdf1.pdf");
    }

    public static boolean getLicense() {
        boolean result = false;
        try {
            File file = new File("E:\\GitHub\\study\\MyProcedure\\WebRoot\\WEB-INF\\classes\\license.xml"); // �½�һ���հ�pdf�ĵ�
            InputStream is = new FileInputStream(file); // license.xmlӦ����..\WebRoot\WEB-INF\classes·����
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void doc2pdf(String inPath, String outPath) {
        if (!getLicense()) { // ��֤License ������֤��ת������pdf�ĵ�����ˮӡ����
            return;
        }
        try {
            long old = System.currentTimeMillis();
            File file = new File(outPath); // �½�һ���հ�pdf�ĵ�
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(inPath); // Address�ǽ�Ҫ��ת����word�ĵ�
            doc.save(os, SaveFormat.PDF);// ȫ��֧��DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF,
            // EPUB, XPS, SWF �໥ת��
            long now = System.currentTimeMillis();
            System.out.println("����ʱ��" + ((now - old) / 1000.0) + "��"); // ת����ʱ
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
