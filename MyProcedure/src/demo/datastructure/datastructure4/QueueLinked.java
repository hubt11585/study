package demo.datastructure.datastructure4;

public class QueueLinked<E> {

    /**
     * �����ڲ�������Ľڵ�
     * @param <E>
     */
    private class Node<E>{
        public E data = null; //������
        public Node<E> next = null; //ָ����

        //���췽��
        public Node(){}

        public Node(E data){
            this.data = data;
        }
    }

    private Node<E> head = null; //��ͷ
    private Node<E> end  = null; //��β
    private int size = 0;         //���г���

    /**
     * �ж϶����Ƿ�Ϊ��
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * �����������������
     * @param e
     */
    public boolean push(E e){
        Node<E> node = new Node<E>(e);
        //����Ϊ�յ������
        if(isEmpty()){
            this.end = node; //β�ڵ㸳ֵΪ�²���Ľڵ�
            this.head = this.end; //��ֻ��һ���ڵ������£�ͷβ�ڵ����
            size++;
            return true;
        }
        //��Ϊ�յ������
        this.end.next = node; //β�ڵ�ָ���½ڵ�
        this.end = node; //����β�ڵ�
        size ++; //���нڵ���+1
        return true;
    }

    /**
     * ����
     * @return
     */
    public E pop(){
        //�ж϶����Ƿ�Ϊ��
        if(isEmpty()){
            System.err.println("����Ϊ��");
            return null;
        }
        //������ͷ�����¶�ͷָ��
        Node<E> temp = this.head; //��ȡ��ͷ����
        this.head = this.head.next; //���¶�ͷָ��
        temp.next = null; //�ͷ�ԭ��ͷ�ڵ�����
        return temp.data;
    }

    /**
     * ��ӡ����
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
