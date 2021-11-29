import java.util.Scanner;

public class Launcher {
    public static void main (String[] args) {
        System.out.println("Bienvenue");
        Scanner instance = new Scanner(System.in);

        while (true) {
            String nextline = instance.nextLine();

            if ("quit".equals(nextline)) {
                break;
            }
            else {
                System.out.println("Unknown command");
            }
        }
    }
}
