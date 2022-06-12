package g.defaultmethod;

public interface DefaultStaticInterface{
    static final String name = "GodOfJavaBook";
    static final int since = 2013;
    String getName();
    int getSince();

    //인터페이스에서 default로 선언한 메소드를 default Method로 부름
    default String getEmail() {
        return name+"@godofjava.com";
    }

}
