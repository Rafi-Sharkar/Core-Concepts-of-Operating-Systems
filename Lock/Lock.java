package Lock;

// Synchronization doesn't have control that which thread has more priority and how much time a thread locked a method. So here comes lock.
// Lock
// Two type of lock
// 1. Intrinsic, 2. Explicit

// Lock has 3 methods:
// lock.lock(), lock.trylock(), lock.unlock()

public class Lock {
    public static void main(String[] args) {
        BankAccount ib = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                ib.withdraw(50);
            }
        };

        Thread t1 = new Thread(task, "Thread_1");
        Thread t2 = new Thread(task, "Thread_2");

        t1.start();
        t2.start();

    }
}


