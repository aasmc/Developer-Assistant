package ru.aasmc.common.utils;

import lombok.RequiredArgsConstructor;
import ru.aasmc.common.GarbageProperties;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class WordsComposer {
    private final GarbageProperties garbageProperties;

    public List<String> extractWordsWithoutGarbage(String text) {
        List<String> words = splitTextToWords(text);
        return refineText(words);
    }

    private List<String> refineText(List<String> words) {
        return words.stream()
                .filter(notGarbage())
                .collect(Collectors.toList());
    }

    private Predicate<String> notGarbage() {
        return s -> !garbageProperties.getGarbage().contains(s.toLowerCase());
    }

    private List<String> splitTextToWords(String text) {
        text = text.replace("?", "");
        List<String> words = new ArrayList<>();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                words.add(text.substring(firstIndex, lastIndex));
            }
        }
        return words;
    }
}






















