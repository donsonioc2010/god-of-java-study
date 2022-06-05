package e.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

//UDP Server
public class DatagramServiceSample {
    public static void main(String[] args) {
        DatagramServiceSample sample = new DatagramServiceSample();
        sample.startServer();
    }
    private final int PORT_NUM = 9999;
    private final String PROC_EXIT = "EXIT";

    public void startServer() {
        DatagramSocket server = null;

        try {
            //객체 생성
            server = new DatagramSocket(PORT_NUM);
            int bufferLength = 256;
            byte[] buffer = new byte[bufferLength];

            DatagramPacket packet = new DatagramPacket(buffer, bufferLength);

            while(true) {
                System.out.println("Server : Waiting for request.");

                //데이터를 받기위해 대기
                server.receive(packet);
                int dataLength = packet.getLength();
                System.out.println("Server:received. Data length=" + dataLength);

                //byte배열로 되어있는 데이터를 String으로 변경
                String data = new String(packet.getData(), 0, dataLength);
                System.out.println("Received data : " + data);

                if(PROC_EXIT.equals(data)) {
                    System.out.println("Stop DatagramServer");
                    break;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(server != null) {
                try {
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
