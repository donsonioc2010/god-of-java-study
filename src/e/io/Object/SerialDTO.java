package e.io.Object;

import java.io.Serializable;

public class SerialDTO implements Serializable {
    //serialVersionUID가 필요한 이유는 해당 객체의 버전정보를 생성하기 위함.
    //클래스 이름이 같더라도 ID가 다르면 다른 클래스로 인식하고, 같은UID라도 변수의 갯수, 타입이 달라도 다른 클래스로 인식한다.
    //해당UID는 보통 컴파일을 할 때 자동으로 생성된다.
    static final long serialVersionUID=1L;
    private String bookType = "IT";
    /*
    중간에 변수명이 바뀌어도 serialVersionUID가 같으면 객체를 불러오는데 문제가 발생하지는 않는다.
    하지만 바뀐 변수명의 데이터는 null로 불러와지기에 데이터가 꼬일 수 있슴.
    변경사항이 있는경우UID의 값을 변경하는 습관을 가지자..
     */
    private String bookName;
    transient private int bookOrder;
    // transient 예약어를 사용하게 되면 저장대상에서 제외됨.
    // 사용처는 패스워드같이 꼭 보낼필요는 없으나 사용을 해야할 변수같은거에 사용할 수 있슴.
    private boolean bestSeller;
    private long soldPerDay;

    public SerialDTO(String bookName, int bookOrder, boolean bestSeller, long soldPerDay) {
        super();
        this.bookName = bookName;
        this.bookOrder = bookOrder;
        this.bestSeller = bestSeller;
        this.soldPerDay = soldPerDay;
    }

    @Override
    public String toString() {
        return "SerialDTO{" +
                "bookType='" + bookType + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookOrder=" + bookOrder +
                ", bestSeller=" + bestSeller +
                ", soldPerDay=" + soldPerDay +
                '}';
    }
}
