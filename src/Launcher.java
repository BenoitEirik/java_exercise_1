import java.util.Scanner;

public class Launcher {
    public static void main (String[] args) {
        System.out.println("Bienvenue");
        Scanner shell = new Scanner(System.in);

        while (true) {
            String nextline = shell.nextLine();

            if ("quit".equals(nextline)) {
                break;
            }
            else if ("fibo".equals(nextline)) {
                System.out.println("Enter a integer:");
                int integer = shell.nextInt();
                shell.nextLine();

                int nbr0 = 0, nbr1 = 1, f = 0;
                if (integer == 0) {
                    System.out.println("Fibo(0) = 0");
                }
                else if (integer == 1) {
                    System.out.println("Fibo(1) = 1");
                }
                else {
                    System.out.println("Fib(" + integer + ") = " + fibonacci(integer));
                }
            }
            else {
                System.out.println("Unknown command");
            }
        }
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
