package demo.datastructure.datastructure4;

public class QueueArray<E> {

    // 定义一个数组
    private Object[] data = null;

    // 记录队列长度
    private int size = 0;

    private int length = 0;

    private int point = 0;

    /**
     * 默认构造函数
     */
    public QueueArray(){
        length = 10;
        data = new Object[10];
    }

    /**
     * 自定义队列长度
     * @param length
     */
    public QueueArray(int length){
        this.length = length;
        data = new Object[length];
    }

    /**
     * 往队列里面加入数据
     * @param e
     */
    public void push(E e){
        data[size++] = e;
        size = size%length;
    }

    /**
     * 往队列里面获取数据
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
     * 打印队列
     */
    public void println(){
        for(int i =point ;i < size; i++){
            System.out.println(data[i]);
        }
    }
}
