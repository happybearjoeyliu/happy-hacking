package com.baidu.joey.happy.hacking.logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liuchao31 on 2016/12/8.
 */
public class Launcher {

    private static final Logger logger = LoggerFactory.getLogger(Launcher.class);

    private static final AtomicInteger num = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {
        logger.debug("------------");
        ExecutorService executorService = Executors.newFixedThreadPool(10, new ThreadFactory() {
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r,"T"+num.getAndIncrement());
                return thread;
            }
        });

        Thread.sleep(1000L);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                public void run() {
                    while (true){
                        logger.debug("soga.89898981321238129312093812093810293810293810923.");
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

    }
}
