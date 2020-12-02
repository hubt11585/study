package demo.datastructure.datastructure4;

public class QueueLinked<E> {

    /**
     * 创建内部类链表的节点
     * @param <E>
     */
    private class Node<E>{
        public E data = null; //数据域
        public Node<E> next = null; //指针域

        //构造方法
        public Node(){}

        public Node(E data){
            this.data = data;
        }
    }

    private Node<E> head = null; //队头
    private Node<E> end  = null; //队尾
    private int size = 0;         //队列长度

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 往队列里面加入数据
     * @param e
     */
    public boolean push(E e){
        Node<E> node = new Node<E>(e);
        //队列为空的情况下
        if(isEmpty()){
            this.end = node; //尾节点赋值为新插入的节点
            this.head = this.end; //在只有一个节点的情况下，头尾节点相等
            size++;
            return true;
        }
        //不为空的情况下
        this.end.next = node; //尾节点指向新节点
        this.end = node; //更新尾节点
        size ++; //队列节点数+1
        return true;
    }

    /**
     * 出队
     * @return
     */
    public E pop(){
        //判断队列是否为空
        if(isEmpty()){
            System.err.println("队列为空");
            return null;
        }
        //弹出队头，更新队头指针
        Node<E> temp = this.head; //获取队头引用
        this.head = this.head.next; //更新队头指针
        temp.next = null; //释放原队头节点引用
        return temp.data;
    }

    /**
     * 打印数据
     */
    public void display(){
        for (int i = 0; i < this.size; i++) {
            if(this.head == null){
                return;
            }
            System.out.println(this.head.data);
            this.head = this.head.next;
        }
    }
}
