package Task3;

import java.io.BufferedReader;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String fileName = "words.txt";
        Map<String, Integer> wordCountMap = countWordFrequency(fileName);
        printWordFrequency(wordCountMap);
    }

    public static Map<String, Integer> countWordFrequency(String fileName) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {

                for (String word : line.split("\\s+")) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return wordCountMap;
    }

    public static void printWordFrequency(Map<String, Integer> wordCountMap) {
        wordCountMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> System.out.println((entry.getKey() + ": " + entry.getValue())));
    }
}
