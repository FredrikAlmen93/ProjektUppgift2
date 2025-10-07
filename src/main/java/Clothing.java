public class Clothing extends Product {
    private String size;

    public Clothing(String articleNumber, String title, double price, String description, String size) {
        super(articleNumber, title, price, description);
        this.size = size;
    }

    @Override
    public String category() {
        return "Clothing";
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Category: " + category() +
                "\nArticle number: " + getArticleNumber() +
                "\nSize: " + size +
                "\nTitle: " + getTitle() +
                "\nPrice: " + getPrice() +
                "\nDescription: " + getDescription();
    }
}
