package ru.geekbrains.junior.lesson2.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {

    /**
     * Задача 1: Основы Reflection API
     * ===============================
     * <p>
     * Получите информацию о классе "Person" с использованием Reflection API:
     * выведите на экран все поля и методы класса.
     * Создайте экземпляр класса "Person" с использованием Reflection API,
     * установите значения полей и вызовите методы.
     * Реализуйте обработку исключений для обеспечения корректного взаимодействия
     * с Reflection API.
     */

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {

        Class<?> personalClass = Class.forName("ru.geekbrains.junior.lesson2.task1.Person");


        // Получить список всех полей
        Field[] fields = personalClass.getDeclaredFields();
        for (Field field : fields){
            System.out.println("Поле: " + field.getName());
        }

        // Получить список всех конструкторов
        Constructor[] constructors
                = personalClass.getConstructors();


        // Создадим экземпляр класса
        Object personInstance1 = constructors[0].newInstance(null);
        Object personInstance2 = constructors[0].newInstance(null);


        //Устанавливаем значения полей
        Field nameField = personalClass.getDeclaredField("name");
        nameField.setAccessible(true); // Разрешаем доступ к закрытому полю
        nameField.set(personInstance2, "Alice");

        Field ageField = personalClass.getDeclaredField("age");
        ageField.setAccessible(true); // Разрешаем доступ к закрытому полю
        ageField.set(personInstance2, 30);

        // Вызов метода
        Method displayInfoMethod = personalClass.getDeclaredMethod("displayInfo");
        displayInfoMethod.invoke(personInstance2);


    }

}
