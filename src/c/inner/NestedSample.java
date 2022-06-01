package c.inner;

public class NestedSample {
    public static void main(String[] args) {
        NestedSample sample = new NestedSample();
        sample.makeStaticNestedObject();
    }
    public void makeStaticNestedObject() {
        OuterOfStatic.staticNested staticNested = new OuterOfStatic.staticNested();
        staticNested.setValue(3);
        System.out.println(staticNested.getValue());
    }
}
