package Classes;

import DataStructures.Set;

public class CustomSet implements Set {
  Node head;
  int size;



  public CustomSet(){
      head = new Node(null);
  }

    @Override
    public boolean add(Object data) {

        Node newNode = new Node(data);
        Node iterator = head;

        // Iterate through the list until the end is reached
        while(iterator.getNext() != null && iterator.getData() != data){
            iterator = iterator.getNext();
        }

        if (iterator.getData()==data){
            return false;
        }

        iterator.setNext(newNode);
        size++;
        return true;
    }


    @Override
    public boolean remove(Object data){

        Node iterator = head.getNext();

        if( size==0  ) {
            return false;
        }

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
        head.setNext(null);
        size = 0;
    }


    @Override
    public int getSize() {
        return size;
    }
}
