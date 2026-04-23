package org.example;

public class DataProcessor {
    // Реалізація події - це по суті CallBack
    interface IOnProcessData {
        void onSuccess(String result);
        void onError(Exception e);
    }

    public void processData(String data, IOnProcessData callback) {
        try {
            String result = data.toUpperCase();
            callback.onSuccess(result); // Коли обробляжмо дані - ми повертає інформацію про подію.
        } catch (Exception e) {
            callback.onError(e); // повертає помилку, якщо щось пішло не так через подію - вказівник
        }
    }

}
