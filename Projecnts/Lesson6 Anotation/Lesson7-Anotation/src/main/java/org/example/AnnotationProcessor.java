package org.example;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void processAnnotations(Object obj) {
        Class<?> clazz = obj.getClass();

        // Перевіряємо анотації методів
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ILogRuntimeInfo.class)) {
                ILogRuntimeInfo log = method.getAnnotation(ILogRuntimeInfo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Log: " + log.value());
            }
        }
    }
}
