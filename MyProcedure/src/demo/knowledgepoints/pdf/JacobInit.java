package demo.knowledgepoints.pdf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class JacobInit {
    private static String DLL_NAME = "jacob.dll";

    static {
        DLL_NAME = ("32".equals(System.getProperty("sun.arch.data.model"))) ? "jacob-1.17-M2-x86.dll"
                : "jacob-1.17-M2-x64.dll";
    }

    /**
     * ��dll�ļ�������JAVA_HOME\binĿ¼��
     * @throws IOException
     * @author yaohui
     * @date 2012-3-13
     */
    public static void copyToJavaBin()throws IOException{
        File file = new File(System.getProperty("java.home")+"/bin/" + DLL_NAME);
        if (!file.exists()) {
            try {
                FileUtil.fileCopy(
                        new BufferedInputStream(JacobInit.class.getResourceAsStream(DLL_NAME)),
                        new BufferedOutputStream(new FileOutputStream(file)));
            }catch (IOException e) {
                throw new IOException("����jacob��̬�⵽JAVA_HOME\binĿ¼�³���");
            }
        }
    }

    /**
     * ��dll�ļ�������SystemĿ¼��
     * @throws IOException
     * @author yaohui
     * @date 2012-3-13
     */
    public static void copyToSystem32()throws IOException{
        Map<String,String> m = System.getenv();
        File file = new File(m.get("windir")+"/system32/" + DLL_NAME);
        if (!file.exists()) {
            try {
                FileUtil.fileCopy(
                        new BufferedInputStream(JacobInit.class.getResourceAsStream(DLL_NAME)),
                        new BufferedOutputStream(new FileOutputStream(file)));
            }
            catch (IOException e) {
                throw new IOException("����jacob��̬�⵽System32Ŀ¼�³���");
            }
        }
    }

    /**
     * ��ʼ��
     * @throws IOException
     * @author yaohui
     * @date 2012-3-13
     */
    public static void init()throws IOException {
//		copyToSystem32();
        copyToJavaBin();
    }
}
