package e.network;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

//TCP Server가 꺼진채로는 ConnectionException
public class SocketClientSample {
    public static void main(String[] args) {
        SocketClientSample sample = new SocketClientSample();
        sample.sendSocketSample();
    }

    private final String EXIT = "EXIT";
    public void sendSocketSample() {
        for(int loop=0; loop<3; loop++) {
            sendSocketData("I liked java at " + new Date());
        }
        sendSocketData(this.EXIT);
    }

    public void sendSocketData(String data) {
        Socket socket = null;

        try {
            System.out.println("Client : connecting");
            //객체 생성 및 접속
            //socket = new Socket("127.0.0.1", 9999);
            //socket = new Socket("localhost", 9999);

            //맥북
            socket = new Socket("192.168.0.19", 9999);

            //못찾음 ㅋㅋ;;;
            //socket = new Socket("192.168.0.16", 9999);


            System.out.println("Client : Connect Status = " + socket.isConnected());
            Thread.sleep(1000);

            //데이터 전송
            OutputStream stream = socket.getOutputStream();
            BufferedOutputStream out = new BufferedOutputStream(stream);

            byte[] bytes = data.getBytes();
            out.write(bytes);

            System.out.println("Client : Send data");
            out.close();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
