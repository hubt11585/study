package demo.design.composite.imp;

import demo.design.composite.abs.Node;

import java.io.File;

public class Clienter {
    public static void createTree(Node node) throws Exception{
        File file = new File(node.name);
        File[] f = file.listFiles();
        for(File fi : f){
            if(fi.isFile()){ //判断是否是一个文件
                Filer filer = new Filer(fi.getAbsolutePath());
                node.addNode(filer);
            }
            if(fi.isDirectory()){  //判断是否是一个文件夹
                Noder noder = new Noder(fi.getAbsolutePath());
                node.addNode(noder);
                createTree(noder);//使用递归生成树结构
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
