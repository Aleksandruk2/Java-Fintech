import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    static void Task1(){
        System.out.println(ANSI_GREEN + "**\tЗавдання 1");
        System.out.println(ANSI_BLUE + "Вивести на екран надпис \"Your time is limited, so don’t waste it living someone else’s life\" Steve Jobs\n" +
                "в різних рядках. Приклад виводу:\n" + ANSI_YELLOW +
                "“Your time is limited,\n" +
                "\tso don’t waste it\n" +
                "\t\tliving someone else’s life”\n" +
                "\t\t\tSteve Jobs" + ANSI_RESET);

        System.out.println();
        System.out.println("- - - - -");
        System.out.println();
    }

    static void Task2(){
        System.out.println(ANSI_GREEN + "**\tЗавдання 2");
        System.out.println(ANSI_BLUE + "Користувач вводить з клавіатури два числа. Перше число — це значення, друге число — відсоток,\n" +
                "який необхідно підрахувати. Наприклад, ми ввели з клавіатури 50 і 10. Потрібно вивести на екран\n" +
                "10 відсотків від 50. Результат — 5.");

        System.out.println(ANSI_PURPLE);
        System.out.print("Введіть значення:\n- ");
        int value = Integer.parseInt(new Scanner(System.in).next());
        System.out.print("Введіть відсоток:\n- ");
        double percent = Integer.parseInt(new Scanner(System.in).next());
        System.out.printf("Результат: " + ANSI_YELLOW + value * (percent / 100));
        System.out.println(ANSI_RESET);

        System.out.println();
        System.out.println("- - - - -");
        System.out.println();
    }

    static void Task3(){
        System.out.println(ANSI_GREEN + "**\tЗавдання 3");
        System.out.println(ANSI_BLUE + "Користувач вводить з клавіатури 3 числа. Необхідно створити число, що містить ці числа.\n" +
                "Наприклад, якщо з клавіатури введено 7, 3, 8, тоді потрібно сформувати число 738.");

        System.out.println(ANSI_PURPLE);
        System.out.println("Потрібно ввести 3 числа.");
        System.out.print("Введіть число 1:\n- ");
        int value1 = Integer.parseInt(new Scanner(System.in).next());
        System.out.print("Введіть число 2:\n- ");
        int value2 = Integer.parseInt(new Scanner(System.in).next());
        System.out.print("Введіть число 3:\n- ");
        int value3 = Integer.parseInt(new Scanner(System.in).next());

        System.out.println("Результат: " + ANSI_YELLOW + ((value1 * 100) + (value2 * 10) + value3));
        System.out.println(ANSI_RESET);

        System.out.println();
        System.out.println("- - - - -");
        System.out.println();
    }

    static void Task4(){
        System.out.println(ANSI_GREEN + "**\tЗавдання 4");
        System.out.println(ANSI_BLUE + "Користувач вводить шестизначне число. Необхідно змінити в цьому числі перше і шосте число, а\n" +
                "також друге і п’яте число. Наприклад, 723895 повинно перетворитися на 593827\n" +
                "Якщо користувач ввів не шестизначне число потрібно вивести повідомлення про помилку." + ANSI_RESET);

        System.out.println(ANSI_PURPLE);
        System.out.print("Введіть шестизначне число:\n- ");
        int value = Integer.parseInt(new Scanner(System.in).next());
        if(value >= 100000 && value <= 999999) {
            int value1 = value / 100000;
            int value2 = value / 10000 % 10;
            int value3 = value / 1000 % 10;
            int value4 = value / 100 % 10;
            int value5 = value / 10 % 10;
            int value6 = value % 10;
            System.out.println("Результат: " + ANSI_YELLOW +
                    ((value6 * 100000) +
                    (value5 * 10000) +
                    (value3 * 1000) +
                    (value4 * 100) +
                    (value2 * 10) +
                    (value1)));
        } else {
            System.out.println(ANSI_RED + "Ви ввели не шестизначене число.");
        }

        System.out.println(ANSI_RESET);

        System.out.println();
        System.out.println("- - - - -");
        System.out.println();
    }

    static void Task5(){
        System.out.println(ANSI_GREEN + "**\tЗавдання 5");
        System.out.println(ANSI_BLUE + "Користувач вводить з клавіатури номер місяця(1-12). В залежності від отриманого номера програма\n" +
                "виводить на екран надпис : Winter (якщо введене значення 1,2 або 12), Spring (якщо введене значення від\n" +
                "3 до 5), Summer (якщо введене значення від 6 до 8), Autumn (якщо введене значення від 9 до 11).\n" +
                "Якщо користувач ввів значення не в діапазоні від 1 до 12 потрібно вивести повідомлення про помилку.\n" + ANSI_RESET);

        System.out.println(ANSI_PURPLE);
        System.out.print("Введіть номер місяця:\n- ");
        int value = Integer.parseInt(new Scanner(System.in).next());
        if(value >= 0 && value <= 12) {
            if(value == 1 || value == 2 || value == 12) {
                System.out.println(ANSI_YELLOW + "Winter ❄️");
            } else if (value >= 3 && value <= 5) {
                System.out.println(ANSI_YELLOW + "Spring 🌸");
            } else if (value >= 6 && value <= 8) {
                System.out.println(ANSI_YELLOW + "Summer ☀️");
            } else if (value >= 9 && value <= 11) {
                System.out.println(ANSI_YELLOW + "Autumn 🍂");
            }
        } else {
            System.out.println(ANSI_RED + "Токого номера місяця не існує.");
        }
        System.out.println(ANSI_RESET);

        System.out.println();
        System.out.println("- - - - -");
        System.out.println();
    }

    static void Task6(){
        System.out.println(ANSI_GREEN + "**\tЗавдання 6");
        System.out.println(ANSI_BLUE + "Користувач вводить з клавіатури кількість метрів. В залежності від вибору користувача програма\n" +
                "переводить метри в милі, дюйми чи ярди" + ANSI_RESET);

        System.out.println(ANSI_PURPLE);
        System.out.print("Введіть кількість метрів:\n- ");
        double value = new Scanner(System.in).nextDouble();
        System.out.print("Виберіть в які одниці вимірювання переводити\n" +
                "1. Милі\n" +
                "2. Дюйми\n" +
                "3. Ярди\n" +
                "- ");
        int select = Integer.parseInt(new Scanner(System.in).next());
        switch (select) {
            case 1:
                System.out.println(value + "метрів = " + ANSI_YELLOW + String.format("%.6f", (value * 0.00062137)) + " милі");
                break;
            case 2:
                System.out.println(value + "метрів = " + ANSI_YELLOW + String.format("%.6f", (value * 39.3701)) + " дюйми");
                break;
            case 3:
                System.out.println(value + "метрів = " + ANSI_YELLOW + String.format("%.6f", (value * 1.09361)) + " ярди");
                break;
            default:
                System.out.println(ANSI_RED + "Такого пункту не існує.");
        }
        System.out.println(ANSI_RESET);

        System.out.println();
        System.out.println("- - - - -");
        System.out.println();
    }

    static void Task7(){
        System.out.println(ANSI_GREEN + "**\tЗавдання 7");
        System.out.println(ANSI_BLUE + "Користувач вводить з клавіатури два числа. Потрібно вивести всі непарні числа в вказаному\n" +
                "діапазоні. Якщо границі вказані не вірно потрібно провести нормалізацію границь. Наприклад,\n" +
                "якщо ввели 20 і 11, потрібна нормалізація, після якої початок стане рівним 11, а кінець 20." + ANSI_RESET);

        System.out.println(ANSI_PURPLE);
        System.out.print("Введіть початок діапазону:\n- ");
        int value1 = new Scanner(System.in).nextInt();
        System.out.print("Введіть кінець діапазону:\n- ");
        int value2 = new Scanner(System.in).nextInt();
        if (value1 > value2) {
            value1 = value1 ^ value2;
            value2 = value1 ^ value2;
            value1 = value1 ^ value2;
        }
        System.out.print("Результат: " + ANSI_YELLOW);
        for (int i = value1; i <= value2; i++) {
            if ( i % 2 != 0 )
                System.out.print(i + "\t");
        }

        System.out.println(ANSI_RESET);

        System.out.println();
        System.out.println("- - - - -");
        System.out.println();
    }

    static void Task8(){
        System.out.println(ANSI_GREEN + "**\tЗавдання 8");
        System.out.println(ANSI_BLUE + "Показати на екрані таблицю множення в діапазоні, вказаному користувачем. Наприклад, якщо\n" +
                "користувач вказав 3 і 5, таблиця може виглядати так\n" +
                "3*1 = 3 3*2 = 6 3*3 = 9 ………… 3* 10 = 30\n" +
                "……………………………………………………\n" +
                "5*1 = 5 5 *2 = 10 5 *3 = 15 …………." + ANSI_RESET);

        System.out.println(ANSI_PURPLE);
        System.out.print("Введіть початок діапазону:\n- ");
        int start = new Scanner(System.in).nextInt();
        System.out.print("Введіть кінець діапазону:\n- ");
        int end = new Scanner(System.in).nextInt();
        if (start > end) {
            start = start ^ end;
            end = start ^ end;
            start = start ^ end;
        }
        for (int i = start; i <= end; i ++) {
            System.out.printf("Таблиця множеня числа %s\n- - - - -\n", i);
            for (int j = 1; j <= 10; j++){
                System.out.print(ANSI_YELLOW + i + "*" + j + "=" + i*j + "\n" + ANSI_PURPLE);
            }
            System.out.println("- - - - -");
        }
        System.out.println(ANSI_RESET);

        System.out.println();
        System.out.println("- - - - -");
        System.out.println();
    }

    static void Task9(){
        System.out.println(ANSI_GREEN + "**\tЗавдання 9");
        System.out.println(ANSI_BLUE + "В одномірному масиві, заповненому випадковими числами, визначаємо мінімальне і\n" +
                "максимальне значення, підраховуємо кількість від’ємних значень, підраховуємо кількість\n" +
                "додатних значень, підраховуємо кількість нулів. Результат виводимо на екран." + ANSI_RESET);

        System.out.println(ANSI_PURPLE);
        Random random = new Random();
        int[] array = random.ints(20, -50, 51).toArray();

        System.out.println("Масив: " + ANSI_YELLOW + Arrays.toString(array) + ANSI_PURPLE);

        int min = array[0];
        int max = array[0];
        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;

        for (int num : array) {
            if (num < min) min = num;
            if (num > max) max = num;

            if (num < 0) {
                negativeCount++;
            } else if (num > 0) {
                positiveCount++;
            } else {
                zeroCount++;
            }
        }

        System.out.println("- - - - -");
        System.out.println("Мінімальне значення: " + ANSI_YELLOW + min + ANSI_PURPLE);
        System.out.println("Максимальне значення: " + ANSI_YELLOW + max + ANSI_PURPLE);
        System.out.println("Кількість від’ємних: " + ANSI_YELLOW + negativeCount + ANSI_PURPLE);
        System.out.println("Кількість додатних: " + ANSI_YELLOW + positiveCount + ANSI_PURPLE);
        System.out.println("Кількість нулів: " + ANSI_YELLOW + zeroCount + ANSI_PURPLE);
        System.out.println(ANSI_RESET);

        System.out.println();
        System.out.println("- - - - -");
        System.out.println();
    }

    static void Task10(){
        System.out.println(ANSI_GREEN + "**\tЗавдання 10");
        System.out.println(ANSI_BLUE + "Маємо одновимірний масив, заповнений випадковими числами. На основі даних масиву\n" +
                "потрібно:\n" +
                "\uF0B7 Створити одновимірний масив, що містить лише парні числа з першого масиву\n" +
                "\uF0B7 Створити одновимірний масив, що містить лише непарні числа з першого масиву\n" +
                "\uF0B7 Створити одновимірний масив, що містить лише від’ємні числа з першого масиву\n" +
                "\uF0B7 Створити одновимірний масив, що містить лише додатні числа з першого масиву" + ANSI_RESET);

        System.out.println(ANSI_PURPLE);
        Random random = new Random();
        int[] original = random.ints(15, -50, 51).toArray();

        System.out.println("Початковий масив: " + ANSI_YELLOW + Arrays.toString(original) + ANSI_PURPLE + "\n");

        int[] evenArray = Arrays.stream(original)
                .filter(n -> n % 2 == 0)
                .toArray();

        int[] oddArray = Arrays.stream(original)
                .filter(n -> n % 2 != 0)
                .toArray();

        int[] negativeArray = Arrays.stream(original)
                .filter(n -> n < 0)
                .toArray();

        int[] positiveArray = Arrays.stream(original)
                .filter(n -> n > 0)
                .toArray();

        System.out.println("Парні: " + ANSI_YELLOW + Arrays.toString(evenArray) + ANSI_PURPLE);
        System.out.println("Непарні: " + ANSI_YELLOW + Arrays.toString(oddArray) + ANSI_PURPLE);
        System.out.println("Від’ємні: " + ANSI_YELLOW + Arrays.toString(negativeArray) + ANSI_PURPLE);
        System.out.println("Додатні: " + ANSI_YELLOW + Arrays.toString(positiveArray) + ANSI_PURPLE);
        System.out.println(ANSI_RESET);

        System.out.println();
        System.out.println("- - - - -");
        System.out.println();
    }

    static void Task11(int size, boolean direction, char symbol){
        System.out.println(ANSI_GREEN + "**\tЗавдання 11");
        System.out.println(ANSI_BLUE + "Написати метод, що відображає вертикальну або горизонтальну лінію із деяких символів. Метод приймає\n" +
                "в якості параметрів: довжину лінії, напрям, символ.\n" + ANSI_RESET);

        System.out.println(ANSI_PURPLE);
        if (direction) {
            System.out.println("Горизонтальна лінія, розміром " + size + " сиволів " + "'" + symbol + "'");
        } else {
            System.out.println("Вертикальна лінія, розміром " + size + " сиволів " + "'" + symbol + "'");
        }
        System.out.println(ANSI_YELLOW);
        for (int i = 0; i <= size; i++) {
            if (direction)
                System.out.print(symbol);
            else
                System.out.println(symbol);
        }
        System.out.println(ANSI_RESET);

        System.out.println();
        System.out.println("- - - - -");
        System.out.println();
    }

    static void Task12(){
        System.out.println(ANSI_GREEN + "**\tЗавдання 12");
        System.out.println(ANSI_BLUE + "Написати метод, що сортує масив по спаданню або зростанню в залежності від вибору\n" +
                "користувача" + ANSI_RESET);

        System.out.println(ANSI_PURPLE);
        Random random = new Random();
        int[] array = random.ints(15, -50, 51).toArray();
        System.out.print("Виберіть фільтер сортування:\n" +
                "1. За зростаням\n" +
                "2. За спаданям\n- ");
        int value = new Scanner(System.in).nextInt();
        boolean ascending = switch (value) {
            case 1 -> true;
            default -> false;
        };
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                boolean needSwap = ascending ? (array[j] > array[j + 1])
                        : (array[j] < array[j + 1]);
                if (needSwap) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println("Масив: " + ANSI_YELLOW + Arrays.toString(array));
        System.out.println(ANSI_RESET);

        System.out.println();
        System.out.println("- - - - -");
        System.out.println();
    }

    public static void main (String[] args) {
//        Task1();
//        Task2();
//        Task3();
//        Task4();
//        Task5();
//        Task6();
//        Task7();
//        Task8();
//        Task9();
//        Task10();
//        Task11(20,true,'-');
//        Task11(20,false,'|');
        Task12();
    }
}
