package e.thread.sync;

public class CommonCalculate {
    private int amount;
    private int interest;

    private Object amountLock = new Object();
    private Object interestLock = new Object();

    public CommonCalculate() {
        amount = 0;
    }
    public CommonCalculate(int amount) {
        this.amount = amount;
    }
    public synchronized void plus(int value) {
        amount += value;
    }
    public void syncplus(int value) {
        //synchronized (this) {
        synchronized (amountLock) { //그냥 잠금을 위한 Object
            amount += value;
        }
    }

    public synchronized void minus(int value) {
        amount -= value;
    }

    public int getAmount() {
        return amount;
    }

    public void addInterest(int value) {
        synchronized (interestLock) {
            interest += value;
        }
    }
}
