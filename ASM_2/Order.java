package ASM_2;

public class Order {
    private String customerName;
    private String shippingAddress;
    private MyArrayList<Book> books;
    private int orderID;
    private static int nextOrderID = 1; // Biến static để theo dõi ID tiếp theo


    public Order(String customerName, String shippingAddress, MyArrayList<Book> books) {
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        // Create a new MyArrayList to avoid referencing the same list
        this.books = new MyArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            this.books.add(books.get(i));
        }
        this.orderID = nextOrderID++;
    }



    public int getOrderID() {
        return orderID;
    }

    public MyArrayList<Book> getBooks() {
        return books;
    }


    public void showOrderInfor() {
        System.out.println("Order ID: " + orderID + ", Customer: " + customerName + ", Address: " + shippingAddress);
        System.out.println("Books in this order:");
        for (int i = 0; i < books.size(); i++) {
            books.get(i).showBookInfor();
            System.out.println();
        }
    }


    public String getCustomerName() {
        return customerName;
    }


    public String getShippingAddress() {
        return shippingAddress;
    }

}
