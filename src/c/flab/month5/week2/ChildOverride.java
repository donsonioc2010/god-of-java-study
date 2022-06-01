package c.flab.month5.week2;

public class ChildOverride extends ParentOverride {
    @Override
    public void overrideSample(String a) {
        System.out.println("ㅋㅋㅋㅋ;;;");
    }

    public static void main(String[] args) {
        ChildOverride a = new ChildOverride();
        a.overrideSample("a");
    }
}
