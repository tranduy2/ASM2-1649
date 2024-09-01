package ASM_2;


import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        OrderQueue orderQueue = new OrderQueue(); // Hàng đợi đơn hàng
        MyArrayList<Book> books = new MyArrayList<>(); // Danh sách sách
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Thêm sẵn sách vào danh sách
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("Moby Dick", "Herman Melville"));
        books.add(new Book("Pride and Prejudice", "Jane Austen"));


        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Add book");
            System.out.println("2. Display books");
            System.out.println("3. Search book (by title or author)");
            System.out.println("4. Sort books (by title or author)");
            System.out.println("5. Add order");
            System.out.println("6. Display orders");
            System.out.println("7. Search order (by ID, customer name, or shipping address)");
            System.out.println("8. Process order");
            System.out.println("9. Exit");
            System.out.print("Choose an option (1-9): ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    Book book = new Book(title, author);
                    // Start measuring time
                    long startTime = System.nanoTime();
                    books.add(book);
                    // End measuring time and print the elapsed time
                    long endTime = System.nanoTime();
                    long duration = (endTime - startTime) ;
                    System.out.println("Execution time for this case: " + duration + " ns");
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.println("Books in the library:");
                    // Start measuring time
                    startTime = System.nanoTime();
                    for (int i = 0; i < books.size(); i++) {
                        books.get(i).showBookInfor();
                        System.out.println();
                    }
                    // End measuring time and print the elapsed time
                    endTime = System.nanoTime();
                    duration = (endTime - startTime) ;
                    System.out.println("Execution time for this case: " + duration + " ns");
                    break;

                case 3:
                    System.out.print("Enter title or author to search: ");
                    String searchQuery = scanner.nextLine();
                    // Start measuring time
                    startTime = System.nanoTime();
                    boolean found = false;
                    for (int i = 0; i < books.size(); i++) {
                        Book b = books.get(i);
                        if (b.getTitle().equalsIgnoreCase(searchQuery) || b.getAuthor().equalsIgnoreCase(searchQuery)) {
                            b.showBookInfor();
                            System.out.println();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    // End measuring time and print the elapsed time
                    endTime = System.nanoTime();
                    duration = (endTime - startTime) ;
                    System.out.println("Execution time for this case: " + duration + " ns");
                    break;

                case 4:
                    System.out.println("Sort books by:");
                    System.out.println("1. Title");
                    System.out.println("2. Author");
                    int sortOption = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ascending order? (true/false): ");
                    boolean ascending = scanner.nextBoolean();
                    scanner.nextLine(); // Consume newline
                    // Start measuring time
                    startTime = System.nanoTime();
                    MyArrayList<Book> bookList = new MyArrayList<>();
                    for (int i = 0; i < books.size(); i++) {
                        bookList.add(books.get(i));
                    }
                    if (sortOption == 1) {
                        bookList.sort((b1, b2) -> {
                            if (ascending) {
                                return b1.getTitle().compareTo(b2.getTitle());
                            } else {
                                return b2.getTitle().compareTo(b1.getTitle());
                            }
                        });
                    } else if (sortOption == 2) {
                        bookList.sort((b1, b2) -> {
                            if (ascending) {
                                return b1.getAuthor().compareTo(b2.getAuthor());
                            } else {
                                return b2.getAuthor().compareTo(b1.getAuthor());
                            }
                        });
                    }
                    // Clear and re-add sorted books
                    books = new MyArrayList<>();
                    for (Book sortedBook : bookList) {
                        books.add(sortedBook);
                    }
                    // End measuring time and print the elapsed time in milliseconds
                    endTime = System.nanoTime();
                    duration = (endTime - startTime);
                    System.out.println("Books sorted successfully.");
                    System.out.println("Execution time for this case: " + duration + " ns");

                    break;

                case 5:
                    // Nhập thông tin đơn hàng
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter shipping address: ");
                    String shippingAddress = scanner.nextLine();

                    // Hiển thị sách có sẵn
                    System.out.println("Available books:");
                    for (int i = 0; i < books.size(); i++) {
                        System.out.println((i + 1) + ". " + books.get(i).getTitle() + " by " + books.get(i).getAuthor());
                    }

                    // Nhập ID sách muốn mua
                    MyArrayList<Book> selectedBooks = new MyArrayList<>();
                    boolean addingBooks = true;
                    while (addingBooks) {
                        System.out.print("Enter the number of the book to add to the order (0 to finish): ");
                        int bookIndex = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (bookIndex == 0) {
                            addingBooks = false;
                        } else if (bookIndex > 0 && bookIndex <= books.size()) {
                            selectedBooks.add(books.get(bookIndex - 1));
                            System.out.println("Book added to the order.");
                        } else {
                            System.out.println("Invalid book number. Please try again.");
                        }
                    }
                    // Start measuring time
                    startTime = System.nanoTime();
                    // Tạo đơn hàng mới
                    int orderID = OrderQueue.OrderIDGenerator.getNextOrderID();
                    Order order = new Order(customerName, shippingAddress, selectedBooks);
                    orderQueue.addOrder(order);
                    // End measuring time and print the elapsed time
                    endTime = System.nanoTime();
                    System.out.println("Order added successfully with ID: " + orderID);
                    duration = (endTime - startTime) ;
                    System.out.println("Execution time for this case: " + duration + " ns");
                    break;



                case 6:
                    // Start measuring time
                    startTime = System.nanoTime();
                    orderQueue.displayOrders();
                    // End measuring time and print the elapsed time in milliseconds
                    endTime = System.nanoTime();
                    duration = (endTime - startTime) ;// Convert nanoseconds to milliseconds
                    System.out.println("Execution time for this case: " + duration + " ns");
                    break;

                case 7:
                    System.out.print("Enter order ID, customer name, or shipping address to search: ");
                    String searchOrderQuery = scanner.nextLine();
                    // Start measuring time
                    startTime = System.nanoTime();
                    boolean orderFound = false;
                    for (Iterator<Order> it = orderQueue.iterator(); it.hasNext(); ) {
                        Order o = it.next(); // Use iterator to loop through orders
                        if (String.valueOf(o.getOrderID()).equals(searchOrderQuery)
                                || o.getCustomerName().equalsIgnoreCase(searchOrderQuery)
                                || o.getShippingAddress().equalsIgnoreCase(searchOrderQuery)) {
                            o.showOrderInfor();
                            System.out.println();
                            orderFound = true;
                        }
                    }
                    if (!orderFound) {
                        System.out.println("Order not found.");
                    }
                    // End measuring time and print the elapsed time in milliseconds
                    endTime = System.nanoTime();
                    duration = (endTime - startTime);
                    System.out.println("Execution time for this case: " + duration + " ns");
                    break;

                case 8:
                    // Start measuring time
                    startTime = System.nanoTime();
                    Order processedOrder = orderQueue.processOrder();
                    // End measuring time and print the elapsed time in milliseconds
                    endTime = System.nanoTime();
                    duration = (endTime - startTime);
                    if (processedOrder != null) {
                        System.out.println("Processed Order:");
                        processedOrder.showOrderInfor();
                    } else {
                        System.out.println("No orders to process.");
                    }
                    System.out.println("Execution time for this case: " + duration + " ns");
                    break;

                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    // Start measuring time
                    startTime = System.nanoTime();
                    System.out.println("Invalid option. Please choose a number between 1 and 9.");
                    // End measuring time and print the elapsed time in milliseconds
                    endTime = System.nanoTime();
                    duration = (endTime - startTime);
                    System.out.println("Execution time for this case: " + duration + " ns");
                    break;
            }

        }
    }
}
