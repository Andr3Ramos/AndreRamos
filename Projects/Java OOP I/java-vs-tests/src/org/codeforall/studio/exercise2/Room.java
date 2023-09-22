package org.codeforall.studio.exercise;

public class Room {

    private int roomNumber;
    private boolean isAvailable;




    public Room(int roomNumber){
        this.roomNumber= roomNumber;
        isAvailable = true;
    }
    public boolean isAvailable() {

return isAvailable;
    }



    public void occupied(){
        if(isAvailable){
            isAvailable=false;
            System.out.println("Room number "+ roomNumber + "marked as occupied");
        }else{
            System.out.println("Room number "+ roomNumber + "is already occupied");
        }



    }


    public void vacate(){
        if(!isAvailable){
            isAvailable= true;
            System.out.println("Room number"+roomNumber+"marked as vacated");
        }else {
            System.out.println("Room number" + roomNumber+ "is already vacated");
        }


    }

}
