package example;

public class Main {
    public static void main(String[] args){
        System.out.println("Пирвіт світ!");
        //Типи даних: Ті самі, що у C#
        //boolean, String
        //decimal - немає
        //double a = 24.2;
        //Умовні оператори - ті самі, що у C# - різниці немає.
        //Оператори циклу
        //while, do while, for,
        // У C# foreach а в Java - це for in
        int [] list = {14,42,23,67,623};
        //for(int i: list) {
        //    System.out.println(i);
        //}
        for(int i = 0; i < list.length;i++) {
            System.out.printf("%d\t", list[i]);
        }
        // Логічні оператори - &&, ||
        String str = "Привіт!";
        System.out.printf("%s\n",str.toLowerCase());

        Person peter = new Person();

        peter.setName("Справжнє ім'я Петра.");
        System.out.println(peter.getName());
        System.out.println(peter);

        Person olga = new Person("Ольга Миколаївна", "42");
        System.out.println(olga);
    }
}
