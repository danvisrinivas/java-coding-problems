package companies_coding_problems;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamCountWords {
    public static void main(String[] args) {
        String s = "I am doing an interview at MorganStanley I work for MorganStanley";
        print(s);
    }

    public static void print(String s){
        Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream().filter(e -> e.getValue() > 1)
                .forEach(e -> System.out.println(e.getKey() + ": "+ e.getValue()));
    }
}
