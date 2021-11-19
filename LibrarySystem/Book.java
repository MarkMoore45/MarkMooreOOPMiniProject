package LibrarySystem;

public class Book {

    private int BookID;
    private String ISBN;
    private String title;
    private String author;
    private String genre;
    private double price;
    private int pages;
    private char status;
    private static int count = 0;

    public Book(){
        this("NA","NA","NA","NA",0.0,0,'U');
    }


    public Book(String ISBN, String title, String author, String genre, double price, int pages, char status) {
        setBookID();
        setISBN(ISBN);
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
        setPrice(price);
        setPages(pages);
        setStatus(status);
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID() {
        this.BookID = count++;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = 'A';
    }

    @Override
    public String toString() {
        return "Book Details\n" +
                "\nBookID: " + getBookID() +
                "\nISBN: " + getISBN() +
                "\nTitle: " + getTitle() +
                "\nAuthor: " + getAuthor() +
                "\nGenre: " + getGenre() +
                "\nPrice: " + getPrice() +
                "\nPages: " + getPages() +
                "\nStatus: " + getStatus();
    }
}


