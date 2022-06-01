package e.thread.support;

public class RunSupportThreads {
    public static void main(String[] args) {
        RunSupportThreads sample = new RunSupportThreads();
        //sample.checkThreadState1();
        sample.checkJoin();
    }

    public void checkThreadState1() {
        SleepThread thread = new SleepThread(2000);
        try {
            System.out.println("thread state = " + thread.getState());
            thread.start();
            System.out.println("thraed state(after Start) = " + thread.getState());

            Thread.sleep(1000);
            System.out.println("thread state(after 1Sec) = " + thread.getState());

            thread.join();
            thread.interrupt();
            System.out.println("thread state(after join) = " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkJoin() {
        SleepThread thread = new SleepThread(2000);
        try {
            thread.start();
            thread.join(500);
            thread.interrupt();
            /*
                sleep에 2000 mill Sec가 소요되었는데 메소드 대기가 500 mill Sec먼저 종료되고
                이후에 Interrupt로 종료를 하려니 Timed Waiting 상태로 인하여 Interrupt Exception의 발생
             * */
            System.out.println("thread state(after join) = " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
