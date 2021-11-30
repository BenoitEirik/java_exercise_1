import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
            else if ("freq".equals(nextline)) {
                System.out.println("Enter a file path:");
                Path path = null;
                try {
                    path = Paths.get(shell.nextLine());
                    String file = java.nio.file.Files.readString(path);

                    String[] words = file.split(" ");
                    Map<String, Long> nbOccur = Arrays.stream(words)
                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                    Map<String, Long> finalMap = new LinkedHashMap<>();
                    nbOccur.entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue()
                                    .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
                    var arrayOccur = finalMap.entrySet().stream().limit(3).toArray();

                    System.out.println("Last three occurences = " + arrayOccur[0].toString().split("=")[0] + ", "
                    + arrayOccur[1].toString().split("=")[0] + ", "
                    + arrayOccur[2].toString().split("=")[0]);
                }
                catch (Exception exception) {
                    System.out.println("unreadable file : ");
                    exception.getClass().getSimpleName();
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
