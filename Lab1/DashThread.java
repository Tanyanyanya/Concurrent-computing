public class DashThread extends Thread {

    private Printer printer;

    public DashThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                printer.printDash();
                Thread.sleep(10);
            }
        } catch (InterruptedException ex) {
        }
    }
}
