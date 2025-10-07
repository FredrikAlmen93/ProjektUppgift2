import java.util.Scanner;

public class UserUI implements UI {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String menu() {
        System.out.println("Menu:");
        System.out.println("1. Add product.");
        System.out.println("2. List all products.");
        System.out.println("3. Show product description.");
        System.out.println("4. Exit.");
        return prompt("Choose an alternative");
    }

    @Override
    public void info(String message) {
        System.out.println(message);
    }

    @Override
    public String prompt(String message) {
        System.out.println(message + ": ");
        return scanner.nextLine();
    }
}
