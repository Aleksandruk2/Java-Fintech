package org.example;

import org.example.myClasses.Box;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void template() {
        Box<Integer> myBox = new Box<>();
//        org.example.myClasses.Box<Integer> myBox =
//                new org.example.myClasses.Box<>();
        myBox.setContent(23);
        System.out.println(myBox.getContent());

        //Шаблонний тип може працювати лише з об'єктами
        Integer [] list = {23,42,12,42,52,1,25,111};
        // Саме його викличе.
        Box.printArray(list);
    }

    public static void inputTry () throws Exception {
        Scanner scanner = new Scanner(System.in);
        double a = 23, b;
        System.out.println("Вкажіть значення b:");
        try {
            b = scanner.nextInt();

        } catch (InputMismatchException imex) {
            System.out.println("Вкажіть ціле чило. Помилка вводу даних.");
            throw new Exception("Програма працює погано.");
        } catch (Exception ex) {
            System.out.printf("Щось пішло не так: %s", ex.getMessage());
            return;
        }
        System.out.printf("a/b = %f", a/b);
    }
    // При роботі функії main може вилітати помилка Exception
    public static void main(String[] args) {
//        template();
//        try {
//            inputTry();
//        } catch (Exception ex) {
//            System.out.printf("Виникла помилка. %s", ex.getMessage());
//        } finally {
//            System.out.println();
//        }
        int[] arr = {23,15,42,21};
        try {
            System.out.println("arr[4] = "+ arr[4]);
            throw new IOException("Сало - це смачно");
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Виникола помилка. Вийшли за межі індексу масива.");
        }


    }
}
