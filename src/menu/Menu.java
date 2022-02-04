package menu;

import java.util.Scanner;

public class Menu {
    protected static Scanner scanner = new Scanner(System.in);

    public static String requireNonNullInput(String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        if (input.length() == 0) {
            return requireNonNullInput(message);
        } else {
            return input;
        }
    }
}
