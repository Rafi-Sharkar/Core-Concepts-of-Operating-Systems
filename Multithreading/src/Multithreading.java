// Thread contain some methods:
// Start(), run(), sleep(), join(), setPriority(), interrupt(), yield(), setDaemon()

public class Multithreading {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Hello, world");

        // When a java program start, one thread begins running immediately, Which is called the main thread. This thread is responsible for execution the main method of a program.
//        System.out.println(Thread.currentThread().getName());

//      Thread Lifecycle--> New, Runnable, Running, Blocked/Waiting, Terminated
        A a = new A();  // New = It is created but not yet started.
        a.start();      // Runnable = After the start method is called, Thread goes to Running Queue(it holds processes that are ready to run) of CPU
                        // Running = The thread is in this state when it is executing.
                        // Blocked/Waiting = It is waiting for a resource or for another thread to perform an action.
                        // Terminated = A thread is in this state when it has finished execution.

        B b = new B();
        Thread t1 = new Thread(b);
        System.out.println(t1.getState());
        t1.start();
        t1.join();
        Thread.sleep(100);  // Pause execution of this thread for 0.1 second.



        for(int i=0;i<10000;i++){
            System.out.println(Thread.currentThread().getName());
        }




    }
}
