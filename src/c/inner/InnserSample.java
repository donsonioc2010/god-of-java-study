package c.inner;

public class InnserSample {
    public static void main(String[] args) {
        InnserSample sample = new InnserSample();
        sample.makeInnerObject();
    }

    public void makeInnerObject() {
        OuterOfInner outer = new OuterOfInner();
        OuterOfInner.Inner inner = outer.new Inner();
        inner.setValue(3);
        System.out.println(inner.getValue());
    }

}
