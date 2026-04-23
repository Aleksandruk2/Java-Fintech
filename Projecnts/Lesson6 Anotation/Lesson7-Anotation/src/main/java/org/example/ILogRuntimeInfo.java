package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Цей default метод буде виконуватися при ініціалізації додатку.
// По суті при запуску вашої програми.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ILogRuntimeInfo {
    String value() default "Виконання методу";
}
