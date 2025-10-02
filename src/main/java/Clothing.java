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
}
