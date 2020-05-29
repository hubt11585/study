package demo.datastructure.datastructure3;

/**
 * B+���Ķ��壺
 * 1.�����Ҷ�ӽ�������M���ӽڵ㣻��M>2��MΪB+���Ľ���
 * 2.�����������ķ�Ҷ�ӽ�������� (M+1)/2���ӽڵ㣻
 * 3.�����������2���ӽڵ㣻
 * 4.�����ڵ���ÿ����������٣�M-1��/2������M-1���ؼ��֣�������1���ؼ��֣�
 * 5.��Ҷ�ӽ�������ָ��ȹؼ��ֶ�1����
 * 6.��Ҷ�ӽڵ������key�������ţ�����ڵ�Ĺؼ��ֱַ�ΪK[0], K[1] �� K[M-2],ָ����Ů��ָ��ֱ�ΪP[0], P[1]��P[M-1]�����У�
 * ������P[0] < K[0] <= P[1] < K[1] ��..< K[M-2] <= P[M-1]
 * 7.����Ҷ�ӽ��λ��ͬһ�㣻
 * 8.Ϊ����Ҷ�ӽ������һ����ָ�룻
 * 9.���йؼ��ֶ���Ҷ�ӽ�����
 */

@SuppressWarnings("all")
public class BPlusTree<K extends Comparable<K>, V> {

    // ���ڵ�
    protected BPlusNode<K, V> root;

    // ÿ���ռ������Դ��������
    protected int order;

    // Ҷ�ӽڵ������ͷ
    protected BPlusNode<K, V> head;

    // ����
    protected int height = 0;

    public BPlusNode<K, V> getHead() {
        return head;
    }

    public void setHead(BPlusNode<K, V> head) {
        this.head = head;
    }

    public BPlusNode<K, V> getRoot() {
        return root;
    }

    public void setRoot(BPlusNode<K, V> root) {
        this.root = root;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public V get(K key) {
        return root.get(key);
    }

    public V remove(K key) {
        return root.remove(key, this);
    }

    public void insertOrUpdate(K key, V value) {
        root.insertOrUpdate(key, value, this);
    }

    public BPlusTree(int order) {
        if (order < 3) {
            System.out.print("order must be greater than 2");
            System.exit(0);
        }
        this.order = order;
        root = new BPlusNode<K, V>(true, true);
        head = root;
    }

    public void printBPlusTree() {
        this.root.printBPlusTree(0);
    }
}
