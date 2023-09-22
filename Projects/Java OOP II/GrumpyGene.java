public class GrumpyGene extends Genie {
    // private member variables
    private int singleWish = 1;    // Just a single wish
    private boolean isRecycle = false;  // Recycle boolean

    // constructor
    public GrumpyGene(int maxWishes) {
        // calling parent constructor to set max wishes to 3
        super(3);
        // setting wish type to "ANY"
        getWishType("ANY");
    }

    // overriding the grantWish method from the parent class
    @Override
    public String grantWish(String wishType) {
        // if the genie has not granted a wish and is not recycled
        if (singleWish == 1 && isRecycle == false) {
            // generate a random number between 0 and 5 to pick a wish type from the enum
            int random = (int) (Math.random() * 6);
            // decrement the singleWish counter
            singleWish--;
            // return the description of the wish type from the enum
            return WishType.values()[random].getDescription();
        }
        // if the genie is recycled, then return a message stating so
        else if (isRecycle) {
            return "You cant ask for a wish, genie is recycled";
        }
        // if wishType is "ANY", generate a random wish type from the enum
        if (wishType.equals("ANY")) {
            int randomWish = (int) (Math.random() * 6);
            return WishType.values()[randomWish].getDescription();
        }
        // if the wish type is not "ANY" and the genie has already granted a wish, return a message stating so
        return "You have no more wishes";
    }

    // method to recycle the genie
    public boolean recycleGrumpy() {
        // set isRecycle to true
        isRecycle = true;
        // generate a random number between 1 and 2 to determine if the lamp is destroyed or not
        int destroyLamp = (int) (Math.random() * 2) + 1;
        if (destroyLamp == 1) {
            // if destroyLamp is 1, return true to indicate that the lamp is destroyed
            return true;
        }
        // if destroyLamp is 2, return false to indicate that the lamp is not destroyed
        return false;
    }
}
