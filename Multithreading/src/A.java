public class A extends Thread{
    @Override
    public void run() {
        for(int i=0;i<10000;i++){
            System.out.println(Thread.currentThread().getName());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
