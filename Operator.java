import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HexFormat;
import java.util.Scanner;

/**
 * Operator
 */
public class Operator {

    // tìm kiếm và trả về vị trí của 1 sản phẩm 
    public void index(Product p, MyList<Product> list){
        Node<Product> run = new Node<>();
        run = list.head;
        int count = 0;
        boolean ktra = false;
        while (run != null) {
            if (run.toString().equals(p.toString())) {
                ktra = true;
                break;
            }
            count++;
            run = run.next;
        }
        if (ktra == true) {
            System.out.println("vi tri san pham la: " + count);
        }else{
            System.out.println("Not found");
        }

    }

    // hàm nhận input của info từ bàn phím và trả về thông tin của 1 sản phẩm
    public Product createProduct(MyList<Product> list){

        Product po = new Product();
        Node<Product> p = new Node<Product>(po, null);
        Scanner sc = new Scanner(System.in);
        System.out.print("ID: ");
        po.bcode = sc.nextInt();
        System.out.print("Name: ");
        po.title = sc.next();
        System.out.print("Price: ");    
        po.price = sc.nextDouble();
        System.out.print("Quanlity: ");
        po.quanlity = sc.nextInt();

        addTail(p, list);
        return po;
    }
    // hàm đọc tất cả các sản phẩm từ file và chèn sản phẩm vào đuôi danh sách 
    public void getFileToList(String nameFile, MyList<Product> list){
        try {
            FileReader fr = new FileReader(nameFile);
            BufferedReader br = new BufferedReader(fr);
            
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] splyt = line.split(" ");
                int bcode = Integer.parseInt(splyt[0]);
                String title = splyt[1];
                double price = Double.parseDouble(splyt[2]);
                int quanlity = Integer.parseInt(splyt[3]);
                list.addTail(new Node<>(new Product(bcode, title, price, quanlity), null));
                
            }
           // list.inList(list);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     // add phan tu vao duoi
     public void addTail(Node<Product> newNode, MyList<Product> li){
        if (li.head == null) {
            li.head=li.tail=newNode;
        }else{
            li.tail.next = newNode;
            li.tail = newNode;

        }
    }
    // hàm in tất cả các phần tử của list ra màn hình console 
    public void displayAll(MyList<Product> li){
        Node<Product> p = li.head;
        System.out.println("----- Info product ------" );
        while (p != null) {
            System.out.println(p.toString());
            p = p.next;
        }
    }
     // viết tất cả các sản phẩn có trong list vào trong file 
    public void writeAllItemInFile(String nameFile, MyList<Product> list){
        
        try {
            FileWriter fw = new FileWriter(nameFile); 
            BufferedWriter br = new BufferedWriter(fw);
            Node<Product> p = list.head; 
            while (p != null) {
                br.write(p.toString());
                br.newLine();
                p = p.next;
            }
            br.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // hàm cho nhập ID sản phẩm rồi hiển thị thông tin sản phẩm 
    public void searchById(MyList<Product> list){
        System.err.print("Enter ID: ");
        Scanner sc = new Scanner(System.in);
        int code = sc.nextInt();

        Node<Product> p = list.head;
        while (p != null) {
            if (code == p.info.bcode) {
                System.out.println(p.toString());
            }
            p=p.next;
        }

    }
    // hàm xóa sản phẩm bằng ID nhập từ bàn phím 
    public void deleteById(MyList<Product> list){
        System.err.print("Enter ID: ");
        Scanner sc = new Scanner(System.in);
        int code = sc.nextInt();
        Node<Product> p = list.head;
        // trường hợp ID vị trí đầu 
        if (code == list.head.info.bcode) {
            list.head = list.head.next;
        }
        else if (code == list.tail.info.bcode) {
            list.deleteTail(list);
        }
        else {
            while (p.next != null) {
                if (p.next.info.bcode == code) {
                    p.next = p.next.next;
                }
                p = p.next;
            }

        }
    }
    // hàm sắp xếp các sản phẩm theo ID == > viết sau 
    public void sortId(MyList<Product> list){
        //
        Node<Product> p = list.head;
        while (p != null) {
            Node<Product> h = p.next;
            while (h != null) {
                if ((p.info.bcode > h.info.bcode)){
                    list.swap(p, h);
                }   
                h = h.next;
            }
            p = p.next;
        }

        //
    }

    // hàm chuyển đổi một số thành dạng nhị phân(0,1) 
    public int convertToBinary(int k){
        if (k == 0) {
            return 0;
        }else{
            
            return k % 2 + 10 * convertToBinary(k/2);

        }
    }
    // hàm đọc dữ liệu từ file và chèn vào nhăn xếp 
    public void getFileToStack(String name, MyStack<Product> stack){
        try {
            FileReader fr = new FileReader(name);
            BufferedReader br = new BufferedReader(fr);
            
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] splyt = line.split(" ");
                int bcode = Integer.parseInt(splyt[0]);
                String title = splyt[1];
                double price = Double.parseDouble(splyt[2]);
                int quanlity = Integer.parseInt(splyt[3]);
                stack.push(new Node<Product>(new Product(bcode, title, price, quanlity), null));
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // hàm đọc tất cả các dữ liệu torng file và chèn vào queue 
    public void getFileToQueue(String name, MyQueue<Product> queue){
        try {
            FileReader fr = new FileReader(name);
            BufferedReader br = new BufferedReader(fr);
            
            String line = " ";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] splyt = line.split("\\s");
                int bcode = Integer.parseInt(splyt[0]);
                String title = splyt[1];
                double price = Double.parseDouble(splyt[2]);
                int quanlity = Integer.parseInt(splyt[3]);
                queue.enqueue(new Node<Product>((new Product(bcode, title, price, quanlity)), null));
            }
          // stack.inStack(stack);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // kết thúc class thao tác với sản phẩm

}