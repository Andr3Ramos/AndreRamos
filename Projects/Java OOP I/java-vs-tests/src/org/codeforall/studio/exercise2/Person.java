package org.codeforall.studio.exercise;

public class Person {

    private String name;

    private boolean isCheckedIn= true;

public static void main(String[] args){

    Hotel hotelName = new Hotel();

    hotelName.setHotelName("ab");

}


    public String getName(String newName){

        return newName;
    }

    public boolean checkIn(){
    if (!isCheckedIn) {
        isCheckedIn = true;
        return true;
    }else {
        return false;
    }
 }

    public boolean checkOut(){
        if(isCheckedIn){
            isCheckedIn = false;
            return true;
        }else {

            return false;
        }
    }


}
