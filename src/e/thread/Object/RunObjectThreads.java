package e.thread.Object;

public class RunObjectThreads {
    public static void main(String[] args) {
        RunObjectThreads sample = new RunObjectThreads();
        //sample.checkThreadState2();
        sample.checkThreadState3();
    }

    public void checkThreadState2() {
        Object monitor = new Object();
        StateThread thread = new StateThread(monitor);

        try {
            System.out.println("thread state = "+thread.getState());
            thread.start();
            System.out.println("thread state(after Start) = "+thread.getState());

            Thread.sleep(100);
            System.out.println("thread state(after 0.1 sec) = "+thread.getState());

            synchronized (monitor) {
                monitor.notify();
            }

            Thread.sleep(100);
            System.out.println("thread state(after notify) = "+thread.getState());

            thread.join();
            System.out.println("thread state(after join) = " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void checkThreadState3() {
        Object monitor = new Object();
        StateThread thread = new StateThread(monitor);
        StateThread thread2 = new StateThread(monitor);

        try {
            System.out.println("thread state = "+thread.getState());
            thread.start();
            thread2.start();
            System.out.println("thread state(after Start) = "+thread.getState());

            Thread.sleep(100);
            System.out.println("thread state(after 0.1 sec) = "+thread.getState());

            synchronized (monitor) {
                //monitor.notify(); //먼저 대기하는 것부터 풀다보니 thread2에 대해서는 해제를 하지않음
                //monitor.notify(); //두개를 해제하려면 두번 선언해야함..
                monitor.notifyAll(); //Thread의 WAITING상태가 몇개가 될지 모르는 시점에서는 해당 방식이 사용하기 더 좋다.
            }

            Thread.sleep(100);
            System.out.println("thread state(after notify) = "+thread.getState());

            thread.join();
            System.out.println("thread state(after join) = " + thread.getState());
            thread2.join();
            System.out.println("thread2 state(after join) = " + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
