public class ThreadOne extends Thread {
    private Thread t;

    public ThreadOne() {
    }

    public ThreadOne(Thread anotherThread) {
        t = anotherThread;
    }

    @Override
    public void run() {
        if (t != null) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (int i = 0; i <= 20; i++) {
            System.out.println(getName() + " hi: " + i);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
