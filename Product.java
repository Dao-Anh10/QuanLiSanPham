/**
 * Product
 */
public class Product {
    int bcode;
    String title;
    double price;
    int quanlity;

    // tạo hàm khỏi tạo đối tượng 
    public Product(){};

    public Product(int bcode, String title, double price, int quanlity){
        this.bcode = bcode;
        this.title = title;
        this.quanlity = quanlity;
        this.price = price;
    }

    public String toString(){
        return bcode + " " + title + " " + price + " " + quanlity;
    }

    



}