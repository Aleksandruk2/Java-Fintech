package org.example;

public class Main {
    static void main() {
        Cello cello = new Cello();
        cello.Show();

        Violin violin = new Violin();
        violin.Desc();

        Trombone trombone = new Trombone();
        trombone.History();

        Ukulele ukulele = new Ukulele();
        ukulele.Sound();
    }
}
