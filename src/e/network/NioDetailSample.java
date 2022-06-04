package e.network;

import java.nio.IntBuffer;

/**
 * 0 <= makr <= position <= limit <= 크기(capacity)
 */
public class NioDetailSample {
    public static void main(String[] args) {
        NioDetailSample sample = new NioDetailSample();
        //sample.checkBuffer();
        sample.checkBufferStatus();
    }

    public void checkBuffer() {
        try {
            IntBuffer buffer = IntBuffer.allocate(1024);
            for(int loop = 0; loop < 100; loop++)
                buffer.put(loop);

            // capacity()   : (Return값) 버퍼에 담을 수 있는 크기
            System.out.println("Buffer capacity = " + buffer.capacity());

            // limit()      : (Return값) 버퍼에서 읽거나 쓸 수 없는 첫 위치
            System.out.println("Buffer limit    = " + buffer.limit());

            // position()   : (Return값) 현재 버퍼의 위치
            System.out.println("Buffer position = " + buffer.position());

            // flip() : buffer에 담겨져 있는 데이터의 가장 앞으로 이동
            // 이미 최대치를 이동하였기에 현재 위치(position)가 0 으로 돌아가며, limit값의 변경이 이뤄짐
            // 비슷한 기능으로 rewind()가 있으녀, limit값의 변경이 없고 Return타입이 int가아닌 Buffer임
            buffer.flip();
            System.out.println("Buffer fliped");
            System.out.println("Buffer limit    = " + buffer.limit());
            System.out.println("Buffer capacity = " + buffer.capacity());
            System.out.println("Buffer position = " + buffer.position());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkBufferStatus() {
        try {
            IntBuffer buffer = IntBuffer.allocate(1024);

            buffer.get();
            printBufferStatus("get", buffer);

            buffer.mark(); //현재 position을 mark
            printBufferStatus("mark", buffer);

            buffer.get();
            printBufferStatus("get", buffer);

            buffer.reset(); //buffer의 position을 mark한 곳으로 이동
            printBufferStatus("reset", buffer);

            buffer.rewind(); //현재 buffer의 position을 0으로 이동
            printBufferStatus("rewind", buffer);

            buffer.clear(); // buffer를 지우고 현재 position을 0으로 이동하며, limitrkqtdmf qjvjdml zmrlfh qusrud
            printBufferStatus("clear", buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printBufferStatus(String job, IntBuffer buffer) {
        System.out.println("Buffer " + job + "!!!");
        System.out.format("Buffer Position=%d remaining=%d limit=%d\n",
                buffer.position(), buffer.remaining(), buffer.limit());
        //remaining = limit - position Value Return
    }

}
