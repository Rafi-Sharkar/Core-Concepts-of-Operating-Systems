package Multithreading;


public class ThreadYield extends Thread{
    public ThreadYield(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+ " running");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        ThreadYield ty1 = new ThreadYield("Rafi");
        ThreadYield ty2 = new ThreadYield("Hasan");

        ty1.start();
        ty2.start();


    }
}
