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
}
