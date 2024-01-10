package ru.geekbrains.junior.lesson2.HW_task1;

public class Dog extends Animal{
    private int knownCommandsCount;
    private boolean isVaccinated;

    public Dog(){
        name = "Wolfie";
        age = 2;
        knownCommandsCount = 3;
        isVaccinated = true;
    }

    public int getKnownCommandsCount() {
        return knownCommandsCount;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "knownCommandsCount=" + knownCommandsCount +
                ", isVaccinated=" + isVaccinated +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
