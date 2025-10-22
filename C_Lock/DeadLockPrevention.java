package C_Lock;

public class DeadLockPrevention {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void task1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " got lock1");
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " got lock2");
            }
        }
    }

    public void task2() {
        synchronized (lock1) { // same order as task1
            System.out.println(Thread.currentThread().getName() + " got lock1");
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " got lock2");
            }
        }
    }

    public static void main(String[] args) {
        DeadLockPrevention example = new DeadLockPrevention();
        new Thread(example::task1, "Thread-1").start();
        new Thread(example::task2, "Thread-2").start();
    }
}

