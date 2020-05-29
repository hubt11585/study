package demo.datastructure.datastructure3;

/**
 * B+树的定义：
 * 1.任意非叶子结点最多有M个子节点；且M>2；M为B+树的阶数
 * 2.除根结点以外的非叶子结点至少有 (M+1)/2个子节点；
 * 3.根结点至少有2个子节点；
 * 4.除根节点外每个结点存放至少（M-1）/2和至多M-1个关键字；（至少1个关键字）
 * 5.非叶子结点的子树指针比关键字多1个；
 * 6.非叶子节点的所有key按升序存放，假设节点的关键字分别为K[0], K[1] … K[M-2],指向子女的指针分别为P[0], P[1]…P[M-1]。则有：
 * 　　　P[0] < K[0] <= P[1] < K[1] …..< K[M-2] <= P[M-1]
 * 7.所有叶子结点位于同一层；
 * 8.为所有叶子结点增加一个链指针；
 * 9.所有关键字都在叶子结点出现
 */

@SuppressWarnings("all")
public class BPlusTree<K extends Comparable<K>, V> {

    // 根节点
    protected BPlusNode<K, V> root;

    // 每个空间最多可以存多少数据
    protected int order;

    // 叶子节点的链表头
    protected BPlusNode<K, V> head;

    // 树高
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
