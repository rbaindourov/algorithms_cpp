package org.example;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class AnagramFinderWithCompletableFuture {
    public static void main(String[] args) {
        // Sample word list
        List<String> words = Arrays.asList(
                "listen", "silent", "inlets",
                "hello", "world",
                "dormitory", "dirtyroom"
        );

        // Custom thread pool (e.g., 4 threads)
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Split list into chunks for parallel processing
        int chunkSize = (int) Math.ceil(words.size() / 4.0); // 4 chunks
        List<List<String>> chunks = new ArrayList<>();
        for (int i = 0; i < words.size(); i += chunkSize) {
            chunks.add(words.subList(i, Math.min(i + chunkSize, words.size())));
        }

        // Process each chunk asynchronously
        List<CompletableFuture<Map<String, List<String>>>> futures = chunks.stream()
                .map(chunk -> CompletableFuture.supplyAsync(() -> processChunk(chunk), executor))
                .collect(Collectors.toList());

        // Combine results when all futures complete
        CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    Map<String, List<String>> anagramGroups = new HashMap<>();
                    futures.forEach(future -> {
                        Map<String, List<String>> chunkResult = future.join(); // Get result
                        chunkResult.forEach((key, group) ->
                                anagramGroups.merge(key, group, (oldList, newList) -> {
                                    oldList.addAll(newList);
                                    return oldList;
                                }));
                    });

                    // Print anagram groups
                    System.out.println("Anagram Groups:");
                    anagramGroups.values().stream()
                            .filter(group -> group.size() > 1)
                            .forEach(System.out::println);
                });

        // Wait for completion (for this example; could be non-blocking in a larger app)
        allDone.join();

        // Shut down the executor
        executor.shutdown();
    }

    // Process a chunk of words into an anagram map
    private static Map<String, List<String>> processChunk(List<String> chunk) {
        return chunk.stream()
                .collect(Collectors.groupingBy(
                        AnagramFinderWithCompletableFuture::getAnagramKey,
                        Collectors.toList()
                ));
    }

    // Generate sorted character key for anagram checking
    private static String getAnagramKey(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}