package printer;

public class PrinterController {
    private static final int TOTAL_PRINTS = 15;
    private static final int PORTION_SIZE = 10;
    private static final int N_THREADS = 4;


    public static void main(String[] args) {
        Printer[] printers = new Printer[N_THREADS];

        for (int i = 0; i < N_THREADS; i++) {
            printers[i] = new Printer(PORTION_SIZE, (char) ('1' + i), TOTAL_PRINTS);
            printers[i].start();

        }
        for (int i = 0; i < N_THREADS; i++) {
            printers[i].setNext(printers[i< N_THREADS-1 ? i+1: 0]);

        }
        printers[0].interrupt();







    }
}
