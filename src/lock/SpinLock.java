package lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by yusong on 15-12-10.
 * 说明：自旋锁
 */
public class SpinLock {

    private AtomicReference<Thread> sign =new AtomicReference<Thread>();

    public void lock(){
        Thread current = Thread.currentThread();
        while(!sign .compareAndSet(null, current)){
        }
    }

    public void unlock (){
        Thread current = Thread.currentThread();
        sign .compareAndSet(current, null);
    }
}