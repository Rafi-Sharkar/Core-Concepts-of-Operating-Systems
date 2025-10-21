package Synchronization;

public class Counter {
    private int count = 0;

    // one thread can access at a time in this method after using synchronization. It blocked race condition. It's called mutual exclusion.
    public synchronized void increment(){
        count++;
    }

    public void decrement(){
        synchronized (this){
            count--;
        }
    }
    public int getCount(){
        return count;
    }
}
