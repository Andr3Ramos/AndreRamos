package Classes;

import DataStructures.List;

import java.awt.*;

public class LinkedList implements List {

    private int size;

    private Node head;


    public LinkedList(){
        head = new Node(null);
    }


   @Override
   public boolean remove(Object data){

        Node iterator = head.getNext();

        if(size==0) {
           return false;
       }

       // Iterate through the list and remove the first node with a matching value
       for( int i=0; i < size; i ++ ){

           if (data.equals(iterator.getData())) {
               iterator.setData(null);
               size --;
                    }

           iterator = iterator.getNext();
       }

        return true;
   }


    @Override
    public boolean isEmpty() {
       return size == 0;
    }


    @Override
    public boolean add(Object data) {

        Node newNode = new Node(data);
        Node iterator = head;


        // Iterate through the list until the end is reached
        while(iterator.getNext() != null){
            iterator = iterator.getNext();
        }

        iterator.setNext(newNode);
        size++;
        return true;
    }


    @Override
    public boolean contains(Object data) {

        Node iterator=head.getNext();
        int index =0;

        while(iterator.getData() != data && size > index+1 ){
            iterator=iterator.getNext();
            index++;
        }

        return iterator.getData() == data;
    }

    @Override
    public void clear() {

        // Set the next node after to be null and reset the size to 0
        head.setNext(null);
        size = 0;
    }


    @Override
    public int getSize() {
        return this.size;
    }


    @Override
    public int indexOf(Object data) {

        int index = 0;
        Node iterator;

        if (data == null) {

            for (iterator = head; iterator != null; iterator = iterator.getNext()) {

                if (iterator.getData() == null) {
                    return index;
                }

                index++;
            }
        } else {
            // Iterate through the list until a matching value is found or the end is reached
            for (iterator=head; iterator != null; iterator = iterator.getNext()) {

                if (data.equals(iterator.getData())) {
                    return index;
                }

                index++;
            }
        }

        return -1;
    }


    @Override
    public Object get(int index) {

        Node iterator = head.getNext();

        if(index>size){
            return false;
        }

        for(int i=1;i<index;i++){
             iterator=iterator.getNext();
        }

        return iterator.getData();
    }


    @Override
    public List subList(int fromIndex, int toIndex) {

        LinkedList subList = new LinkedList();
        Node iterator = head;

        for (int i = fromIndex; i < toIndex ; i++){
            subList.add(iterator.getData());
            iterator=iterator.getNext();
        }

        return subList;
    }


}
