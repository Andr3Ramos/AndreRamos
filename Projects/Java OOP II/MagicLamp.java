public class MagicLamp {

    private int maxNumOfGenies;   //Maximum Genies number wish we will set when we call the obect
    private int numLeftGenies;     //Num of genies left
    private int rechargesLeft = 2;    // Number of recharges left
    private int totalNumGenies;      //  Total number of genies so Demons + Grumpy + Friendly

    private boolean isIntact = true;   // To see if the lamp is intact

    public MagicLamp(int maxNumOfGenies) {
        this.maxNumOfGenies = maxNumOfGenies;
            numLeftGenies=maxNumOfGenies;
    }

    public int getTotalNumGenies() {
        return totalNumGenies;
    }

    public int getNumLeftGenies() {
        return numLeftGenies;
    }

    public int getRechargesLeft() {
        return rechargesLeft;
    }

    public Genie lampRub() {
        //Lamp tub method instantiates a demon if we have charges
        int evenOdd = (int) (Math.random() * 10);
        //If we have no more genies left, we instantiate a demon
        if (numLeftGenies == 0){
            Demon demon = new Demon(3);
            totalNumGenies++;
            System.out.println("You have no more rubs!! A DEMON  appears ask your wish!");
            return demon;

        } else if (evenOdd % 2 == 0) {
            //If we get a even number we get the Grumpy genie
            GrumpyGene GrumpyGene = new GrumpyGene(3);
            numLeftGenies--;
            totalNumGenies++;
            System.out.println("You got the Grumpy Gene!");
            return GrumpyGene;

        } else {
            // If we get the odd number we get the Friendly genie
            FriendlyGene friendlyGene = new FriendlyGene(3);
            numLeftGenies--;
            totalNumGenies++;
            System.out.println("You got the Friendly Gene!");
            return friendlyGene;
        }
    }

    public String recycleDemon(Demon demon) {
            // We recycle a demon here
        numLeftGenies = maxNumOfGenies;
        if (numLeftGenies == maxNumOfGenies) {
            return "You cant recharge the lamp no recharges left or your lamp is already full";
        } else if (isIntact) {
            return "You Destroyed the lamp, no recycles for you";
        } else if (rechargesLeft == 0) {
            return "You have no recharges left";

        } else if (demon.getRecycled()) {
            demon.getRecycled();
            numLeftGenies++;
            totalNumGenies--;
            rechargesLeft--;
            return "You recycled a Demon";
        }
        return "This demon is already recycled!";
    }
    public String recycleGrumpy(GrumpyGene grumpyGene) {
            // We recycle a grumpy here
        numLeftGenies = maxNumOfGenies;
        if (numLeftGenies == maxNumOfGenies) {
            return "You cant recharge the lamp no recharges left or your lamp is already full";
        } else if (!isIntact) {
            return "You Destroyed the lamp, no recycles for you";
        } else if (rechargesLeft == 0) {
            return "You have no recharges left";

        } else if (!grumpyGene.recycleGrumpy()) {
            grumpyGene.recycleGrumpy();
            numLeftGenies++;
            totalNumGenies--;
            rechargesLeft--;
            return "You recycled a Demon";
        }
        return "This demon is already recycled!";
    }

    public boolean equals(MagicLamp magicLamp){
        // Here we compare the lamps
        if(this.getTotalNumGenies()==magicLamp.getTotalNumGenies()  &&  this.getNumLeftGenies()==magicLamp.getNumLeftGenies()  &&  this.getRechargesLeft()==magicLamp.getRechargesLeft()){
        return true;}
        return false;
    }





   }

