package se.iths.fredrik.projekt2;

import java.util.Scanner;

public class scannerUI implements UI {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String menu() {
        System.out.println("\nMenu");
        System.out.println("1. Add a product");
        System.out.println("2. List all products");
        System.out.println("3. Show information for a product");
        System.out.println("4. Exit");
        return prompt("Choose an option by entering the corresponding number");
    }

    @Override
    public void info(String message) {
        System.out.println(message);
    }

    @Override
    public String prompt(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine();
    }
}
