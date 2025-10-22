package E_Thread_using_Lambda_expression;

public class TraditionalExpression {
    public static void main(String[] args) {

//      Step_1:
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Traditional way to make a runnable interface. ");
            }
        };
//      Step_2:
        Thread thread = new Thread(runnable);

//      Step_3:
        thread.start();

//      Step_4:
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
