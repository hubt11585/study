package demo.knowledgepoints.pdf;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.io.File;

public class WordToPdf {
    /*****
     * ��Ҫ����jar����jacob.jar
     * @param args
     */
    public static void main(String[] args) {
        File targer = null;
        File docFile = null;
        docFile = new File("E:\\WorkSpace\\MyProcedure\\src\\demo\\knowledgepoints\\pdf\\merge\\pdf\\1.docx");
        //targer = new File(docFile.getAbsolutePath().split("\\.")[0] + ".pdf");
        //���ļ�·��Ϊip·��ʱ���磺\\166.3.96.18\share\201712\151335250089154.doc��ͨ�����淽����ֻ�������\\166.pdf�����Ը����������·���
        targer = new File(docFile.getAbsolutePath().substring(0,docFile.getAbsolutePath().lastIndexOf(".")) + "34.pdf");

        if(targer == null){
            //String toFilename = word.getAbsolutePath().split("\\.")[0] + ".pdf";
            String toFilename = docFile.getAbsolutePath().substring(0,docFile.getAbsolutePath().lastIndexOf(".")) + "34.pdf";
            targer = new File(toFilename);
        }
        long start = System.currentTimeMillis();
        ActiveXComponent app = null;
        try {
            JacobInit.init();
            app = new ActiveXComponent("Word.Application");
            app.setProperty("Visible", new Variant(false));

            Dispatch docs = (Dispatch)app.getProperty("Documents").toDispatch();
            Dispatch doc = Dispatch.call(docs, "Open", docFile.getAbsolutePath(),false,true).toDispatch();
            // �ж��ļ��Ƿ��Ѿ�����
            if (targer.exists()) {
                targer.delete();
            }
            Dispatch.call(doc, "SaveAs", targer.getAbsolutePath(), 17); // pdf��ʽ
            Dispatch.call(doc, "Close", false);
            long end = System.currentTimeMillis();
            System.out.println("ת�����..��ʱ��" + (end - start) + "ms.");
        } catch (Exception e) {
        } finally {
            if (app != null)
                app.invoke("Quit", new Variant[]{});
        }
    }
}
