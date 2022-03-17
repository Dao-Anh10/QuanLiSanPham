/**
 * MyStack
 */
public class MyStack<T> {
    Node<T> head;
    
    public MyStack(Node<T> head){
        this.head = head;
    }
    public MyStack(){

    }
    // hàm thêm phần tử vào đầu stack 
    public void push(Node<T> p){
        p.next = head;
        head = p;
    }

    // hàm pop một phần tử ra khỏi stack
    public String pop(){
        T x = head.info;
        head = head.next;
        return x.toString();
    }
    // in stack ra màn hình 
    public void inStack(MyStack<T> stack){
        Node<T> p = head;
        while (p != null) {
            System.out.println(p.toString());
            p = p.next;
        }
    }
}