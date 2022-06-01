package e.thread.sync;

public class RunSync {

    public static void main(String[] args) {
        RunSync sample = new RunSync();
        for (int loop = 0; loop < 5; loop++) {
            //sample.runCommonCalcuate();
            //sample.runCommonCalcuateMinus();
        }
        sample.runCommonCalcuateSyncPlutBlock();
    }

    public void runCommonCalcuate() {
        CommonCalculate calc = new CommonCalculate();
        ModifyAmountthread thread1 = new ModifyAmountthread(calc, true);
        ModifyAmountthread thread2 = new ModifyAmountthread(calc, true);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            System.out.println("Final value is "+ calc.getAmount());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void runCommonCalcuateMinus() {
        CommonCalculate calc = new CommonCalculate(20000);
        ModifyAmountthread thread1 = new ModifyAmountthread(calc, false);
        ModifyAmountthread thread2 = new ModifyAmountthread(calc, false);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            System.out.println("Final value is "+ calc.getAmount());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void runCommonCalcuateSyncPlutBlock() {
        CommonCalculate calc = new CommonCalculate();
        ModifyAmountthread thread1 = new ModifyAmountthread(calc, true, false);
        ModifyAmountthread thread2 = new ModifyAmountthread(calc, true, false);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            System.out.println("Final value is "+ calc.getAmount());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
