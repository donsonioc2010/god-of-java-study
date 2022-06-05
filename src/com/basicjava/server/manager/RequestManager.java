package com.basicjava.server.manager;

import com.basicjava.server.dto.RequestDTO;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.Socket;

// 사용자에게 전달할 응답의 애용을 만들기 위해서 사용.
public class RequestManager {
    Socket socket;

    public RequestManager(Socket socket) {
        this.socket = socket;
    }
    private final int BUFFER_SIZE = 2048;
    public RequestDTO readRequest() throws Exception{
        InputStream request
                = new BufferedInputStream( socket.getInputStream() );

        byte [] receivedBytes =new byte[BUFFER_SIZE];
        request.read(receivedBytes);

        String requestData = new String(receivedBytes).trim();
        RequestDTO dto = new RequestDTO();

        if(requestData.contains("/today")) {
            dto.setUrl("/today");
        }

        return dto;
    }
}
