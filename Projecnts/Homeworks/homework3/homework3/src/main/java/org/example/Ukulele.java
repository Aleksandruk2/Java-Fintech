package org.example;

public class Ukulele extends Instrument{
    public Ukulele(String name, boolean isAcoustics, String description, String history) {
        super(name, isAcoustics, description, history);
    }

    public Ukulele() {
        super("Укулеле",
                true,
                "це компактна чотириструнна гітара, яка стала національним символом гавайської культури та одним із найпопулярніших інструментів у світі завдяки своїй доступності",
                "Португальське коріння (1879 рік): Хоча укулеле асоціюється з Гаваями, його винайшли португальські іммігранти з Мадейри. Прообразом став інструмент брагінья (різновид кавакінью). У серпні 1879 року майстри Жозе ду Еспіріту Санту, Мануель Нуньєс та Аугусту Діаш привезли ці інструменти на Гаваї.");
    }

    public void Sound() {
        System.out.println("Звук Укулеле 🔊 🎶🎵🎶");
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
