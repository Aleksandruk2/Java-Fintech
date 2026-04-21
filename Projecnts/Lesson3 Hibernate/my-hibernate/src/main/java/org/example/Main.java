package org.example;

import org.example.entities.CategoryEntity;
import org.example.entities.ProductEntity;
import org.example.utils.HibernateHelper;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        var session = HibernateHelper.getSession();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Список категорій:");
        ReadData();
//        InsertDataGeneric(NewProduct(scanner));
        ReadDataProduct();

//        InsertData(scanner);
//        ReadData(scanner);
//        DeleteData(scanner);
//        UpdateData(scanner);
//        ReadData(scanner);
//        session.close();
//        System.out.println("Привіт Java!");
    }


    public static ProductEntity NewProduct(Scanner scanner) {
        ProductEntity p = new ProductEntity();
        System.out.println("Вкажіть назву продукту:");
        p.setName(scanner.nextLine());
        System.out.println("Вкажіть назву картинки:");
        p.setImage(scanner.nextLine());
        System.out.println("Вкажіть ціну:");
        p.setPrice(scanner.nextBigDecimal());
        System.out.println("Вкажіть id категорії:");
        var cat = new CategoryEntity();
        cat.setId(scanner.nextInt());
        p.setCategory(cat);
        return p;
    }

    public static <MyEntity> void InsertDataGeneric(MyEntity entity) {
        try (var session = HibernateHelper.getSession()) {
            // Почати транзакцію
            session.beginTransaction();
            session.persist(entity); // Додати нову категорію
            // Завершити транзакцію
            session.getTransaction().commit();
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

    public static void ReadDataProduct() {
        try (var session = HibernateHelper.getSession()) {
            // Почати транзакцію
            session.beginTransaction();
            var list = session.createQuery("from ProductEntity",
                    ProductEntity.class).getResultList();
            for (var item : list) {
                System.out.printf("%d \t%s : \t%s \t%s\n", item.getId(), item.getName(), item.getCategory().getName(), item.getCategory().getId());
            }

            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.printf("Сталася халепа %d", ex.getMessage());
        }
    }
}