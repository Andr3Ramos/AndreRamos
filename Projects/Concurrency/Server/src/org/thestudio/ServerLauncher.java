package org.thestudio;

import java.io.IOException;

public class ServerLauncher {
    public static void main(String[] args) {
        try {
            Server server = new Server(8878);
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
