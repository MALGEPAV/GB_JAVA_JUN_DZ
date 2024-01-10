package ru.geekbrains.junior.lesson2.HW_task1;

public class Cat extends Animal {
    private int whiskerCount;
    private boolean isHairless;

    public Cat(){
        age = 1;
        name = "Kitty";
        whiskerCount = 10;
        isHairless = false;
    }

    public int getWhiskerCount() {
        return whiskerCount;
    }

    public boolean isHairless() {
        return isHairless;
    }

    private void makeSound(){
        System.out.println("MEOW!!!");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "whiskerCount=" + whiskerCount +
                ", isHairless=" + isHairless +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
