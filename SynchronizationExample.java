class Counter {
    private int count = 0;
    public synchronized void increment() {
        count++;
    }
    public synchronized void decrement() {
        count--;
    }
    public synchronized int getCount() {
        return count;
    }
}

class IncrementThread extends Thread {
    private Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

class DecrementThread extends Thread {
    private Counter counter;

    public DecrementThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.decrement();
        }
    }
}

public class SynchronizationExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        IncrementThread incrementThread1 = new IncrementThread(counter);
        IncrementThread incrementThread2 = new IncrementThread(counter);
        DecrementThread decrementThread1 = new DecrementThread(counter);
        DecrementThread decrementThread2 = new DecrementThread(counter);
        incrementThread1.start();
        incrementThread2.start();
        decrementThread1.start();
        decrementThread2.start();
        incrementThread1.join();
        incrementThread2.join();
        decrementThread1.join();
        decrementThread2.join();
        System.out.println("Final counter value:" + counter.getCount());
    }
}
