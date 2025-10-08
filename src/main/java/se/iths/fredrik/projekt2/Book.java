package se.iths.fredrik.projekt2;

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

    @Override
    public String toString() {
        return "Category: " + category() +
                "\nArticle number: " + getArticleNumber() +
                "\nAuthor: " + author +
                "\nTitle: " + getTitle() +
                "\nPrice: " + getPrice() +
                "\nDescription: " + getDescription();
    }
}
