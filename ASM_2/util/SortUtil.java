package ASM_2.util;

import ASM_2.model.Book;
import ASM_2.util.MyArrayList;

public class SortUtil {

    // Sort books by title using insertion sort
    public static void insertionSortByTitle(MyArrayList<Book> books) {
        for (int i = 1; i < books.size(); i++) {
            Book key = books.get(i);
            int j = i - 1;
            while (j >= 0 && books.get(j).getTitle().compareTo(key.getTitle()) > 0) {
                books.set(j + 1, books.get(j));
                j--;
            }
            books.set(j + 1, key);
        }
    }

    // Sort books by author using insertion sort
    public static void insertionSortByAuthor(MyArrayList<Book> books) {
        for (int i = 1; i < books.size(); i++) {
            Book key = books.get(i);
            int j = i - 1;
            // Move elements of books[0..i-1] that are greater than key to one position ahead of their current position
            while (j >= 0 && books.get(j).getAuthor().compareTo(key.getAuthor()) > 0) {
                books.set(j + 1, books.get(j));
                j--;
            }
            books.set(j + 1, key);
        }
    }

    // Sort books by price using insertion sort
    public static void insertionSortByPrice(MyArrayList<Book> books) {
        for (int i = 1; i < books.size(); i++) {
            Book key = books.get(i);
            int j = i - 1;
            // Move elements of books[0..i-1] that are greater than key to one position ahead of their current position
            while (j >= 0 && books.get(j).getPrice() > key.getPrice()) {
                books.set(j + 1, books.get(j));
                j--;
            }
            books.set(j + 1, key);
        }
    }
}