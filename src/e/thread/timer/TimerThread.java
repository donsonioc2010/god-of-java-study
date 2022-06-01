package e.thread.timer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimerThread extends Thread {
    @Override
    public void run() {
        try {
            /*
            for(;;) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                System.out.println(formatter.format(date));
                sleep(1000);
            }
             */
            for(int i = 0; i < 10; i++) {
                currentTime();
                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void currentTime() {
        Date date = new Date();
        System.out.println(date.toString()+ " "+ System.currentTimeMillis());
    }
}
