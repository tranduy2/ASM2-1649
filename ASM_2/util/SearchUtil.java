package ASM_2.util;

import ASM_2.model.Order;
import ASM_2.model.Book;

public class SearchUtil {
    public static void searchBookByTitle(MyArrayList<Book> books, String title) {
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Book found: " + books.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with title containing: " + title);
        }
    }

    public static void searchBookByAuthor(MyArrayList<Book> books, String author) {
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getAuthor().toLowerCase().contains(author.toLowerCase())) {
                System.out.println("Book found: " + books.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by author: " + author);
        }
    }

    public static void searchOrderByID(MyArrayList<Order> orders, int orderID) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderID() == orderID) {
                System.out.println("Order found: " + orders.get(i));
                return;
            }
        }
        System.out.println("No order found with ID: " + orderID);
    }

    public static void searchOrderByCustomerName(MyArrayList<Order> orders, String customerName) {
        boolean found = false;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getCustomerName().toLowerCase().contains(customerName.toLowerCase())) {
                System.out.println("Order found: " + orders.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No orders found for customer: " + customerName);
        }
    }

    public static void searchOrderByShippingAddress(MyArrayList<Order> orders, String shippingAddress) {
        boolean found = false;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getShippingAddress().toLowerCase().contains(shippingAddress.toLowerCase())) {
                System.out.println("Order found: " + orders.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No orders found with the shipping address: " + shippingAddress);
        }
    }
}