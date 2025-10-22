package A_Multithreading;


public class ThreadDaemon extends Thread{
    public ThreadDaemon(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true){
            System.out.println("Hello, World");
        }
    }

    public static void main(String[] args) {
        ThreadDaemon td1 = new ThreadDaemon("Rafi");
        td1.setDaemon(true);
        td1.start();
        System.out.println("Hello, Done");
    }
}
