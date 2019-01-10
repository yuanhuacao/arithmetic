package com.example.arithmetic.geektime.zhengyudi;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class SyncThread {


    public  static synchronized  void a() {
        System.out.println("a");
        try {
            Thread.sleep(1000 * 2);
            System.out.println("a done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static    synchronized   void b() {
        System.out.println("b");

    }
    private static   Byte[] lockObj=new Byte[0];
    public  void lock(){
        synchronized (lockObj){
            System.out.println("lockObj");
            try {
                Thread.sleep(1000 * 2);
                System.out.println("lockObj done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i <2 ; i++) {
            singleThreadPool.execute(()-> {
                        System.out.println(Thread.currentThread().getName()) ;
                        try {
                            Thread.sleep(1000000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
        singleThreadPool.shutdown();

        ExecutorService executorService=Executors.newFixedThreadPool(10);
        executorService.execute(()-> System.out.println("111"));

        SyncThread syncThread1 = new SyncThread();
        SyncThread syncThread2=new SyncThread();
        Thread a = new Thread(() -> {
            syncThread1.a();
        });
        Thread b = new Thread(() -> syncThread2.b());
        a.start();
        b.start();

    }
}
