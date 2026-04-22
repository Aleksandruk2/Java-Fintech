package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final Map<String, WordEntry> dictionary = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        seedData(); // початкові дані

        while (true) {
            System.out.println("\n1. Показати переклади слова");
            System.out.println("2. Додати слово");
            System.out.println("3. Видалити слово");
            System.out.println("4. Додати переклад");
            System.out.println("5. Видалити переклад");
            System.out.println("6. Замінити переклад");
            System.out.println("7. Топ-10 популярних");
            System.out.println("8. Топ-10 непопулярних");
            System.out.println("9. Вивести усі переклади");
            System.out.println("10. Вихід");
            System.out.print("-> ");

            if (!scanner.hasNextInt()) {
                System.out.println("Введіть число!");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка

            switch (choice) {
                case 1 -> showWord();
                case 2 -> addWord();
                case 3 -> removeWord();
                case 4 -> addTranslation();
                case 5 -> removeTranslation();
                case 6 -> replaceTranslation();
                case 7 -> showTop(true);
                case 8 -> showTop(false);
                case 9 -> showAll();
                case 10 -> {
                    System.out.println("Вихід...");
                    return;
                }
                default -> System.out.println("Невірний вибір");
            }
        }
    }

    private static void seedData() {
        dictionary.put("hello", new WordEntry(List.of("hola", "bonjour")));
        dictionary.put("world", new WordEntry(List.of("mundo", "monde")));
        dictionary.put("cat", new WordEntry(List.of("gato", "chat")));
    }

    private static void showWord() {
        System.out.print("Введіть слово: ");
        String word = scanner.nextLine();

        WordEntry entry = dictionary.get(word);

        if (entry != null) {
            entry.incrementUsage();
            System.out.println("Переклади: " + entry);
        } else {
            System.out.println("Слово не знайдено");
        }
    }

    private static void addWord() {
        System.out.print("Нове слово: ");
        String word = scanner.nextLine();

        if (dictionary.containsKey(word)) {
            System.out.println("Слово вже існує");
            return;
        }

        System.out.print("Введіть переклади через кому: ");
        String[] translations = scanner.nextLine().split(",");

        List<String> list = Arrays.stream(translations)
                .map(String::trim)
                .collect(Collectors.toList());

        dictionary.put(word, new WordEntry(list));
        System.out.println("Слово додано");
    }

    private static void removeWord() {
        System.out.print("Введіть слово: ");
        String word = scanner.nextLine();

        if (dictionary.remove(word) != null) {
            System.out.println("Слово видалено");
        } else {
            System.out.println("Слово не знайдено");
        }
    }

    private static void addTranslation() {
        System.out.print("Слово: ");
        String word = scanner.nextLine();

        WordEntry entry = dictionary.get(word);

        if (entry == null) {
            System.out.println("Слова немає");
            return;
        }

        System.out.print("Новий переклад: ");
        String translation = scanner.nextLine();

        entry.addTranslation(translation);
        System.out.println("Додано");
    }

    private static void removeTranslation() {
        System.out.print("Слово: ");
        String word = scanner.nextLine();

        WordEntry entry = dictionary.get(word);

        if (entry == null) {
            System.out.println("Слова немає");
            return;
        }

        System.out.print("Переклад для видалення: ");
        String translation = scanner.nextLine();

        entry.removeTranslation(translation);
        System.out.println("Видалено (якщо існував)");
    }

    private static void replaceTranslation() {
        System.out.print("Слово: ");
        String word = scanner.nextLine();

        WordEntry entry = dictionary.get(word);

        if (entry == null) {
            System.out.println("Слова немає");
            return;
        }

        System.out.println("Поточні переклади: " + entry.getTranslations());

        System.out.print("Індекс перекладу: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Новий переклад: ");
        String newTranslation = scanner.nextLine();

        entry.replaceTranslation(index, newTranslation);
        System.out.println("Замінено");
    }

    private static void showTop(boolean mostPopular) {
        List<Map.Entry<String, WordEntry>> sorted = dictionary.entrySet()
                .stream()
                .sorted((a, b) -> mostPopular
                        ? Integer.compare(b.getValue().getUsageCount(), a.getValue().getUsageCount())
                        : Integer.compare(a.getValue().getUsageCount(), b.getValue().getUsageCount()))
                .limit(10)
                .toList();

        System.out.println(mostPopular ? "ТОП популярних:" : "ТОП непопулярних:");

        for (var entry : sorted) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    private static void showAll() {
        dictionary.forEach((word, entry) ->
                System.out.println(word + " -> " + entry)
        );
    }
}