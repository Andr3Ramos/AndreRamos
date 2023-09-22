package org.thestudio;

import java.io.IOException;

public class ClientLauncher {
    public static void main(String[] args) {
        try {
            Client client = new Client("localhost", 8878);
            client.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
