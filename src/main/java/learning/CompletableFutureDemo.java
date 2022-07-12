package learning;

import java.util.concurrent.*;

public class CompletableFutureDemo {

    public static void main(String[] args) {

        // ListenableFuture
        /*ExecutorService executorService = Executors.newFixedThreadPool(5);
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);
        ListenableFuture<String> future1 = listeningExecutorService.submit(() -> {
            // 执行step 1
            System.out.println("执行step 1");
            return "step1 result";
        });
        ListenableFuture<String> future2 = listeningExecutorService.submit(() -> {
            // //step 2
            System.out.println("执行step 2");
            return "执行step 2";
        });
        ListenableFuture<List<String>> future1And2 = Futures.allAsList(future1, future2);
        Futures.addCallback(future1And2, new FutureCallback<List<String>>() {
            @Override
            public void onSuccess(List<String> strings) {
                System.out.println(strings);
                ListenableFuture<String> future3 = listeningExecutorService.submit(() -> {
                    System.out.println("执行step 3");
                    return "执行step 3";
                });
                Futures.addCallback(future3, new FutureCallback<String>() {
                    @Override
                    public void onSuccess(String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {

                    }
                }, listeningExecutorService);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        }, listeningExecutorService);*/

        // CompletableFuture
        ExecutorService service = Executors.newFixedThreadPool(5);
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行step 1");
            return "step1 result";
        }, service);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行step 2");
            return "step2 result";
        }, service);
        cf1.thenCombine(cf2, (result1, result2) -> {
            System.out.println(result1 + "," + result2);
            System.out.println("执行step 3");
            return "step3 result";
        }).thenAccept(System.out::println);

        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0L,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));
        CompletableFuture<String> futures = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync 执行线程：" + Thread.currentThread().getName());
            return "";
        }, executorService);
        futures.thenApply(value -> {
            System.out.println("thenApply 执行线程：" + Thread.currentThread().getName());
            return value + "1";
        });
        // 使用ForkJoinPool中的共用线程池CommonPool
        futures.thenApplyAsync(value -> {
            return value + "1";
        });
        //使用指定线程池
        futures.thenApplyAsync(value -> {
            return value + "1";
        }, executorService);
    }
}
