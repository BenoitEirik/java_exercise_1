import java.util.Scanner;

public class Fibo implements Command {

    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public Boolean run(Scanner shell) {
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

        return Boolean.TRUE;
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
