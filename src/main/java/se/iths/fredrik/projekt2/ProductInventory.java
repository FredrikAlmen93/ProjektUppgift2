package se.iths.fredrik.projekt2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ProductInventory {
    private final Path FILE_PATH = Path.of("products.txt");

    public void save(List<Product> productList, String filename) {
        Path filePath = Path.of(filename);
        List<String> lines = new ArrayList<>();

        for (Product i : productList) {
            if (i instanceof Book b) {
                lines.add(String.join(";", "Book",
                        b.getArticleNumber(),
                        b.getTitle(),
                        String.valueOf(b.getPrice()),
                        b.getDescription(),
                        b.getAuthor()));
            } else if (i instanceof Electronic e) {
                lines.add(String.join(";", "Electronic",
                        e.getArticleNumber(),
                        e.getTitle(),
                        String.valueOf(e.getPrice()),
                        e.getDescription(),
                        e.getModel()));
            } else if (i instanceof Clothing c) {
                lines.add(String.join(";", "Clothing",
                        c.getArticleNumber(),
                        c.getTitle(),
                        String.valueOf(c.getPrice()),
                        c.getDescription(),
                        c.getSize()));
            }
        }
        try {
            if (FILE_PATH.getParent() != null) {
                Files.createDirectories(FILE_PATH.getParent());
            }
            Files.write(FILE_PATH, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Product> load() {
        List<Product> productList = new ArrayList<>();
        if (!Files.exists(FILE_PATH)) {
            System.out.println("No product list found. Creating new product list.");
            return productList;
        }
        try {
            List<String> lines = Files.readAllLines(FILE_PATH);
            for (String line : lines) {
                String[] parts = line.split(";");
                if (parts.length < 6) continue;
                String type = parts[0];
                String articleNumber = parts[1];
                String title = parts[2];
                double price;
                try {
                    price = Double.parseDouble(parts[3]);
                } catch (NumberFormatException e) {
                    System.out.println("Error: " + e.getMessage());
                    continue;
                }
                String description = parts[4];
                String unique = parts[5];

                switch (type.toLowerCase()) {
                    case "book" -> productList.add(new Book(articleNumber, title, price, description, unique));
                    case "electronic" ->
                            productList.add(new Electronic(articleNumber, title, price, description, unique));
                    case "clothing" -> productList.add(new Clothing(articleNumber, title, price, description, unique));
                    default -> System.out.println("Product type invalid" + type);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return productList;
    }
}
