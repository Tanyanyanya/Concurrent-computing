public class LineThread extends Thread {

    private Printer printer;

    public LineThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                printer.printLine();
                Thread.sleep(10);
            }
        } catch (InterruptedException ex) {
        }
    }
}
