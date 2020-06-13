package demo.knowledgepoints.dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

public class Dom4jDemo {

    /**
     * ��XML��ȡ��Ȼ����Ϣ�����Document��
     */
    public static Document XMLRead(String filename){
        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(new File(filename)); // ��ȡXML�ļ�,���document����
            System.out.println(document.getRootElement().getName());
            readDocument(document);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return document;
    }

    /**
     * ��ȡ��Ϣ
     * @param document
     */
    public static void readDocument(Document document){
        Element root=document.getRootElement();
        Iterator it= root.elementIterator();//��ȡxml����
        while(it.hasNext()){
            Element ele=(Element)it.next();
            getNodes(ele);
        }
    }

    public static void getNodes(Element node){
        System.out.println("--------------------");

        //��ǰ�ڵ�����ơ��ı����ݺ�����
        System.out.println("��ǰ�ڵ����ƣ�"+node.getName());//��ǰ�ڵ�����
        System.out.println("��ǰ�ڵ�����ݣ�"+node.getTextTrim());//��ǰ�ڵ�����
        List<Attribute> listAttr=node.attributes();//��ǰ�ڵ���������Ե�list
        for(Attribute attr:listAttr){//������ǰ�ڵ����������
            String name=attr.getName();//��������
            String value=attr.getValue();//���Ե�ֵ
            System.out.println("�������ƣ�"+name+"����ֵ��"+value);
        }

        //�ݹ������ǰ�ڵ����е��ӽڵ�
        List<Element> listElement=node.elements();//����һ���ӽڵ��list
        for(Element e:listElement){//��������һ���ӽڵ�
            getNodes(e);//�ݹ�
        }
    }

    /**
     * ��Document�����е���Ϣд��XML�ļ���
     */
    public static void XMLWrite(Document document, String filename) {
        try {
            XMLWriter writer = new XMLWriter(new OutputStreamWriter(
                    new FileOutputStream(filename), "UTF-8"));
            writer.write(document);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * ����һ��Document����
     * @return
     */
    public static Document createDom() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("root");     // �������ڵ�
        Element engNameElement = root.addElement("name");    //������Ԫ��
        engNameElement.addAttribute("like","apple");
        Element child2Element = engNameElement.addElement("see");  //������Ԫ��
        child2Element.setText("lily");  //������Ԫ�ص�ֵ
        Element chiNameElement = root.addElement("id");
        chiNameElement.setText("1");
        /********ɾ���ڵ�********/
        root.remove(chiNameElement);
        return document;
    }

    /**
     * �����ַ�������Document����
     * @param text
     * @return
     */
    public static Document createDom(String text) {
        Document document = null;
        try {
            document = DocumentHelper.parseText(text);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static void main(String[] args) {
        /*******����xml�ļ�����******/
        Document document = createDom();
        XMLWrite(document,"src\\demo\\knowledgepoints\\dom4j\\1.xml");

        /*******����xml�ļ�����******/
        document = createDom("<root><name like=\"apple\"><see>lily</see></name></root>");
        XMLWrite(document,"src\\demo\\knowledgepoints\\dom4j\\2.xml");

        /*******����XML�ļ���ȡ********/
        XMLRead("src\\demo\\knowledgepoints\\dom4j\\1.xml");
    }
}
