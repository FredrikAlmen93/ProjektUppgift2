public class Book extends Product {
    private String author;

    public Book(String articleNumber, String title, double price, String description, String author) {
        super(articleNumber, title, price, description);
        this.author = author;
    }

    @Override
    public String category() {
        return "Book";
    }

    public String getAuthor() {
        return author;
    }
}
