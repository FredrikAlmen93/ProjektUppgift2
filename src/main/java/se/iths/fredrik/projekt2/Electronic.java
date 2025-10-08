package se.iths.fredrik.projekt2;

public class Electronic extends Product {
    private String model;

    public Electronic(String articleNumber, String title, double price, String description, String model) {
        super(articleNumber, title, price, description);
        this.model = model;
    }

    @Override
    public String category() {
        return "Electronic";
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Category: " + category() +
                "\nArticle number: " + getArticleNumber() +
                "\nModel: " + model +
                "\nTitle: " + getTitle() +
                "\nPrice: " + getPrice() +
                "\nDescription: " + getDescription();
    }
}
