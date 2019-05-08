package demo.design.composite.imp;

import demo.design.composite.abs.Node;

import java.io.File;

public class Clienter {
    public static void createTree(Node node) throws Exception{
        File file = new File(node.name);
        File[] f = file.listFiles();
        for(File fi : f){
            if(fi.isFile()){ //�ж��Ƿ���һ���ļ�
                Filer filer = new Filer(fi.getAbsolutePath());
                node.addNode(filer);
            }
            if(fi.isDirectory()){  //�ж��Ƿ���һ���ļ���
                Noder noder = new Noder(fi.getAbsolutePath());
                node.addNode(noder);
                createTree(noder);//ʹ�õݹ��������ṹ
            }
        }
    }
    public static void main(String[] args) {
        Node noder = new Noder("E:\\WorkSpace\\MyProcedure");
        try {
            createTree(noder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        noder.display();
    }
}
