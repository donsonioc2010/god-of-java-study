package g.defaultmethod;

public class DefaultMethodSample implements DefaultStaticInterface{
    public static void main(String[] args) {
        DefaultMethodSample sample = new DefaultMethodSample();
        System.out.println(sample.getName());
        System.out.println(sample.getSince());
        System.out.println(sample.getEmail());
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSince() {
        return since;
    }
}
