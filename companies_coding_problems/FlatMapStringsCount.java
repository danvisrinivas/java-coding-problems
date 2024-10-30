package companies_coding_problems;

import java.util.Arrays;

public class FlatMapStringsCount {
    public static void main(String[] args) {
        String str[] = {"java ruby struts","spring java","spring python"};
        // find the count of particular string in above string array using flatmap
        System.out.println(Arrays.stream(str)
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .filter(s -> s.equals("spring"))
                .count());
    }
}
