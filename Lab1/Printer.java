public class Printer {

    private boolean dashTurn = true;

    public synchronized void printLine() throws InterruptedException {
        if (dashTurn) {
            wait();
        }
        System.out.println("|");
        dashTurn = true;
        notifyAll();
    }

    public synchronized void printDash() throws InterruptedException {
        if (!dashTurn) {
            wait();
        }
        System.out.println("-");
        dashTurn = false;
        notifyAll();
    }
}
