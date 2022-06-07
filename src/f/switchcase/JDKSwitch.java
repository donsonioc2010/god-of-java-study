package f.switchcase;

public class JDKSwitch {
    public static void main(String[] args) {
        JDKSwitch switchSample = new JDKSwitch();
        System.out.println(switchSample.jdk6Switch(3));
        System.out.println(switchSample.jdk7witch("DEVELOPER"));
    }

    //JDK6 이전 스위치 사용
    //SWITCH에서 숫자밖에 사용이 불가능함
    private double jdk6Switch(int employeeLevel) {
        //ENUM을 사용해도 됨
        final int CEO = 1;
        final int MANAGER = 2;
        final int ENGINEER = 3;
        final int DESIGNER = 4;

        switch (employeeLevel) {
            case CEO:
                return 10.0;
            case MANAGER:
                return 15.0;
            case ENGINEER:
                return 100.0;
            case DESIGNER:
                return 20.0;
        }
        return 0.0;
    }


    //JDK 7 이후 case문에 String의 사용이 가능해 짐
    private double jdk7witch(String employeeLevel) {
        //ENUM을 사용해도 됨
        switch (employeeLevel) {
            case "CEO":
                return 10.0;
            case "MANAGER":
                return 15.0;
            case "ENGINEER":
            case "DEVELOPER":
                return 100.0;
            case "DESIGNER":
            case "PLANNER":
                return 20.0;
        }
        return 0.0;
    }
}
