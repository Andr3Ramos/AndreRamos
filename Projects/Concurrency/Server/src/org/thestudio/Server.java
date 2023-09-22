package org.thestudio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * accepts client connections
 * receives message from client and broadcast message to other clients
 * thread1: awaits for client connections
 * thread2: reads incoming message and sends to other clients
 */
public class Server {

    private Socket clientSocket;
    private ServerSocket serverSocket;
    private List<ClientConnection> connections;
    private List<String> userNames;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        connections = Collections.synchronizedList(new LinkedList<>());
        userNames = new ArrayList<>();
    }

    public void start() throws IOException {
        System.out.println("Server init at port " + serverSocket.getLocalPort());

        while (true) {
            waitConnection();
        }
    }

    private void waitConnection() throws IOException {
        clientSocket = serverSocket.accept();
        ClientConnection connection = new ClientConnection(clientSocket, this);
        connections.add(connection);
        Thread thread = new Thread(connection);
        thread.start();
    }

    public synchronized void broadcast(String message) {
        for (ClientConnection client : connections) {
            client.send(message);
        }
    }

    public synchronized void remove(ClientConnection clientConnection) {
        connections.remove(clientConnection);
    }

    public String showConnectedUsers() {
        return userNames.toString();
    }

    public void setName(String oldName, String newName) {
        int index = userNames.indexOf(oldName);
        userNames.set(index, newName);
    }

    public void userAdd(String name) {
        userNames.add(name);
    }

    public void removeName(String name) {
        int index = userNames.indexOf(name);
        if (index != -1) {
            userNames.remove(index);
            connections.remove(index);
        }
    }

    public void sendMessage(String sender, String receiver, String message) {
        for (ClientConnection connection : connections) {
            if (connection.getName().equals(receiver)) {
                connection.sendMessage(sender, message);
            }
        }
        System.out.println("Recipient not found or not connected");
    }
}