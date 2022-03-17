
import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {
        //
        MyList<Product> list = new MyList<>();
        MyQueue<Product> qe = new MyQueue<>();
        MyStack<Product> st = new MyStack<>();
        Operator po = new Operator();
        //
        Scanner sc = new Scanner(System.in);
        int chose = 0;
        showMenu();
        do{
        System.out.print("Choose one of this options: ");
        chose = sc.nextInt();
        
            switch (chose) {
                case 1:
                    System.out.println("Load data from file and display");
                    po.getFileToList("console_output.txt", list);
                    list.inList(list);
                        break;
                case 2:
                    System.out.println("Input & add to the end.");
                    po.createProduct(list);
                        break;
                case 3:
                    System.out.println("Display data");
                    po.displayAll(list);
                        break;
                case 4:
                    System.out.println("Save product list to file.");
                    po.writeAllItemInFile("console_output.txt", list);
                        break;                          
                case 5:
                    System.out.println("Search by ID");
                    po.searchById(list);
                        break;
                case 6:
                    System.out.println("Delete by ID");
                    po.deleteById(list);
                    po.displayAll(list);
                        break;
                case 7:
                    System.out.println("Sort by ID.");
                    po.sortId(list);
                    po.displayAll(list);
                        break;
                case 8:
                    System.out.println("Convert to Binary");
                    System.out.println("=> " + po.convertToBinary(list.head.info.quanlity));
                        break; 
                case 9:
                    System.out.println("Load to stack and display");
                    po.getFileToStack("console_output.txt", st);
                    st.inStack(st);
                        break;
                case 10:
                    System.out.println("Load to queue and display.");
                    po.getFileToQueue("console_output.txt", qe);
                    qe.inQueue(qe);
                        break;    
                case 0:
                    System.out.println("Exit: Bye Bye");
                        break;
                default:
                        break;
            }
            if (chose == 0) {
                break;
            }
        } while (true);
    }   

    // hàm show menu
    public static void showMenu() {

        System.out.println("Choose one of this options:");
     
        System.out.println("Product list:");
     
        System.out.println("1. Load data from file and display");
     
        System.out.println("2. Input & add to the end.");
     
        System.out.println("3. Display data");
     
        System.out.println("4. Save product list to file.");
     
        System.out.println("5. Search by ID");
     
        System.out.println("6. Delete by ID");
     
        System.out.println("7. Sort by ID.");
     
        System.out.println("8. Convert to Binary");
     
        System.out.println("9. Load to stack and display");
     
        System.out.println("10. Load to queue and display.");
     
        System.out.println("0. Exit");
     
      }
}
