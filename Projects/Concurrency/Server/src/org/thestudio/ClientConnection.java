package org.thestudio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * represent connection
 */
public class ClientConnection implements Runnable {

    private Socket clientSocket;
    private Server server;
    private PrintWriter writer;
    private BufferedReader reader;
    private String name;
    private String message;


    public ClientConnection(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;

        try {
            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        //listen for client message

        System.out.println("Client connection established");
        writer.println("Insert your user name!");

        try {
            name = listen();

            while (server.showConnectedUsers().contains(name)) {
                writer.println("Name already exists!");
                writer.println("Choose other name");
                name = listen();
            }
            server.userAdd(name);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (!clientSocket.isClosed()) {
            try {
                String message = listen();
                server.broadcast(name + " >>> " + message);

                //CommandHandler.getCommand(message).run();
                if (message.equals(null)) {
                    quit();
                }

                if (message.equals(CommandHandler.QUIT.getCommand())) {
                    //The method is working, but the problem is on KeyboardHandler, when we ask to /quit he starts
                    // the code before we hit this method...so doesn't reach this part
                    server.removeName(name);

                }
                if (message.equals(CommandHandler.LIST.getCommand())) {
                    listUsers();
                }
                if (message.equals(CommandHandler.WHISPER.getCommand())) {
                    whisperOtherPerson();
                }
                if (message.equals(CommandHandler.NAME.getCommand())) {
                    changeName();
                }
                if (message.equals(CommandHandler.HELP.getCommand())) {
                    getHelp();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void listUsers() {
        writer.println(server.showConnectedUsers());
    }

    private void getHelp() {
        StringBuilder stringBuilder = new StringBuilder();

        for (CommandHandler command : CommandHandler.values()) {

            stringBuilder.append(">>> ")
                    .append(command.name())
                    .append(" -> ")
                    .append(command.getDescription())
                    .append("\n");
        }
        writer.println(stringBuilder);
    }

    private void whisperOtherPerson() {

        try {
            writer.println("Choose what person you want to whisper");
            String person = listen();
            writer.println("Choose what message you wanna send");
            message = listen();
            server.sendMessage(name, person, message);
            server.showConnectedUsers();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void changeName() {
        try {
            writer.println("Type your new name");
            String newName = null;
            newName = reader.readLine();
            server.setName(name, newName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return name;
    }

    public void quit() {
        try {
            server.remove(this);
            server.broadcast(Thread.currentThread().getName() + " has left the chat");
            clientSocket.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String listen() throws IOException {
        return reader.readLine();
    }

    public void send(String message) {
        writer.println(message);
    }


    public void sendMessage(String sender, String message) {
        writer.println(sender + ":" + message);
        writer.flush();
    }
}
