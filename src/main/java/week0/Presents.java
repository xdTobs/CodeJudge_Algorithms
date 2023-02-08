package week0;

import java.util.Scanner;

public class Presents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Read input from System.in
        int a = scanner.nextInt(), l = scanner.nextInt(), o = scanner.nextInt();
        String res = "";
        if (a < l && a < o) res += "Anna\n";
        if (l < a) res += "Laura\n";
        if (o < l || o < a) res += "Oscar";
        if (res.length() == 0) res += "None";
        System.out.println(res);
    }
}
