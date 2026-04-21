package org.example;

import com.sun.security.jgss.GSSUtil;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.text.CollationElementIterator;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void MyArrayList() {
        List<String> items = new ArrayList<String>();
        items.add("Яблука");
        items.add("Черешні");
        items.add("Вишні");

        System.out.print("Список фруктів\n- ");
        for (var item : items) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println("item 0: " + items.get(0));

        items.set(1, "Зефір");
        System.out.print("Список фрукті зміна елемента\n- ");
        for (var item : items) {
            System.out.print(item + " ");
        }
        System.out.println();

        items.remove(0);
        items.remove("Зефір");
        System.out.println("Усі козаки: " + items);

    }

    public static void SortArrayList() {
        List<Integer> numbers =
                new ArrayList<>(Arrays.asList(2,4,51,2,5,7,32,1,0,4,8));
//        Collections.sort(numbers);
        System.out.println("Не Сортований список: " + numbers);

        numbers.sort(null);
        System.out.println("Сортований список: " + numbers);

//        Collections.sort(numbers,Collections.reverseOrder());
        numbers.sort((a,b) -> b-a);
        System.out.println("Список у зворотньому порядку: " + numbers);
    }

    public static void ArrayRemoveItem() {
        List<String> colors = new ArrayList<>(
                Arrays.asList("Зелений", "Червоний", "Жовтий", "Синій", "Баклажанний")
        );
//        Error
//        for (var item : colors) {
//            if (item.equals("Жовтий"))
//                colors.remove(item);
//        }

        Iterator<String> iterator = colors.iterator();
        while (iterator.hasNext()) { // hasNext() - перевіряє чи є елемент у послідовності
            if(iterator.next().equals("Жовтий")) // Бере елемент із послідовності
                iterator.remove(); // Безпечне видалення елемента
        }

        System.out.println("Список кольорів: " + colors);

        colors = new ArrayList<>(
                Arrays.asList("Зелений", "Червоний", "Жовтий", "Синій", "Баклажанний", "Жовтий")
        );
        colors.removeAll(Arrays.asList("Жовтий"));
        System.out.println("Remove all | Список кольорів: " + colors);

        colors = new ArrayList<>(
                Arrays.asList("Зелений", "Червоний", "Жовтий", "Синій", "Баклажанний", "Жовтий", "Банановий")
        );
        colors = colors.stream()
                .filter(c -> !c.equals("Банановий"))
                .collect(Collectors.toList());
        System.out.println("Remove stream | Список кольорів: " + colors);
    }

    public static void SortClassList() {
        //TreeSet -  той же самий HashSet, але він завжди сортований
        // Усі елементи які попадають у дерево автоматично там зберігіються сортовані.
        List<Person> people = Arrays.asList(
                new Person("Семен", 21),
                new Person("Павло", 16),
                new Person("Їжак", 9)
        );

        Collections.sort(people);
        System.out.println("Сортованитй список " + people);

        //Будемо сортувати елементи по імені, передає вказівник на метод
        Collections.sort(people, Comparator.comparing(Person::getName));
        System.out.println("Сортування по імені " + people);

        Collections.sort(people, Comparator.comparing(Person::getAge).reversed());
        System.out.println("Сортування по вікові за спаданям " + people);
    }

    //Dictionary - у C#
    public static void MyHashMap() {
        Map<String, Integer> map = new HashMap<>();
        // Додаємо елементи
        map.put("Іван", 24);
        map.put("Петро", 19);
        map.put("Леся", 15);
        // Тут буде оновлятися Леся - стає 23
        map.put("Леся", 23); // Два рази Лесі бути не може. Повторне додавання заміняє елемент.
        map.put("Світлана", 32);
        System.out.println("HashMap: " + map);

        System.out.println("Леся її вік " + map.get("Леся"));

        for(var key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        System.out.println("Search key " + map.containsKey("Іван"));
        System.out.println("Search valuel " + map.containsValue(19));

    }

    public static void Classwork1() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Введіть числа (для завершення введіть будь-який нечисловий символ):");

        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }
        scanner.nextLine();

        System.out.println("Ваш список чисел:");
        System.out.println(numbers);

        while (true) {
            System.out.println("Виберіть один із варіантів:");
            System.out.println("1. Додати елемент в список");
            System.out.println("2. Видалите елемент з списоку");
            System.out.println("3. Показати вміст списоку");
            System.out.println("4. Перевірити чи є значення в списоку");
            System.out.println("5. Змінити значення в списоку");
            System.out.println("6. Вихід");
            System.out.println();
            scanner.nextLine();
            if (scanner.hasNextInt()) {
                int response = scanner.nextInt();
                switch (response) {
                    case 1:
                        System.out.println("Введіть число:");
                        if (scanner.hasNextInt()) {
                            int value = scanner.nextInt();
                            numbers.add(value);
                        }
                        break;
                    case 2:
                        System.out.println("Введіть елемент для видалення:");
                        if (scanner.hasNextInt()) {
                            int value = scanner.nextInt();
                            numbers.remove(Integer.valueOf(value));
                        }
                        break;
                    case 3:
                        System.out.println("Список чисел: " + numbers);
                        break;
                    case 4:
                        System.out.println("Введіть значення для перевірки: ");
                        if (scanner.hasNextInt()) {
                            if (numbers.contains(scanner.nextInt())) {
                                System.out.println("Значеня є в списку.");
                            } else {
                                System.out.println("Значеня немає в списку.");
                            }
                        }
                        break;
                    case 5:
                        int index = 0;
                        int value = 0;
                        System.out.println("Введіть індекс який хочете замінити: ");
                        if (scanner.hasNextInt()) {
                            index = scanner.nextInt();
                        }
                        System.out.println("Введіть нове значення:");
                        if (scanner.hasNextInt()) {
                            value = scanner.nextInt();
                        }
                        numbers.set(index, value);
                        break;
                    case 6:
                        System.out.println("Вихід...");
                        return;
                    default: break;
                }
            } else {
                System.out.println("Введіть число!");
                scanner.nextLine();
            }

        }

    }

    static void main() {
        System.out.println("-- Робота з колекціями Java");
//        MyArrayList();
//        SortArrayList();
//        ArrayRemoveItem();
//        MyHashMap();
//        SortClassList();
        Classwork1();
    }
}
