package Classes;

public class SandBox {


    public static void main(String[] args) {





            LinkedList linkedList = new LinkedList();
        System.out.println(linkedList.add("morangos"));
        System.out.println(linkedList.add("pessegos"));
        System.out.println(linkedList.add("ervilhas"));

        System.out.println(linkedList.contains("morangos"));
        System.out.println(linkedList.contains("pessegos"));
        System.out.println(linkedList.contains("ervilhas"));

        System.out.println(linkedList.getSize());
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.indexOf("morangos"));

        System.out.println(linkedList.remove("morangos"));
        System.out.println(linkedList.contains("morangos"));




     CustomQueue customQueue = new CustomQueue();

        System.out.println(customQueue.offer("bananas"));
        System.out.println(customQueue.offer("kiwis"));
        System.out.println(customQueue.offer("morangos"));
        System.out.println(customQueue.contains("ab"));
        System.out.println(customQueue.peek());
        System.out.println(customQueue.pool());
        System.out.println(customQueue.peek());

        System.out.println(customQueue.contains("morangos"));
        System.out.println(customQueue.contains("bananas"));



                   CustomSet customSet = new CustomSet();


        System.out.println(customSet.add("morangos"));
        System.out.println(customSet.add("morangos"));

        System.out.println(customSet.contains("morangos"));
        System.out.println(customSet.contains("abcsadasdad"));

































    }





}
