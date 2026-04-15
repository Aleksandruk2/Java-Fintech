package org.example;

import org.example.entities.CategoryEntity;
import org.example.utils.HibernateHelper;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var session = HibernateHelper.getSession();

        try {
            // Почати транзакцію
            session.beginTransaction();

            var cat = new CategoryEntity("Ковбасні вироби");
            session.persist(cat); // Додати нову категорію

            // Завершити транзакцію
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.printf("Сталася халепа %d", ex.getMessage());
        }

        session.close();
        System.out.println("- Java код був завершений.");
    }
}