package org.example;

import org.example.entities.CategoryEntity;
import org.example.utils.HibernateHelper;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//      var session = HibernateHelper.getSession();
        Scanner scanner = new Scanner(System.in);
//        InsertData(scanner);
        ReadData();
//        DeleteData(scanner);
        UpdateData(scanner);
        ReadData();
//      session.close();
        System.out.println("- Java код був завершений.");
    }

    public static void InsertData(Scanner scanner) {
        try (var session = HibernateHelper.getSession()) {
            // Почати транзакцію
            session.beginTransaction();
            System.out.print("Вкажіть назву категорії\n- ");
            String categoryName = scanner.nextLine();
            if (categoryName.isEmpty())
                return;
            var cat = new CategoryEntity(categoryName);
            //context.Categories.Add(cat); // як у C#
            session.persist(cat); // Додати нову категорію

            // Завершити транзакцію
            session.getTransaction().commit();
            System.out.println("Cat id " + cat.getId());
        } catch (Exception ex) {
            System.out.printf("Сталася халепа %d", ex.getMessage());
        }
    }

    public static void ReadData() {
        try (var session = HibernateHelper.getSession()) {
            // Почати транзакцію
            session.beginTransaction();
            var list = session.createQuery("from CategoryEntity ",
                    CategoryEntity.class).getResultList();
            for (var item : list) {
                System.out.printf("%d \t%s\n", item.getId(), item.getName());
            }

            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.printf("Сталася халепа %d", ex.getMessage());
        }
    }

    public static void DeleteData(Scanner scanner) {
        try (var session = HibernateHelper.getSession()) {
            // Почати транзакцію
            session.beginTransaction();
            System.out.print("Вкажіть id запису:\n- ");
            int id = scanner.nextInt();
            var entity = session.find(CategoryEntity.class, id);
            if (entity != null) {
                session.remove(entity);
            }
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.printf("Сталася халепа %d", ex.getMessage());
        }
    }

    public static void UpdateData(Scanner scanner) {
        try (var session = HibernateHelper.getSession()) {
            // Почати транзакцію
            session.beginTransaction();
            System.out.print("Вкажіть id запису:\n- ");
//            int id = scanner.nextInt();
//            scanner.nextLine(); // очисти буфер від \n
            int id = Integer.parseInt(scanner.nextLine());
            var entity = session.find(CategoryEntity.class, id);
            if (entity != null) {
                System.out.print("Вкажіть нову назву:\n- ");
                String newCategoryName = scanner.nextLine();
                entity.setName(newCategoryName);
                session.merge(entity); // Оновити зміни
            }
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.printf("Сталася халепа %d", ex.getMessage());
        }
    }
}