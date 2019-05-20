package demo.knowledgepoints.pdf.merge.imp;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;

import java.io.FileOutputStream;

public class PdfMerge {
    /*****
     * ��Ҫ����jar����iText-2.1.7.jar
     * @param args
     */
    public static void main(String[] args) {
        String[] files = { "E:\\WorkSpace\\MyProcedure\\src\\demo\\knowledgepoints\\pdf\\merge\\pdf\\1.pdf", "E:\\WorkSpace\\MyProcedure\\src\\demo\\knowledgepoints\\pdf\\merge\\pdf\\2.pdf", "E:\\WorkSpace\\MyProcedure\\src\\demo\\knowledgepoints\\pdf\\merge\\pdf\\3.pdf" };
        String savepath = "E:\\WorkSpace\\MyProcedure\\src\\demo\\knowledgepoints\\pdf\\merge\\pdf\\temp.pdf";
        mergePdfFiles(files, savepath);
    } /*
         * * �ρKpdf�ļ� * * @param files Ҫ�ρK�ļ����M(�^��·����{ "e:\\1.pdf", "e:\\2.pdf" ,
         * "e:\\3.pdf"}) * @param newfile
         * �ρK���®a�����ļ��^��·����e:\\temp.pdf,Ո�Լ��h�����^�᲻���õ��ļ�Ո * @return boolean
         * �a���ɹ�����true, ��t����false
         */

    public static boolean mergePdfFiles(String[] files, String newfile) {
        boolean retValue = false;
        Document document = null;
        try {
            document = new Document(new PdfReader(files[0]).getPageSize(1));
            PdfCopy copy = new PdfCopy(document, new FileOutputStream(newfile));
            document.open();
            for (int i = 0; i < files.length; i++) {
                PdfReader reader = new PdfReader(files[i]);
                int n = reader.getNumberOfPages();
                for (int j = 1; j <= n; j++) {
                    document.newPage();
                    PdfImportedPage page = copy.getImportedPage(reader, j);
                    copy.addPage(page);
                }
            }
            retValue = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        return retValue;
    }
}
