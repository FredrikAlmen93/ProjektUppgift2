package se.iths.fredrik.projekt2;

import java.util.List;

public class Application {
    private final ProductInventory inventory = new ProductInventory();
    private List<Product> productList = inventory.load();
    private UI ui;

    public Application(UI ui) {
        this.ui = ui;
    }

    public void run() {
        boolean active = true;
        while (active) {
            try {
                String choice = ui.menu();
                switch (choice) {
                    case "1":
                        addProduct();
                        break;
                    case "2":
                        listProducts();
                        break;
                    case "3":
                        showProduct();
                        break;
                    case "4":
                        active = false;
                        break;
                    default:
                        ui.info("Incorrect input.");
                }
            } catch (Exception e) {
                ui.info("Unexpected error: " + e.getMessage());
            }
        }
    }

    private void addProduct() {
        String type = ui.prompt("What type of product would you like to add? Book/Electronic/Clothing");
        if (!type.equalsIgnoreCase("book") && !type.equalsIgnoreCase("electronic") && !type.equalsIgnoreCase("clothing")) {
            ui.info("Incorrect input");
            addProduct();
        } else {
            String articleNumber = ui.prompt("Enter article number");
            String title = ui.prompt("Enter name of product");
            double price = 0;
            try {
                price = Double.parseDouble(ui.prompt("Enter price of product"));
            } catch (NumberFormatException e) {
                ui.info("Error: " + e.getMessage());
            }
            String description = ui.prompt("Enter product description");

            switch (type.toLowerCase()) {
                case "book":
                    String author = ui.prompt("Enter name of author");
                    productList.add(new Book(articleNumber, title, price, description, author));
                    inventory.save(productList, "products.txt");
                    break;
                case "electronic":
                    String model = ui.prompt("Enter product model");
                    productList.add(new Electronic(articleNumber, title, price, description, model));
                    inventory.save(productList, "products.txt");
                    break;
                case "clothing":
                    String size = ui.prompt("Enter clothing size");
                    productList.add(new Clothing(articleNumber, title, price, description, size));
                    inventory.save(productList, "products.txt");
                    break;
                default:
                    ui.info("Incorrect input.");
            }
            ui.info("Product added!");
            ui.info("******************");
        }
    }

    private void listProducts() {
        if (productList.isEmpty()) {
            ui.info("There are currently no products.");
            ui.info("******************");
        } else {
            for (Product i : productList) {
                ui.info(i.toString());
                ui.info("******************");
            }
        }
    }

    private void showProduct() {
        String articleNumber = ui.prompt("Enter article number of product");
        for (Product i : productList) {
            if (i.getArticleNumber().equals(articleNumber)) {
                ui.info(i.toString());
                return;
            }
        }
        ui.info("There is no product with that article number");
        ui.info("******************");
    }
}
