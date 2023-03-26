public class Counter {
    private int number;

    public void increment() throws InterruptedException {
        number++;
    }

    public void decrement() throws InterruptedException {
        number--;
    }

    public void printNumber() {
        System.out.println("Number: " + number);;
    }
}
