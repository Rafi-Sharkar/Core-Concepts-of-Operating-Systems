package C_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Multiple threads to read a shared resource simultaneously, but
// Only one thread to write (and while writing, no one can read).

public class ReadWriteCounter {
    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment(){
        writeLock.lock();
        try{
            count++;
        }finally {
            writeLock.unlock();
        }
    }

    public int getCount(){
        readLock.lock();
        try{
            return count;
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteCounter counter = new ReadWriteCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+ " read: "+ counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented ");
                }
            }
        };


        Thread writeThread = new Thread(writeTask);
        Thread readThread1 = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);

        writeThread.start();
        readThread1.start();
        readThread2.start();

        try {
            writeThread.join();
            readThread1.join();
            readThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final count: "+ counter.getCount());
    }
}
