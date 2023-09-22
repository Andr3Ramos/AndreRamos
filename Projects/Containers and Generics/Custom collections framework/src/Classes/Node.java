package Classes;

public class Node {

private Node next;


private Object data;


public Node(Object data){
    this.data=data;
    this.next= null;
}


public Node getNext(){
    return next;
}


public void setNext(Node next){
    this.next = next;
}


public Object getData(){
    return  data;
}


public void setData(Node data){
        this.data = data;
    }




}
