public class FriendlyGene extends Genie {

    // Instance variable that stores the maximum number of wishes for this genie


    // Constructor that initializes the maximum number of wishes and the wish type for this genie
    public FriendlyGene(int newMaxWishes) {
        super(newMaxWishes); // Call the superclass constructor to initialize the maximum number of wishes
        wishType = "GOOD"; // Set the wish type to "GOOD"
    }

    // Override the grantWish method from the Genie superclass
    @Override
    public String grantWish(String wishType) {
        if (this.wishType == wishType && getMaxWishes()>0) {
            // If the wish type matches and there are wishes left to grant, select a random good wish and return its description
             int randomGoodWish = (int) (Math.random() * 3);
            return WishType.values()[randomGoodWish].getDescription();
        } else {
            // If the wish type does not match or there are no wishes left to grant, return an error message
            return "I can't grant that wish to you!";
        }
    }
}
