package example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.security.PublicKey;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String age;

    //Конструктор

    public Person() {
        this.age = "14";
    }

//    public Person(String name, String age) {
//        this.name = name;
//        this.age = age;
//    }

    @Override
    public String toString() {
        return String.format("Person(name = %s, age = %s)\n", name, age);
    }
}
