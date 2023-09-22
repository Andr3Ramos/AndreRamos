import java.util.Arrays;

public class Playground {


    public static void main(String[] args){
        Genie[] genieList = new Genie[10];

        MagicLamp magicLamp2 = new MagicLamp(2);


        genieList[0]=magicLamp2.lampRub();
        genieList[1]=magicLamp2.lampRub();
        genieList[2]=magicLamp2.lampRub();




        System.out.println(genieList[1].grantWish("BAD"));
        System.out.println(genieList[1].grantWish("GOOD"));
        System.out.println(genieList[1].grantWish("ANY"));









    }


}
;