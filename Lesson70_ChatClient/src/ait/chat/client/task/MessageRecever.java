package ait.chat.client.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageRecever implements Runnable{
    private Socket socket;

    public MessageRecever(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String message = socketReader.readLine();
//                System.out.println(message instanceof String);
                if(message == null) {
                    break;
                }
                System.out.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
