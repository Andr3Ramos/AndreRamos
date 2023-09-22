import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Server {

    private static final int PORT = 8080;
    private static final String ROOT = "www";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleRequest(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) {
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            String[] part = line.split(" ");

            if (part.length != 3 || !part[0].equals("GET")) {
                sendErrorResponse(outputStream, 400, "Bad Request");
                return;
            }

            String path = part[1];
            if (path.equals("/")) {
                path = "/index.html";
            }

            Path filePath = Paths.get(ROOT + path);
            if (!Files.exists(filePath) || Files.isDirectory(filePath)) {
                sendErrorResponse(outputStream, 404, "Not Found");
                return;
            }

            String contentType = getContentType(filePath);
            byte[] fileBytes = Files.readAllBytes(filePath);

            sendResponse(outputStream, 200, "OK", contentType, fileBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendResponse(OutputStream outputStream, int statusCode, String statusText,
                                     String contentType, byte[] fileBytes) throws IOException {
        String response = "HTTP/1.0 " + statusCode + " " + statusText + "\n" +
                "Content-Type: " + contentType + "\n" +
                "Content-Length: " + fileBytes.length + "\n" +
                "\r\n";

        System.out.print(response);
        outputStream.write(response.getBytes());
        outputStream.write(fileBytes);
        outputStream.flush();
    }

    private static void sendErrorResponse(OutputStream outputStream, int statusCode, String statusText)
            throws IOException {
        Path errorFilePath = Paths.get(ROOT + "/404.html");
        byte[] errorFileBytes = Files.readAllBytes(errorFilePath);

        sendResponse(outputStream, statusCode, statusText, "text/html; charset=UTF-8", errorFileBytes);
    }

    private static String getContentType(Path filePath) throws IOException {
        String fileName = filePath.getFileName().toString();
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);

        switch (fileExtension.toLowerCase()) {
            case "html":
                return "text/html; charset=UTF-8";
            case "css":
                return "text/css";
            case "jpg":
            case "jpeg":
                return "image/jpeg";
            case "png":
                return "image/png";
            case "icn":
                return "image/x-icon";
            default:
                return "application/octet-stream";
        }
    }
}
