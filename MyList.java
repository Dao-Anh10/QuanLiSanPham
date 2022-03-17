public class MyList<T> {
    Node<T> head ;
    Node<T> tail;

    public MyList(){

    }

    public MyList(Node<T> head, Node<T> tail){
        this.head = head;
        this.tail =tail;

    }

    // hàm xét mảng trống 
    public boolean empty(){
        return (head == null);
    }
    // hàm trã ra chiều dài của list 
    public int length(){
        int count = 0 ;
        Node<T> p = new Node<T>();
        p = head;
        if (p == null) {
            return 0;
        }else{
            while (p != null) {
                count++;
                p = p.next;
            }
        }
        return count;
    }

    // hàm chèn 1 phần tử vào đầu list  
    public  void insertToHead(Node<T> p){
        if (head == null) {
            head=tail=p;
        }else{
            p.next = head;
            head = p;  
        } 
    }
    // hàm trả về vị trí của phần tử mới 
    public void insertAfterPossition(int position, Node<T> Q){
        int count = 0;
        Node<T> p =head;    

        // trường hợp 1:  pos == 0;
        if (position == 0) {
            insertToHead(Q);
        }
        // trường hợp 2: tại vị trí cuối cùng
        else if (position == length()) {
            tail.next = Q;
            tail = Q;
        }
        else if(position > length()){
            System.out.println("position not found");
        }
        else
        {
            // trường hợp 3: pos ở vị trí bất kỳ 
            while (p.next != null && count!= (position-1)) {
                count++;
                p = p.next;
            }
            Q.next = p.next;
            p.next = Q;
        }

    }
    // hàm xóa phần tử cuối List 
    public void deleteTail(MyList<T> list){
        Node<T> p = head;
        while (p.next != tail) {
            p = p.next;
        }
        p.next = null;
        tail = p;
    }
    // hàm tìm và xóa các phần tử theo ID
    //public void deleteToId(int ID){}====> viết bên class Opertor
    
    //ham doi vi trí 2 phần tử 
    public void swap(Node<T> head, Node<T> secord){
        Node<T> save = new Node<>(); 
        save.info = head.info;
        head.info = secord.info;
        secord.info = save.info;
    }
    // hàm xóa tất cả các phần tử trong List
    public void clear(){
        head=null;
        tail=null;

    }
    // hàm in ra list 
    public void inList(MyList<T> list){
        Node<T> p = head;
        while (p != null) {
            System.out.println(p.info.toString());
            p = p.next;
        }
    }

        // add phan tu vao duoi
        public void addTail(Node<T> newNode){
            if (head == null) {
                head=tail=newNode;
            }else{
                tail.next = newNode;
                tail = newNode;

            }
        }
}
