package Multiplicidad;


public class Book {
    private String title;

    public Book() {}

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return "Book name: " + title;
    }
}