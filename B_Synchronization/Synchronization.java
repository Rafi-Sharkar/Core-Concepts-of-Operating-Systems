package B_Synchronization;

// We synchronize the critical section of code.
// Critical section: Where share resource are alter.
// We use synchronization technique
// By using the synchronization one thread can access at a time. It's called mutual exclusion.


public class Synchronization {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(counter.getCount());
    }
}


