package c.inner;

public class OuterOfInner {
    //Inner
    class Inner {
        private int value = 0;
        public int getValue() {
            return value;
        }
        public void setValue(int value){
            this.value = value;
        }
    }
}
