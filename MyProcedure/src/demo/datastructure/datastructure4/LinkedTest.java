package demo.datastructure.datastructure4;

public class LinkedTest {
    public static void main(String[] args) {
        QueueLinked queueLinked = new QueueLinked();
        queueLinked.push("1");
        queueLinked.push(2);
        queueLinked.push("5");
        System.out.println(queueLinked.pop());
        queueLinked.push(7);
        queueLinked.push("9");
        System.out.println(queueLinked.pop());
        System.out.println(queueLinked.pop());
        queueLinked.display();
    }
}
