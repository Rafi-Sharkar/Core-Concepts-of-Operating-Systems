package F_Thread_Pooling_with_Executors_framework;

// Which problem solve Executor framework?
//      - Manual Thread management
//      - Resource management
//      - Scalability
//      - Thread reuse
//      - Error handling

// Executors Framework has three core interface:
//      - Executor
//      - ExecutorService
//      - ScheduledExecutorService

// Handled every task by developer.
// when we use executor framework, it can handle thread complexity and developer focus on system logic.

public class WithoutExecutorFramework {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[9];
        for(int i=1;i<10;i++){
            int finalI = i;
            threads[i-1] = new Thread(
                    ()->{
                        long result = factorial(finalI);
                        System.out.println(result);
                    }
            );
            threads[i-1].start();
        }

        for (Thread thread: threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Total time: " + (System.currentTimeMillis()-startTime));
    }

    private static long factorial(int n){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long result = 1;
        for (int i=1;i<=n;i++){
            result *= i;
        }
        return result;
    }
}

