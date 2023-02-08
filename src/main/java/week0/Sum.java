package week0;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Read input from System.in
        String some_input = scanner.nextLine(); // Reads the next integer
        String[] split = some_input.split(" ");
        System.out.println(Integer.parseInt(split[0]) + Integer.parseInt(split[1]));
    }
}
