package ru.geekbrains.junior.lesson1.homework_task1;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class task1 {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1,2,3,4,5,6,7,8,9);
        AtomicInteger i = new AtomicInteger(0);
        double meanOfEvenNumbers = intList.stream()
                .filter(n -> n % 2 == 0)
                .mapToDouble(Integer::doubleValue)
                .reduce(0.0, (s,a)->{
                    double j = i.getAndIncrement();
                    return (j/(j+1))*s+a/(j+1);
                });
        System.out.println("The mean value of the even numbers in the list is: " + meanOfEvenNumbers);
    }
}
