package com.jk.examples.java.domain.threads;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Getter
@Setter
@Slf4j
public class AlternateMessage {

    private AtomicBoolean helloPrintedV1 = new AtomicBoolean(false);

    private AtomicInteger firstCount = new AtomicInteger(0);

    public synchronized void printHelloV1() {
        if(helloPrintedV1.get() == false) {
            log.info(" Hello ");
            helloPrintedV1.compareAndSet(false, true);
        } else {
            try {
                wait();
                log.info(" Hello ");
                helloPrintedV1.compareAndSet(false, true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
    }

    public synchronized void printWorldV1() {
        if(helloPrintedV1.get() == true) {
            log.info(" World ");
            helloPrintedV1.compareAndSet(true, false);
        } else {
            try {
                wait();
                log.info(" World ");
                helloPrintedV1.compareAndSet(true, false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
    }

    public synchronized void printFirst() {
        if(firstCount.get() == 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info(" First ");
        firstCount.incrementAndGet();
        notifyAll();
    }

    public synchronized void printSecond() {
        if(firstCount.get() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info(" Second ");
        firstCount.decrementAndGet();
        notifyAll();
    }

    public void printHelloWorld(int count) {
        if (count <= 0)
            return;
        Runnable helloPrinter = () -> {
            printHelloV1();
        };
        Runnable worldPrinter = () -> {
            printWorldV1();
        };
        IntStream.range(0, count).forEach(i -> {
            Thread hello = new Thread(helloPrinter);
            Thread world = new Thread(worldPrinter);
            hello.start();
            world.start();

        });
    }

    public void printFirstSecond(int count) {
        if( count <= 0)
            return;
        AlternateMessage message = new AlternateMessage();
        Thread firstPrinter = new Thread(() -> {
            IntStream.range(0, count).forEach(
                    i -> {
                        message.printFirst();
                    }
            );
        });
        Thread secondPrinter = new Thread(() -> {
            IntStream.range(0, count).forEach(
                    i -> {
                        message.printSecond();
                    }
            );
        });
        try {
            firstPrinter.start();
            secondPrinter.start();
            firstPrinter.join();
            secondPrinter.join();
            log.info("Task done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void main(String [] args) {
        AlternateMessage message =  new AlternateMessage();
        message.printHelloWorld(10);
        message.printFirstSecond(10);

    }
}
