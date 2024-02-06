package withRunnable;

public class Main {
    public static void main(String[] args) {
        Thread t3 = new Thread(Main::printNumbers);

        Thread t2 = new Thread(() -> {
            try {
                t3.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            printNumbers();
        });

        Thread t1 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            printNumbers();
        });

        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");

        t1.start();
        t2.start();
        t3.start();
    }

    private static void printNumbers() {
        for (int i = 0; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName() + " hi: " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
