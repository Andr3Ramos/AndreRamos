package org.thestudio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class KeyboardHandler implements Runnable {

    private Socket socket;

    public KeyboardHandler(Socket socket) {
        this.socket = socket;
    }

    /**
     * listens for message from keyboard input
     * sends message to server
     */
    @Override
    public void run() {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            while (!socket.isClosed()) {
                String message = scanner.nextLine();
                if (message.equals("/quit")) {
                    System.out.println("Closing the app....");
                    System.exit(0);
                }
                writer.println(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
