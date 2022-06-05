package e.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

//UDP Client
public class DatagramClientSample {
    public static void main(String[] args) {
        DatagramClientSample sample = new DatagramClientSample();
        sample.sendDatagramSample();
    }
    private final int PORT_NUM = 9999;
    private final String PROC_EXIT = "EXIT";

    public void sendDatagramSample() {
        for(int loop = 0; loop < 3; loop++) {
            sendDatagramData("I Liked UDP " + new Date());
        }
        sendDatagramData(PROC_EXIT);
    }

    public void sendDatagramData(String data) {
        try {
            //객체를 todtjd
            DatagramSocket client = new DatagramSocket();
            //서버 IP설정
            InetAddress address = InetAddress.getByName("127.0.0.1");

            byte[] buffer = data.getBytes();
            //data전송을 위한 패킷 설정
            DatagramPacket packet
                    = new DatagramPacket(buffer, 0, buffer.length, address,PORT_NUM);

            //전송후 종료
            client.send(packet);
            System.out.println("Client : send Data");
            client.close();
            Thread.sleep(1000);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
