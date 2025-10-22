package F_Thread_Pooling_with_Executors_framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorFramework {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=1; i<10;i++){
            int finalI = i;
            executor.submit(()->{
                long result = factorial(finalI);
                System.out.println(result);
            });
        }

        executor.shutdown();    // It can't join all threads.
        try {
//            executor.awaitTermination(10000, TimeUnit.MILLISECONDS);  // it wait for 10s for join threads.
            while (!executor.awaitTermination(1000,TimeUnit.MILLISECONDS)){
                System.out.println("Waiting.....");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Duration: " + (System.currentTimeMillis()-startTime));
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
