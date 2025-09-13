package printer;

public class Printer extends Thread {
    private final char symbol;
    private final int totalPrints;
    private final int portionSize;
    private int printed = 0;
    private Printer next;

    public Printer(int portionSize, char symbol, int totalPrints) {
        this.portionSize = portionSize;
        this.symbol = symbol;
        this.totalPrints = totalPrints;
    }

    public void setNext(Printer next) {
        this.next = next;
    }

    @Override
    public void run() {
        while (printed < totalPrints) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {

                for (int i = 0; i < Math.min((totalPrints - printed), portionSize); i++) {


                    System.out.print(symbol);

                }
                System.out.println();
                printed += portionSize;

                if (next != null)
                    next.interrupt();
            }
        }
    }
}