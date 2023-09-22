package org.thestudio;

public enum CommandHandler {

    QUIT("/quit", "Leaves the server."),
    LIST("/list", "List of all connected users."),
    WHISPER("/whisper", "Whisper other person in the room."),
    NAME("/name", "Change your name."),
    HELP("/help", "All commands available.");


    private final String command;
    private final String description;


    CommandHandler(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }


}
