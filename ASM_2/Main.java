package ASM_2;

import ASM_2.model.Book;
import ASM_2.model.Order;
import ASM_2.util.MyQueue;
import ASM_2.util.MyArrayList;
import ASM_2.util.SortUtil;
import ASM_2.util.SearchUtil;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Book> bookList = new MyArrayList<>();
        MyArrayList<Order> orderList = new MyArrayList<>();
        MyQueue<Order> orderQueue = new MyQueue<>();
        Scanner scanner = new Scanner(System.in);

        bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99));
        bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", 8.99));
        bookList.add(new Book("1984", "George Orwell", 12.50));
        bookList.add(new Book("Moby Dick", "Herman Melville", 15.75));
        bookList.add(new Book("Pride and Prejudice", "Jane Austen", 9.99));

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add book");
            System.out.println("2. Display books");
            System.out.println("3. Search book (by title or author)");
            System.out.println("4. Sort books (by title, author, or price)");
            System.out.println("5. Add order");
            System.out.println("6. Display orders");
            System.out.println("7. Search order (by ID, customer name, or shipping address)");
            System.out.println("8. Process order");
            System.out.println("9. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter book title:");
                    String title = scanner.nextLine();

                    System.out.println("Enter author:");
                    String author = scanner.nextLine();

                    System.out.println("Enter price:");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    bookList.add(new Book(title, author, price));
                    break;

                case 2:
                    System.out.println("Books in the store:");
                    for (int i = 0; i < bookList.size(); i++) {
                        System.out.println(bookList.get(i));
                    }
                    break;

                case 3:
                    System.out.println("Enter search term (title or author):");
                    String searchTerm = scanner.nextLine();
                    SearchUtil.searchBookByTitle(bookList, searchTerm);
                    SearchUtil.searchBookByAuthor(bookList, searchTerm);
                    break;

                case 4:
                    System.out.println("Sort books by:");
                    System.out.println("1. Title");
                    System.out.println("2. Author");
                    System.out.println("3. Price");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (sortChoice) {
                        case 1:
                            SortUtil.insertionSortByTitle(bookList);
                            break;
                        case 2:
                            SortUtil.insertionSortByAuthor(bookList);
                            break;
                        case 3:
                            SortUtil.insertionSortByPrice(bookList);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 5:
                    System.out.println("Enter customer name:");
                    String customerName = scanner.nextLine();
                    System.out.println("Enter shipping address:");
                    String shippingAddress = scanner.nextLine();
                    MyArrayList<Book> orderBooks = new MyArrayList<>();

                    System.out.println("Select books for the order by their index (comma-separated):");
                    for (int i = 0; i < bookList.size(); i++) {
                        System.out.println(i + ". " + bookList.get(i));
                    }

                    String[] selectedIndices = scanner.nextLine().split(",");
                    for (String indexStr : selectedIndices) {
                        int index = Integer.parseInt(indexStr.trim());
                        if (index >= 0 && index < bookList.size()) {
                            orderBooks.add(bookList.get(index));
                        }
                    }

                    Order newOrder = new Order(customerName, shippingAddress, orderBooks);
                    orderList.add(newOrder);
                    orderQueue.enqueue(newOrder);
                    break;

                case 6:
                    System.out.println("Orders:");
                    for (int i = 0; i < orderList.size(); i++) {
                        System.out.println(orderList.get(i));
                    }
                    break;

                case 7:
                    System.out.println("Enter order ID, customer name, or shipping address to search:");
                    String searchInput = scanner.nextLine();
                    try {
                        int searchID = Integer.parseInt(searchInput);
                        SearchUtil.searchOrderByID(orderList, searchID);
                    } catch (NumberFormatException e) {
                        SearchUtil.searchOrderByCustomerName(orderList, searchInput);
                        SearchUtil.searchOrderByShippingAddress(orderList, searchInput);
                    }
                    break;

                case 8:
                    if (!orderQueue.isEmpty()) {
                        Order processedOrder = orderQueue.dequeue();
                        System.out.println("Processing order: " + processedOrder);
                    } else {
                        System.out.println("No orders to process.");
                    }
                    break;

                case 9:
                    System.out.println("Exit");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}