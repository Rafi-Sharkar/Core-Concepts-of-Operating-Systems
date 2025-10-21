public class ThreadPriority extends Thread{
    public ThreadPriority(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            for(int j=0; j<100000000;j++){

            }
            System.out.println(Thread.currentThread().getName() + "-Priority: " + Thread.currentThread().getPriority() + "-Count: " + i);
//            try {
//                Thread.sleep(2);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ThreadPriority mt1 = new ThreadPriority("Rafi");
        ThreadPriority mt2 = new ThreadPriority("Alif");
        ThreadPriority mt3 = new ThreadPriority("Hasan");
        mt1.setPriority(Thread.MIN_PRIORITY);
        mt2.setPriority(Thread.NORM_PRIORITY);
        mt3.setPriority(Thread.MAX_PRIORITY);

        mt1.start();
        mt2.start();
        mt3.start();
        mt1.join();
        mt2.join();
        mt3.join();
        long end = System.currentTimeMillis();

        System.out.println(end-start);

    }
}
