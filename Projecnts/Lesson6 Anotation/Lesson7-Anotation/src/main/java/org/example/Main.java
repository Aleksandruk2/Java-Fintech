package org.example;

import javax.security.auth.login.AccountNotFoundException;
import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {
    @ILogRuntimeInfo(value = "Класна погода сьогодні")
    public static void main(String [] args) {
        // runtime - це режим запуску програми.
//        По суті можна порівняти із Program.cs у C# ASP.NET
//        System.out.println("Привіт!");
        // reflect - рефлексія типів.
        // на C# є поняття рефлексії типів.
//        Parent vova = new Children();
//        vova.display();

//        AnnotationProcessor.processAnnotations(vova);

        // Будуємо анонімні класи
//        MyAnonnimClass test = new MyAnonnimClass() {
//            @Override
//            public void display(String info) {
//                System.out.printf("Привіт друже %s", info);
//            }
//        };
//        test.display("Іван");
//        // Runnable - анонімний клас
//        Thread thread = new Thread(new Runnable() { // Анонімний клас - можна замінити на Лямбда
//            @Override
//            public void run() {
//                System.out.println("Hello");
//            }
//        });
//        thread.start(); // виконуємо

        // Виклик callback
//        DataProcessor myData = new DataProcessor();
//        myData.processData("Hello", new DataProcessor.IOnProcessData() {
//            @Override
//            public void onSuccess(String result) {
//                System.out.println("Success: " + result);
//            }
//
//            @Override
//            public void onError(Exception e) {
//                System.out.println("Error: " + e.getMessage());
//            }
//        });

//        Runnable - даний інтерфейс нічого не повертає
//        Runnable r = () -> System.out.println("Hello");
//        r.run();

//        Square square = x -> x * x; // Піднести до степеня
//        System.out.println(square.calc(2));

        List<String> names = Arrays.asList("Іван", "Семен", "Петро");
        Collections.sort(names, (a,b) -> a.compareTo(b));
        System.out.println(names);

        // Набір функціональних інтерфейсів
        Consumer<String> print = s -> System.out.println(s);
        print.accept("Hello");

        // не приймає але повертає значення
        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());

        //Обчислює кількість символів в рядку
        //щось приймає і щось повертає
        //Трансформація даних
        Function<String, Integer> length = s -> s.length();
        System.out.println(length.apply("Hello"));

        Predicate<String> isLongerThan = s -> s.length() > 5;
        System.out.println(isLongerThan.test("Hello world"));

        BinaryOperator<Integer> max = (a,b) -> Math.max(a,b);
        System.out.println(max.apply(1,2));

        System.out.println(" - - - - - Stream API - - - - - ");

        // з колекції
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        // Можемо масив передати в Stream
        Stream<Integer> stream = numbers.stream();

        // Із значень відразу робимо Stream
        Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6);

        // Робимо послідовність і можемо зробити Stream
        Stream<Integer> stream3 = Stream.iterate(1,n -> n + 1)
                .limit(5);

        //Пуста послідовність
        Stream<Integer> emptyStream = Stream.empty();

        //На основі масиву
        Stream<Integer> streamArray = Arrays.stream(new Integer[] {1,2,3,4,5});

        List<Integer> eve = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println(eve);

        List<String> names2 = Arrays.asList("John", "Jane", "Bob");
        List<String> upperCaseNames = names2.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(upperCaseNames);

        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6));
        List<Integer> flattenedList = nestedList.stream()
                .flatMap(List::stream)
                .toList();
        System.out.println(flattenedList);

        // distinct() - Забирає повтори елементів
        // sorted() - сортує
        // peek() - після роботи якогось методу(filter, sorted)
        // - може викликати анонімну вашу функцію
        //
    }
}
