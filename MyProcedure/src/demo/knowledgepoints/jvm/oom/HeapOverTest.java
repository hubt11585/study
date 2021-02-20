package demo.knowledgepoints.jvm.oom;

import java.util.ArrayList;
import java.util.List;

public class HeapOverTest {

    int[] intArr = new int[50];

    public static void main(String[] args) throws InterruptedException {
        List<HeapOverTest> heapOverTestList = new ArrayList<>();
        for(;;){
            Thread.sleep(1);
            heapOverTestList.add(new HeapOverTest());
        }
    }
}
