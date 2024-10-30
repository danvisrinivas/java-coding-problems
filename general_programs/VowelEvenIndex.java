package general_programs;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VowelEvenIndex {
    public static void main(String[] args) {
        String input = "Hello World, This is Java Streams!";
        String vowelsAtEvenIndexes = IntStream.range(0, input.length())
                .filter(i -> i % 2 == 0 && isVowel(input.charAt(i)))  // Filter even indices and vowels
                .mapToObj(input::charAt)  // Convert to char stream
                .map(String::valueOf)     // Convert chars to strings
                .collect(Collectors.joining()); // Collect as a string

        System.out.println(vowelsAtEvenIndexes);
    }

    // Method to check if the character is a vowel
    private static boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
}

