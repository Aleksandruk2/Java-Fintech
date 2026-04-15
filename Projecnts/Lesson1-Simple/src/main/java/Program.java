import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Program {
    static void simple1() {
        // Типи дані ті самі, що у C#
        int a;
        double d;
        float f;
        boolean b;
        int [] intsArr; // Масив цілих чисел
        // C# - Collection - Generic
        String str; // класи пишуться з великої літери.
        char ch = 'A'; //unicode - 2 байти.

        // sout - це шорткарт для виведу повідомлення в консоль
        System.out.println("Привіт Козаки!");

        System.out.println("Вкажіть як вас звати:");
        // Scanner - отримує дані із косолі. System.in
        Scanner input = new Scanner(System.in);
        str = input.nextLine(); // Отримуємо рядок. Аналог Console.ReadLine() на C#
//        System.out.println("Привіт друже" + str);
        // %s - буде підставляти у дане місце змінну після коми
        System.out.printf("Привіт друже %s\n", str);

        System.out.print("Скільки вам років:");
//        int age = Integer.parseInt(input.next()); // перетворюємо у число
//        int age = Integer.getInteger(input.next()); // перетворюємо у число
        int age = input.nextInt();
        System.out.printf("Вам %s років", age);
    }

    static void simpleIf() {
        // >, <, >=, <=, ==, !=, <!=,
        System.out.println("Скільки вам рочків:");
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.next());
        if(age >= 23 && age <= 25)
        {
            System.out.println("Ви не можете їхати за кордон.");
        }
        else if (age >= 25 && age < 60)
        {
            System.out.println("Вас можуть мобілізувать. У вас є Резерв+");
        }
        else if (age < 23)
        {
            System.out.println("Ви можете їхати за кордон :)");
        }
    }

    static void simpleArrayRandom() {
        String [] names = {
                "Іванка",
                "Мільвіна",
                "Руслана",
                "Галина",
                "Василь"
        };

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        // Це - foreach - просто так в java пишеться foreach
        for (String name: names) {
            System.out.println(name);
        }

        Random rand = new Random();
        System.out.println("Вкажіть розмір масиву:");
        int size = Integer.parseInt(new Scanner(System.in).next());
        int [] myArr = new int [size];
        for (int i=0; i<size; i++){
            myArr[i]=rand.nextInt(5,11);
        }
        for (var item : myArr) {
            System.out.printf("%d\t", item);
        }
    }

    public static void main(String [] args) {
//        simple1();
//        simpleIf();
//        simpleArrayRandom();
        // побітова операція XOR
        // переставити змінні місцями, не використовючи третю зміну
        int a = 12;
        int b = 18;
        System.out.printf("a = %d\tb = %d\n", a, b);
        a = a ^ b;
        System.out.printf("'a = a ^ b' : a = %d\tb = %d\n", a, b);
        b = a ^ b;
        System.out.printf("'b = a ^ b' : a = %d\tb = %d\n", a, b);
        a = a ^ b;
        System.out.printf("'a = a ^ b' : a = %d\tb = %d\n", a, b);

    }
}
