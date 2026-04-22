package org.example;

import java.util.*;

public class WordEntry {
    private List<String> translations = new ArrayList<>();
    private int usageCount = 0;

    public WordEntry(List<String> translations) {
        this.translations.addAll(translations);
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void addTranslation(String translation) {
        translations.add(translation);
    }

    public void removeTranslation(String translation) {
        translations.remove(translation);
    }

    public void replaceTranslation(int index, String newTranslation) {
        if (index >= 0 && index < translations.size()) {
            translations.set(index, newTranslation);
        }
    }

    public void incrementUsage() {
        usageCount++;
    }

    public int getUsageCount() {
        return usageCount;
    }

    @Override
    public String toString() {
        return translations.toString() + " | переглядів: " + usageCount;
    }
}
