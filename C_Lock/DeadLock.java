package C_Lock;

// Four necessary conditions (called Coffman conditions) must exist simultaneously:
//1. Mutual exclusion --> A resource can be held by only one thread at a time.
//2. Hold and wait --> A thread holds one resource and waits for another.
//3. No preemption --> Resources cannot be forcibly taken from threads
//4. Circular wait --> A circular chain of threads exists, each waiting for the next.

// A deadlock occurs when two or more threads are waiting for each other’s resources and none can proceed.
// Example:
// Thread A holds Lock 1, waiting for Lock 2
// Thread B holds Lock 2, waiting for Lock 1



class Pen {
    public synchronized  void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName() + " is using pen "+ this + " and trying.");
        paper.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+ " finished using pen " + this);
    }
}

class Paper {
    public synchronized void writeWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName() + " is using paper " + this + " and trying");
        pen.finishWriting();
    }
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+ " finished using paper "+ this);
    }

}

class Task1 implements Runnable{
    private Pen pen;
    private Paper paper;

    public Task1(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper);    // thread_1 locks pen and tries to lock paper.
    }
}

class Task2 implements Runnable{
    private Pen pen;
    private Paper paper;

    public Task2(Pen pen, Paper paper){
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        synchronized (pen){
            paper.writeWithPaperAndPen(pen);    // thread2 locks paper and tries to lock pen.
        }
    }
}

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Pen pen = new Pen();
        Paper paper = new Paper();
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                paper.writeWithPaperAndPen(pen);
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                pen.writeWithPenAndPaper(paper);
            }
        };

//        Thread t1 = new Thread(task1, "Thread_1");
//        Thread t2 = new Thread(task2, "Thread_2");

        Thread t1 = new Thread(new Task1(pen, paper), "Thread_1");
        Thread t2 = new Thread(new Task2(pen, paper), "Thread_2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}
