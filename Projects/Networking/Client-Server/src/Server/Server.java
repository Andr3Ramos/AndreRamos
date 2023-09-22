package Server;

import Server.Commands.Commands;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;

public class Server {

private BufferedReader bufferedReader;

private BufferedWriter bufferedWriter;

private OutputStreamWriter bufferedOutputStream;

private BufferedInputStream bufferedInputStream;

private DataOutputStream dataOutputStream;


private ServerSocket serverSocket;

private Socket clientSocket;

private String clientMessage;
private Socket socket;

private Commands commands;
    private String directory ="/home/learner/class00/assignments/week-10/andre-ramos/Client-Server/root";
    private String clientDirectory = "/home/learner/class00/assignments/week-10/andre-ramos/Client-Server/clientRoot";




        public Server (int port){

            try {

               serverSocket=new ServerSocket(port);
               System.out.println("Waiting for client to connect...");

               clientSocket=serverSocket.accept();
               System.out.println("Client accepted.. " + clientSocket);

               setUpSocketStream();


               while(true){
                clientMessage = bufferedReader.readLine();


                   if (clientMessage == null ||
                       clientMessage.equals(Commands.QUIT.toString()) ||
                       clientMessage.equals(Commands.BYE.toString())  ||
                       clientMessage.equals(Commands.DISCONNECT.toString())) {
                       leavingServer();
                       break;


                   }

                   else if(clientMessage.equals(Commands.HELP.toString())){
                       System.out.println("Client command: " + Commands.HELP.toString());
                       getHelp();
                       continue;

                   }else if (clientMessage.equals(Commands.LS.toString())){
                       System.out.println("Client command: " + Commands.LS.toString());
                       lsCommand();
                       continue;
                   }else if (clientMessage.equals(Commands.GET.toString())){

                       System.out.println("Client command: " + Commands.GET.toString());
                       String fileName = clientMessage.split(" ", 2)[1];
                       System.out.println("Client requested the file: " + fileName);
                       sendFileToClient(fileName);
                       System.out.println("Sent " + clientMessage + " file");
                   }else if(clientMessage.equals((Commands.PUT.toString()))){
                       System.out.println("Client command: " + Commands.GET.toString());
                       String fileName = clientMessage.split(" ", 2)[1];
                       System.out.println("Send file to client: " + fileName);
                       getFilesFromServer(fileName);
                       System.out.println("Files " + clientMessage + " copied");
                   }else if(clientMessage.equals((Commands.MKDIR.toString()))){
                       String directoryName = clientMessage.split("",2)[1];
                       createDirectory(directoryName);


                   }



               }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

    private void getFilesFromServer(String fileName) {
        try {
            bufferedWriter.write("GET " + fileName);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            File newFile = new File(clientDirectory, fileName);

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



    private void sendFileToClient(String fileName) throws IOException {
        try {
            File fileToSend = new File(directory, fileName);
            if (!fileToSend.exists()) {
                bufferedOutputStream.write("File does not exist in the directory.\n");
                bufferedOutputStream.flush();
                return;
            }

            File clientFile = new File(clientDirectory, fileName);

            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileToSend));
                 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(clientFile))) {

                String line;
                while ((line = fileReader.readLine()) != null) {
                    fileWriter.write(line);
                    fileWriter.newLine();
                }
                fileWriter.flush();
                bufferedOutputStream.write("File sent.\n");
                bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            System.out.println("Error during file transfer: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unexpected error during file transfer: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private void leavingServer() throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        writer.write("Leaving Server...");
        writer.newLine();
        writer.flush();
    }

    private void commandNotFound() throws IOException {

      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

      writer.write("Not a valid command.");
      writer.newLine();
      writer.flush();

    }


    private void  getHelp() throws IOException {

    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

    clientMessage = showCommands();

    writer.write(clientMessage);
    writer.newLine();
    writer.flush();
}

    private String showCommands() {
        StringBuilder allCommands = new StringBuilder();

        for (Commands command : Commands.values()) {
            allCommands.append(command).append("\n");
        }

        return allCommands.toString();
    }

    private void createDirectory(String dirName) throws IOException {
        File dir = new File(directory, dirName);
        if (!dir.exists()) {
            if (dir.mkdirs()) {
                bufferedOutputStream.write("Directory created.\n");
            } else {
                bufferedOutputStream.write("Failed to create directory.\n");
            }
        } else {
            bufferedOutputStream.write("Directory already exists.\n");
        }
        bufferedOutputStream.flush();
    }





private void lsCommand() throws IOException {
    String directoryPath = directory;
    File directory = new File(directoryPath);

    if (directory.exists() && directory.isDirectory()) {
        File[] files = directory.listFiles();

        if (files != null) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            for (File file : files) {
                String fileName = file.getName();
                writer.write(fileName);
                writer.newLine();
                writer.flush();
            }

        }
    }
}

    private void setUpSocketStream () throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        bufferedOutputStream = new OutputStreamWriter(clientSocket.getOutputStream());
    }

    public static void main (String[]args){
        new Server(9001);
    }
}



