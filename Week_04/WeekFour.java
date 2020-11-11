package io.github.kimmking.gateway;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WeekFour {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    long start=System.currentTimeMillis();
    int result = 0;


    //method1
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Callable<Integer> task = new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        return sum();
      }
    };
    Future<Integer> future = executorService.submit(task);
    result = future.get();

    //method2
    CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> sum());
    future1.thenAccept(result1 -> {
      System.out.println("异步计算结果为："+result1);
      System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    });
    future1.exceptionally(e -> {
      e.printStackTrace();
      return null;
    });
    Thread.sleep(3000);


    System.out.println("异步计算结果为："+result);
    System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
  }

  private static int sum() {
    return fibo(36);
  }

  private static int fibo(int a) {
    if ( a < 2)
      return 1;
    return fibo(a-1) + fibo(a-2);
  }
}
