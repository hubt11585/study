package demo.knowledgepoints.pdf;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.io.File;

public class WordToPdf {
    /*****
     * 需要引入jar包：jacob.jar
     * @param args
     */
    public static void main(String[] args) {
        File targer = null;
        File docFile = null;
        docFile = new File("E:\\WorkSpace\\MyProcedure\\src\\demo\\knowledgepoints\\pdf\\merge\\pdf\\1.docx");
        //targer = new File(docFile.getAbsolutePath().split("\\.")[0] + ".pdf");
        //当文件路径为ip路径时，如：\\166.3.96.18\share\201712\151335250089154.doc，通过上面方法拆分会出错，变成\\166.pdf，所以更换采用以下方法
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
            // 判断文件是否已经存在
            if (targer.exists()) {
                targer.delete();
            }
            Dispatch.call(doc, "SaveAs", targer.getAbsolutePath(), 17); // pdf格式
            Dispatch.call(doc, "Close", false);
            long end = System.currentTimeMillis();
            System.out.println("转换完成..用时：" + (end - start) + "ms.");
        } catch (Exception e) {
        } finally {
            if (app != null)
                app.invoke("Quit", new Variant[]{});
        }
    }
}
