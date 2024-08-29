package ASM_2;

public class Book {
    private String title;
    private String author;
    private int quantity;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }
    public void showBookInfor(){
        System.out.print(title + ". Author: "+ author);
    }
}
