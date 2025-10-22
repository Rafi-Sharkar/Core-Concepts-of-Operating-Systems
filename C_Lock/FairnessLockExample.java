package C_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Thread starvation happens when one or more threads never get access to a shared resource because other threads keep taking the lock first.
// "private final Lock lock = new ReentrantLock(true);" it solve the starvation problem. And work like First Come First Serve or FIFO.

public class FairnessLockExample {

    private final Lock lock = new ReentrantLock(true);

    public void accessResource(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+ " acquired the lock");
            Thread.sleep(500);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            System.out.println(Thread.currentThread().getName()+ " released the lock");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FairnessLockExample example = new FairnessLockExample();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };

        Thread t1 = new Thread(task, "Thread_1");
        Thread t2 = new Thread(task, "Thread_2");
        Thread t3 = new Thread(task, "Thread_3");

        t1.start();
        t3.start();
        t2.start();

    }
}
