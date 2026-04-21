package org.example;

public class Violin extends Instrument {
    public Violin(String name, boolean isAcoustics, String description, String history) {
        super(name, isAcoustics, description, history);
    }

    public Violin() {
        super("Скрипка",
                true,
                "це струнний смичковий інструмент сопранового регістру, який через свій виразний, подібний до людського голосу тембр часто називають «королевою музики»",
                "Витоки (до XVI ст.): Прототипами скрипки були давні інструменти, такі як арабський ребаб, німецька рота, а також середньовічний фідель та віола да браччо.");
    }

    public void Sound() {
        System.out.println("Звук Скрипки 🔊 🎶🎵🎶");
    }

    public void Show() {
        System.out.println(name);
    }

    public void Desc() {
        System.out.println(description);
    }

    public void History() {
        System.out.println(history);
    }
}
