package demo.design.composite.abs;
/**
 * ���ļ���Ŀ¼ͳһ������һ��ڵ㣬��һ�����������������ֽڵ㣬Ȼ������ʵ�����������ļ���Ŀ¼����ʵ�����зֱ�����Եľ���ʵ������
 */
public abstract class Node {
    public String name;//����
    //����������
    public Node(String name){
        this.name = name;
    }
    //�����ڵ㣺�ļ��ڵ��޴˷�����Ŀ¼�ڵ���д�˷���
    public void addNode(Node node) throws Exception{
        throw new Exception("Invalid exception");
    }
    //��ʾ�ڵ㣺�ļ���Ŀ¼��ʵ�ִ˷���
    public abstract void display();
}
