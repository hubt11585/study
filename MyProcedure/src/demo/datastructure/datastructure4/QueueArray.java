package demo.datastructure.datastructure4;

public class QueueArray<E> {

    // ����һ������
    private Object[] data = null;

    // ��¼���г���
    private int size = 0;

    private int length = 0;

    private int point = 0;

    /**
     * Ĭ�Ϲ��캯��
     */
    public QueueArray(){
        length = 10;
        data = new Object[10];
    }

    /**
     * �Զ�����г���
     * @param length
     */
    public QueueArray(int length){
        this.length = length;
        data = new Object[length];
    }

    /**
     * �����������������
     * @param e
     */
    public void push(E e){
        data[size++] = e;
        size = size%length;
    }

    /**
     * �����������ȡ����
     */
    public E pull(){
        E e = (E)data[point];
        data[point] = null;
        if(point/length == 1){
            point = 0;
        } else {
            point++;
        }
        return e;
    }

    /**
     * ��ӡ����
     */
    public void println(){
        for(int i =point ;i < size; i++){
            System.out.println(data[i]);
        }
    }
}
