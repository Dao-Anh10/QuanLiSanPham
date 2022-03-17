/**
 * MyQueue
 */
public class MyQueue<T> {
    Node<T> head;
    Node<T> tail;   

    public MyQueue(){
        head= null;
        tail=null;
    }    
    // hàm enpueue để chèn thêm phần tử vào sau queue
    public void enqueue(Node<T> p){
        if (head == null) {
            head=tail=p;
        }
        else{
            tail.next = p;
            tail = p;
        }
    }

    // hàm in ra list   
    public void inQueue(MyQueue<T> queue){
        Node<T> p = head  ;
        while (p != null) {
            System.out.println(p.toString());
            p = p.next;
        }   
    }
    // xóa 1 queue 
    public void deletaQueue(){
        head = head.next;
    }
    
    
}