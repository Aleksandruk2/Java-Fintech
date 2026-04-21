package org.example;

public class Cello extends Instrument{
    public Cello(String name, boolean isAcoustics, String description, String history) {
        super(name, isAcoustics, description, history);
    }

    public Cello() {
        super("Віолончель",
                true,
                "це великий струнний смичковий інструмент басово-тенорового регістру. Вона має глибокий, багатий і надзвичайно проникливий звук, який часто порівнюють з чоловічим оперним голосом (баритоном)",
                "Поява (XVI ст.): Віолончель виникла як прямий нащадок віоли да браччо. Перші згадки про неї з'явилися в Італії близько 1530-х років. Спочатку вона називалася «басова скрипка».");
    }

    public void Sound() {
        System.out.println("Звук Віолончель 🔊 🎶🎵🎶");
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
