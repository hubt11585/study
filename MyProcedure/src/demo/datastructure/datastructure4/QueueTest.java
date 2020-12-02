package demo.datastructure.datastructure4;

public class QueueTest {

    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray();
        queueArray.push("1");
        queueArray.push(2);
        queueArray.push("5");
        System.out.println(queueArray.pull());
        queueArray.push(7);
        queueArray.push("9");
        System.out.println(queueArray.pull());
        System.out.println(queueArray.pull());
        queueArray.println();
    }
}
