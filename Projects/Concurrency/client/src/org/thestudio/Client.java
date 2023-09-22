package org.thestudio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * represents tcp chat client
 * reads from message keyboard
 * sends message
 * listens for server incoming messages
 * <p>
 * thread1:listens for server messages
 * thread2:reads from keyboard and sends to server
 */
public class Client {

    private final Socket socket;

    public Client(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    public void start() throws IOException {

        Thread thread = new Thread(new KeyboardHandler(socket));
        thread.start();
        ;
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while (socket.isBound()) {
            waitMessage(reader);
        }
    }

    /**
     * waits message from server and prints it to console
     */
    private void waitMessage(BufferedReader reader) throws IOException {
        String message = reader.readLine();
        if (message.equals(null)) {
            System.out.println("Connection with server was lost");
            System.exit(0);
        }
        System.out.println(message);
    }

}
