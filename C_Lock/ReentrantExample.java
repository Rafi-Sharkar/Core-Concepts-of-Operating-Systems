package C_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// reentrantLock has lock, unlock, trylock(without time, with time), deadlock prevention, lockInterruptibly

// re-entrant-Lock(ReentrantLock) means after lock again thread can enter a method.

// reentrantLock use count of lock(1) and unlock(-1).
// Below outerMethod acquire the lock and total count will be 1.
// Then innerMethod is called, it acquired again lock then lock count will 2
// then innerMethod unlock then count will 1 and at outerMethod again unlock then finally total count will be 0.

public class ReentrantExample {
    private final Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock();
//        lock.lockInterruptibly();
        try{
            System.out.println("Outer method");
            innerMethod();
        }finally {
            lock.unlock();
        }
    }

    public void innerMethod(){
        lock.lock();
        try{
            System.out.println("Inner method");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();
        example.outerMethod();
    }
}
