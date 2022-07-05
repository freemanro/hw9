import org.javatuples.Pair;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hw9Application {
    public static void main(String[] args) {
        String[] strings = {"i", "was", "@", "aut", "90", "", ""};
        part1(strings);
        part2(strings);
        System.out.println(averageByLambda(2, 5));
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

    private static void part2(String[] strings) {
        Map<Integer, Pair<Integer, List<String>>> classesOfLength =
                Stream.of(strings).collect(
                        Collectors.groupingBy(
                                str -> str.length(),
                                Collectors.collectingAndThen(Collectors.toList(), list -> {
                                    long count = list.size();
                                    return new Pair(list, count);
                                })
                        )
                );

        classesOfLength.forEach(
                (k, v) ->
                        System.out.println(
                                "class of length " + k +
                                        ": (count = " + v.getValue1() + ") " +
                                        v.getValue0()
                        )
        );
    }

    private static double averageByLambda(double a, double b) {
        BiFunction<Double, Double, Double> average = (a1, a2) -> (a1 + a2) / 2;

        return average.apply(a, b);
    }
}