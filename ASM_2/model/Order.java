package ASM_2.model;

import ASM_2.util.MyArrayList;

public class Order {
    private static int idCounter = 0;
    private int orderID;
    private String customerName;
    private String shippingAddress;
    private MyArrayList<Book> bookList;

    public Order(String customerName, String shippingAddress, MyArrayList<Book> bookList) {
        this.orderID = ++idCounter;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.bookList = bookList;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderID + ", Customer: " + customerName + ", Shipping Address: " + shippingAddress + ", Books: " + bookList;
    }
}

