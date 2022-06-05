package com.basicjava.server.handler;

import com.basicjava.server.dto.RequestDTO;
import com.basicjava.server.manager.RequestManager;
import com.basicjava.server.manager.ResponseManager;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.Socket;

// 동시에 들어온 요청을 처리하는데 사용됨
public class RequestHandler extends Thread{
    Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
        run();
    }
    private final int BUFFER_SIZE = 2048;

    @Override
    public void run() {
        RequestManager request = new RequestManager(socket);
        try {
            RequestDTO requestDto = request.readRequest();
            ResponseManager response = new ResponseManager(requestDto, socket);
            response.writeResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
