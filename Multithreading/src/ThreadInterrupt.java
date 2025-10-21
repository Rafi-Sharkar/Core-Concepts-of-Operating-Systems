public class ThreadInterrupt extends Thread{
    public ThreadInterrupt(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Thread is running....");
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted:" + e);
        }
    }

    public static void main(String[] args) {
        ThreadInterrupt ti1 = new ThreadInterrupt("Rafi");
        ti1.start();
        ti1.interrupt();
    }
}
