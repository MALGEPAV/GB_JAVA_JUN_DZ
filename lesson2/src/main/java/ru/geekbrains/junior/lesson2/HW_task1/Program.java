package ru.geekbrains.junior.lesson2.HW_task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.AccessDeniedException;

public class Program {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Animal[] animals = new Animal[4];

        animals[0] = new Cat();
        animals[1] = new Dog();
        animals[2] = new Cat();
        animals[3] = new Dog();

        for (Animal animal : animals) {
            Method toString = animal.getClass().getMethod("toString");
            System.out.println(toString.invoke(animal));
            try{
                Method makeSound = animal.getClass().getDeclaredMethod("makeSound");
                makeSound.setAccessible(true);
                makeSound.invoke(animal);
            }catch (NoSuchMethodException e){
                System.out.println("Method makeSound is not supported!");
            }
        }
    }
}
