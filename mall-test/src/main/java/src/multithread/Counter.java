package src.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author zhanglianquan
 * @Description 不使用atomic* 原子类型及第3方包实现一个计数器
 * @Date 2020/1/20
 **/
public class Counter {
    static int count = 0;

    public static synchronized void incr() {
        count++;
    }

    public static void safeCount() throws InterruptedException {
        long t1 = System.currentTimeMillis();
        int threadCount = 100;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 10000; j++) {
                        incr();
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        long t2 = System.currentTimeMillis();
        System.out.println(String.format("结果：%s,耗时(ms)：%s", count, (t2 - t1)));
    }
}

