package org.codeforall.studio.exercise;

public class Hotel {

    private String hotel;
    private int maxCapacity=10;

    private int numGuests;

    


            public void setHotelName(String hotel){
        this.hotel = hotel ;
            }



                public int checkIn () {
                    if(numGuests<maxCapacity) {
                    numGuests++;
                    System.out.println("Guest successfully check in!");
                    return numGuests;
                    }else {
                        System.out.println("Sorry hotel is full!");
                        return -1;
                    }

                }
                public void checkOut(){
                    if(numGuests>0){
                    numGuests--;
                    System.out.println("Guest checked out sucessfully");
                    }else {
                        System.out.println("There is no guests to check out!");
                    }
                    }

    public String getName(String newName){

        return newName;



    }
}
