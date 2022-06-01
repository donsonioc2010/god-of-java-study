package e.thread.Object;

public class StateThread extends Thread {
    private Object monitor;

    public StateThread(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            for(int loop = 0; loop < 10000; loop++) {
                String a = "A";
            }

            synchronized (monitor) {
                monitor.wait();
            }

            System.out.println(getName()+" is notified");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
