package org.example.myClasses;

//Аналог Template у C# - java Generic
public class Box<T> {
    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    //Якщо є статичний метод в клісі, то він
    public static <MyType> void printArray(MyType[] elements) {
        for (var item : elements) {
            System.out.print(item + "\t");
        }
        System.out.println();
    }
}
