package com.basicjava.server;


import com.basicjava.server.handler.RequestHandler;

import java.net.ServerSocket;
import java.net.Socket;

// Web Server
//http://localhost:9000/today, http://localhost:9000/
public class SimpleWebServer {
    private final int WEB_SERVER_PORT = 9000;
    public static void main(String[] args) {
        SimpleWebServer server = new SimpleWebServer();
        int webServerPort = 9000;
        server.run(webServerPort);
    }

    public void run(int port) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            while(true) {
                Socket socket = server.accept();
                RequestHandler handler = new RequestHandler(socket);
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
