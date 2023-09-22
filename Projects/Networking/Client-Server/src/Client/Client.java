package Client;

import Server.Commands.Commands;

import java.io.*;
import java.net.Socket;
import java.nio.BufferOverflowException;

public class Client {

    private BufferedReader terminalReader;



    private BufferedReader serverReader;

    private BufferedWriter serverWriter;

    private Commands commands;
    private Socket socket;

    private String serverMessage;

    private String clientRoot="/home/learner/class00/assignments/week-10/andre-ramos/Client-Server/clientRoot";

    private String root ="/home/learner/class00/assignments/week-10/andre-ramos/Client-Server/root";


    private String line="";


    public Client() throws IOException {

        try {
            socket = new Socket("127.0.0.1", 9001);
            System.out.println("Connected to: " + socket);

            setUpSocketStreams();


        } catch (IOException e) {
            System.out.println("Error trying to connect.");
            throw new RuntimeException(e);

        }

        while (true) {

            if (line.equals(Commands.HELP.toString())) {

                while (true) {
                  serverMessage = serverReader.readLine();
                    System.out.println(serverMessage);
                    }
                                                 
            } else if (line.equals(Commands.LS.toString())) {

                while (true) {
                    serverMessage = serverReader.readLine();
                    System.out.println(serverMessage);
                }
            } else if (line.equals(Commands.GET.toString())) {
                String fileName = line.split(" ", 2)[1];
                handleGetCommand(fileName);

            }else if(line.equals(Commands.PUT.toString())){
                String fileName = line.split(" ", 2)[1];
                hadlePutCommand(fileName);

            } else if (line.equals(Commands.MKDIR)) {
                String fileName = line.split(" ", 2)[1];
                createDirectory(fileName);

            }

            line = terminalReader.readLine();
            serverWriter.write(line);
            serverWriter.newLine();
            serverWriter.flush();

        }
    }

    private void hadlePutCommand(String fileName) {
        try {
            serverWriter.write("GET " + fileName);
            serverWriter.newLine();
            serverWriter.flush();

            File newFile = new File(root, fileName);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            long fileSize = dataInputStream.readLong();
            byte[] buffer = new byte[4096];
            int bytesRead;

            try (FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
                while (fileSize > 0 && (bytesRead = dataInputStream.read(buffer, 0, (int) Math.min(buffer.length, fileSize))) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                    fileSize -= bytesRead;
                }
                fileOutputStream.flush();
            }

        } catch (IOException e) {
            System.out.println("Error during file transfer: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unexpected error during file transfer: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private void setUpSocketStreams () throws IOException {

            terminalReader = new BufferedReader(new InputStreamReader(System.in));

            serverWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            }

    private void handleGetCommand(String fileName) throws IOException {
        try {
            serverWriter.write("GET " + fileName);
            serverWriter.newLine();
            serverWriter.flush();

            File newFile = new File(clientRoot, fileName);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            long fileSize = dataInputStream.readLong();
            byte[] buffer = new byte[4096];
            int bytesRead;

            try (FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
                while (fileSize > 0 && (bytesRead = dataInputStream.read(buffer, 0, (int) Math.min(buffer.length, fileSize))) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                    fileSize -= bytesRead;
                }
                fileOutputStream.flush();
            }

        } catch (IOException e) {
            System.out.println("Error during file transfer: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unexpected error during file transfer: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void createDirectory(String dirName) throws IOException {
        File dir = new File(root, dirName);
        if (!dir.exists()) {
            if (dir.mkdirs()) {
                serverWriter.write("Directory created.\n");
            } else {
                serverWriter.write("Failed to create directory.\n");
            }
        } else {
            serverWriter.write("Directory already exists.\n");
        }
        serverWriter.flush();
    }







        public static void main (String[]args) throws IOException {
            new Client();
        }




}
