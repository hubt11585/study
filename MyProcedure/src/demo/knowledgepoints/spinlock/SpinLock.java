package demo.knowledgepoints.spinlock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    /**
     * ���������̣߳�null��ʾ��δ���̳߳���
     */
    private AtomicReference<Thread> ref = new AtomicReference<>();

    public void lock(){
        Thread currentThread = Thread.currentThread();
        while(!ref.compareAndSet(null, currentThread)){
            //��refΪnull��ʱ��compareAndSet����true����֮Ϊfalse
            //ͨ��ѭ�����ϵ������ж����Ƿ������̳߳���
        }
    }

    public void unLock() {
        Thread cur = Thread.currentThread();
        if(ref.get() != cur){
            //exception ...
        }
        ref.set(null);
    }
}
