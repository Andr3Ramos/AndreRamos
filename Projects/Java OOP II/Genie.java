public class Genie {

    // Instance variables
    private int maxWishes;   // Maximum number of wishes genie can grant
    public String wishType; // Type of wish
    private int wishesGranted; // Number of wishes granted
    public boolean isRecycled = false; // Whether the genie is recycled or not

    // Constructor
    public Genie(int newMaxWishes) {
        this.maxWishes = newMaxWishes;
    }

    // Setter method for wishType
    public void getWishType(String wishType) {
        this.wishType = wishType;
    }

    // Getter method for maxWishes
    public int getMaxWishes() {
        return maxWishes;
    }

    // Getter method for wishesGranted
    public int getWishesGranted() {
        return wishesGranted;
    }

    // Getter method for isRecycled
    public boolean getRecycled() {
        return isRecycled;
    }

    // Method to grant a wish
    public String grantWish(String wishType) {
        maxWishes--;
        // If the wishType is not recognized, return an error message
        return "The genie doesn't recognize that type of wish, please write in uppercase letters";
    }
}
