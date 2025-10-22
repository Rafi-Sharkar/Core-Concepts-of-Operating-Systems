package D_Thread_Communication;

// Thread Communication: thread communication means: How multiple threads coordinate with each other to share data or synchronize actions.
//Because threads run independently, they may:
// * Access the same object or variable at the same time, or
// * Depend on each other’s results.
//So they need a safe way to communicate and avoid race conditions or inconsistency.

// Java’s Object class provides three important methods for thread communication:
//      wait()      : Makes a thread release the lock and wait until another thread notifies it.
//      notify()	: Wakes up one waiting thread.
//      notifyAll()	: Wakes up all waiting threads on that object.

// Producer Consumer problems

class SharedResource{
    private int data;
    private boolean hasData;

    public synchronized void produce(int value){
        while (hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced "+ value);
        notify();
    }

    public synchronized void consume(){
        while (!hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consume "+ data);
        notify();
    }
}

class Producer implements Runnable{
    private SharedResource resource;

    public Producer(SharedResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i=0; i<10;i++){
            resource.produce(i);
        }
    }
}

class Consumer implements Runnable{
    private SharedResource resource;

    public Consumer(SharedResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i=0; i<10;i++){
             resource.consume();
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);

        Thread t1 = new Thread(producer, "Thread_Producer");
        Thread t2 = new Thread(consumer, "Thread_Consumer");

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
