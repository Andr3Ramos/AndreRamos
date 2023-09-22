package Classes;

import DataStructures.Queue;

public class CustomQueue implements Queue {
    Node head;
    int size;

    public CustomQueue() {
        head = new Node(null);
    }

    @Override
    public boolean add(Object data) {

        Node newNode = new Node(data);
        Node iterator = head;

        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }

        iterator.setNext(newNode);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object data) {

        Node iterator = head.getNext();

        if (size == 0) {
            return false;
        }


        for (int i = 0; i < size; i++) {

            if (data.equals(iterator.getData())) {
                iterator.setData(null);
                size--;
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


    @Override
    public boolean offer(Object data) {
        return add(data);
    }


    @Override
    public Object peek() {
        return head.getNext().getData();
    }


    @Override
    public Object pool() {
        if (size == 0) {
            return false;
        }

        // Set the next node of the head to the node after the next node
        head.setNext(head.getNext().getNext());
        size--;
        return true;
    }
}
