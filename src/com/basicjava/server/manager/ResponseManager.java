package com.basicjava.server.manager;

import com.basicjava.server.dto.RequestDTO;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;

public class ResponseManager {
    private RequestDTO requestDto;
    private Socket socket;

    public ResponseManager(RequestDTO requestDto, Socket socket) {
        this.requestDto = requestDto;
        this.socket = socket;
    }

    public void writeResponse() throws Exception{
        //Make Response Data and Reponse
        PrintStream response =
                new PrintStream(socket.getOutputStream());
        response.println("HTTP/1.1 200 OK");
        response.println("Content-type: text/html");
        response.println();

        String getUrl = requestDto.getUrl();
        if("/".equals(getUrl)) {
            response.print("It is working");
        } else if("/today".equals(getUrl)) {
            response.print(new Date());
        }
        response.flush();
        response.close();
    }
}
