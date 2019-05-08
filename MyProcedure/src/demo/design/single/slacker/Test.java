package demo.design.single.slacker;

public class Test {

    public static void main(String[] args) {

        Thread2[] ThreadArr = new Thread2[10];
        for (int i = 0; i < ThreadArr.length; i++) {
            ThreadArr[i] = new Thread2();
            ThreadArr[i].start();
        }
    }

}
