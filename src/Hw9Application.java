import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hw9Application {
    public static void main(String[] args) {
        String[] strings = {"i", "was", "@", "aut", "90", "", ""};
        part1(strings);
    }

    private static void part1(String[] strings) {
        Stream<String> stream = Stream.of(strings);
        Map<Integer, List<String>> classesOfLength =
                stream.collect(
                        Collectors.groupingBy(
                                str -> str.length())
                );

        classesOfLength.forEach(
                (k, v) -> System.out.println("Strings with length " + k + ": " + v));

    }