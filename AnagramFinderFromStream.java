package org.example;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;


public class AnagramFinderFromStream {
    public static void main(String[] args) {
        // Simulate a stream of words (could be from a file)
        Stream<String> wordStream = Stream.of(
                "listen", "silent", "inlets",
                "hello", "world",
                "dormitory", "dirtyroom"
        );

        // Process in parallel
        Map<String, List<String>> anagramGroups = wordStream
                .parallel()
                .collect(Collectors.groupingBy(
                        AnagramFinderFromStream::getAnagramKey,
                        Collectors.toList()
                ));

        // Print results
        System.out.println("Anagram Groups:");
        anagramGroups.values().stream()
                .filter(group -> group.size() > 1)
                .forEach(System.out::println);
    }

    private static String getAnagramKey(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}