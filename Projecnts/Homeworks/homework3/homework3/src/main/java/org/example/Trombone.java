package org.example;

public class Trombone extends Instrument{
    public Trombone(String name, boolean isAcoustics, String description, String history) {
        super(name, isAcoustics, description, history);
    }

    public Trombone() {
        super("Тромбон",
                true,
                "це мідний духовий інструмент басово-тенорового регістру, головною особливістю якого є висувна куліса для зміни висоти звуку",
                "Походження (XV ст.): Тромбон вважається одним із найдавніших мідних духових інструментів, який майже не змінив свою форму за століття. Його прямим предком був сакбут (sackbut) — середньовічний інструмент, що розвинувся з кулісної труби. ");
    }

    public void Sound() {
        System.out.println("Звук Тромбона 🔊 🎶🎵🎶");
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
