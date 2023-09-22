public class Demon extends Genie {
    // constructor
    public Demon(int newMaxWishes) {
        // calling parent constructor to set max wishes
        super(newMaxWishes);
        // setting wish type to "BAD"
        wishType = "BAD";
    }

    // overriding the grantWish method from the parent class
    @Override
    public String grantWish(String wishType) {
        // if the wishType is "BAD", generate a random bad wish type from the enum
        if (wishType.equals("BAD")) {
            int randomBadWish = (int) (Math.random() * 3) + 3;
            return WishType.values()[randomBadWish].getDescription();
        }
        // if the demon is recycled, return a message stating so
        else if (getRecycled()) {
            return "You recycled the demon so, no more wishes to you";
        }
        // if the wish type is not "BAD", return a message stating that only "BAD" wishes can be granted
        else {
            return "I can only grant BAD wishes";
        }
    }
}


