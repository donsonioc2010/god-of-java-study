package d.generic;

public class CarWildcardSample {
    public static void main(String[] args) {
        CarWildcardSample sample = new CarWildcardSample();
        sample.callBoundWildcardMethod();
        sample.callBusBoundWildcardMethod();
    }

    public void callBoundWildcardMethod() {
        WildcardGeneric<Car> wildcard = new WildcardGeneric<Car>();
        wildcard.setWildcard(new Car("Mustang"));
        boundedWildcardMethod(wildcard);
    }

    public void callBusBoundWildcardMethod() {
        WildcardGeneric<Bus> wildcard = new WildcardGeneric<Bus>();
        wildcard.setWildcard(new Bus("6960"));
        boundedWildcardMethod(wildcard);
    }

    public void boundedWildcardMethod(WildcardGeneric<? extends Car> c) {
        Car value = c.getWildcard();
        System.out.println(value);
    }
}
