package threads;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final int bufferSize = 4;
    private static final Queue<Integer> buffer = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(() -> {
            int i = 1;
            while (true) {
                synchronized (buffer) {
                    while (buffer.size() >= bufferSize) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                           System.err.println(e.getMessage());
                        }
                    }
                    buffer.add(i);
                    System.out.println("Produced: " + i);
                    i++;
                    buffer.notify();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        });
        Thread consumer = new Thread(() -> {
            while (true) {
                synchronized (buffer) {
                    while (buffer.isEmpty()) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    int consumed = buffer.remove();
                    System.out.println("Consumed: " + consumed);
                    buffer.notify();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}