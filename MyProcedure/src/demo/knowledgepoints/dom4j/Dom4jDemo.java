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
     * 将XML读取，然后将信息保存进Document中
     */
    public static Document XMLRead(String filename){
        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(new File(filename)); // 读取XML文件,获得document对象
            System.out.println(document.getRootElement().getName());
            readDocument(document);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return document;
    }

    /**
     * 读取信息
     * @param document
     */
    public static void readDocument(Document document){
        Element root=document.getRootElement();
        Iterator it= root.elementIterator();//获取xml迭代
        while(it.hasNext()){
            Element ele=(Element)it.next();
            getNodes(ele);
        }
    }

    public static void getNodes(Element node){
        System.out.println("--------------------");

        //当前节点的名称、文本内容和属性
        System.out.println("当前节点名称："+node.getName());//当前节点名称
        System.out.println("当前节点的内容："+node.getTextTrim());//当前节点名称
        List<Attribute> listAttr=node.attributes();//当前节点的所有属性的list
        for(Attribute attr:listAttr){//遍历当前节点的所有属性
            String name=attr.getName();//属性名称
            String value=attr.getValue();//属性的值
            System.out.println("属性名称："+name+"属性值："+value);
        }

        //递归遍历当前节点所有的子节点
        List<Element> listElement=node.elements();//所有一级子节点的list
        for(Element e:listElement){//遍历所有一级子节点
            getNodes(e);//递归
        }
    }

    /**
     * 将Document对象中的信息写入XML文件中
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
     * 创建一个Document对象
     * @return
     */
    public static Document createDom() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("root");     // 创建根节点
        Element engNameElement = root.addElement("name");    //设置子元素
        engNameElement.addAttribute("like","apple");
        Element child2Element = engNameElement.addElement("see");  //设置子元素
        child2Element.setText("lily");  //设置子元素的值
        Element chiNameElement = root.addElement("id");
        chiNameElement.setText("1");
        /********删除节点********/
        root.remove(chiNameElement);
        return document;
    }

    /**
     * 传入字符串创建Document对象
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
        /*******测试xml文件生成******/
        Document document = createDom();
        XMLWrite(document,"src\\demo\\knowledgepoints\\dom4j\\1.xml");

        /*******测试xml文件生成******/
        document = createDom("<root><name like=\"apple\"><see>lily</see></name></root>");
        XMLWrite(document,"src\\demo\\knowledgepoints\\dom4j\\2.xml");

        /*******测试XML文件读取********/
        XMLRead("src\\demo\\knowledgepoints\\dom4j\\1.xml");
    }
}
