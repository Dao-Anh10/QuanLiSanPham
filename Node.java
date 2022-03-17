
public class Node<T>{
    T info;
    Node<T> next;

    public Node(){

    }

    public Node(T info, Node<T> next){
        this.info = info;
        this.next = next;    
    }

    public String toString(){
        return info.toString();
    }
}
