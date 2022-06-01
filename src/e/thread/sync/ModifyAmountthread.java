package e.thread.sync;

public class ModifyAmountthread extends Thread{
    private CommonCalculate calc;
    private boolean addFlag;
    private boolean syncBlock;

    public ModifyAmountthread(CommonCalculate calc, boolean addFlag) {
        this.calc = calc;
        this.addFlag = addFlag;
        syncBlock = true;
    }
    public ModifyAmountthread(CommonCalculate calc, boolean addFlag, boolean syncBlock) {
        this.calc = calc;
        this.addFlag = addFlag;
        this.syncBlock = syncBlock;
    }


    @Override
    public void run() {
        if (syncBlock) {
            for(int loop = 0; loop < 10000; loop++) {
                if(addFlag) {
                    calc.plus(1);
                } else {
                    calc.minus(1);
                }
            }
        } else {
            for(int loop = 0; loop < 10000; loop++) {
                calc.syncplus(1);
            }
        }
    }
}
