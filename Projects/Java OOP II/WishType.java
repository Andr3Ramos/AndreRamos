import java.util.Random;

public enum WishType {

    // Enum constants with their descriptions
    WEALTH("YOU WILL BE GRANTED THE WISH OF WEALTH, YOU ARE NOW A MILLIONAIRE!"),
    FAME("YOU WILL BE GRANTED THE WISH OF FAME, YOU ARE NOW A POP STAR!"),
    LUCK("YOU WILL BE GRANTED THE WISH OF LUCK, GO PLAY IN EURO MILLIONS!"),
    POOR("YOU WILL BE GRANTED THE WISH OF POOR, YOU WILL NEED TO WORK!"),
    SICKNESS("YOU WILL BE GRANTED THE WISH OF SICKNESS, GO CHECK THE DOCTOR!"),
    BADLUCK("YOU WILL BE GRANTED THE WISH OF BADLUCK, DON'T ENTER IN A CASINO!");

    // Instance variable to store the description
    private String description;

    // Constructor that initializes the description for each enum constant
    WishType(String description) {
        this.description = description;
    }

    // Getter method that returns the description for a given enum constant
    public String getDescription() {
        return description;
    }
}
