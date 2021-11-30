import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Freq implements Command {

    @Override
    public String name() {
        return "freq";
    }

    @Override
    public Boolean run(Scanner shell) {
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

        return Boolean.TRUE;
    }
}
