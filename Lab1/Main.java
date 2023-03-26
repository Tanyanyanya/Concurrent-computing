import javax.swing.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
//        === Balls ===
        BounceFrame frame = new BounceFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        System.out.println("Thread name = " +
                Thread.currentThread().getName());

//        === Printer ===
//        Printer printer = new Printer();
//
//        DashThread dashThread = new DashThread(printer);
//        dashThread.start();
//
//        LineThread lineThread = new LineThread(printer);
//        lineThread.start();

//        === Counter ===
//        Counter counter = new Counter();
//
//        ReentrantLock locker = new ReentrantLock();
//
//        IncrementThread incrementThread = new IncrementThread(counter, locker);
//        incrementThread.start();
//
//        DecrementThread decrementThread = new DecrementThread(counter, locker);
//        decrementThread.start();
//
//        try {
//            incrementThread.join();
//            decrementThread.join();
//        } catch (InterruptedException e) {
//        }
//
//        counter.printNumber();
    }
}
