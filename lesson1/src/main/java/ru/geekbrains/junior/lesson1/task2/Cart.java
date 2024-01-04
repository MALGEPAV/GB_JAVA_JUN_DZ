package ru.geekbrains.junior.lesson1.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 *
 * @param <T> Еда
 */
public class Cart<T extends Food> {

    //region Поля

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    //endregion

    //region Конструкторы

    /**
     * Создание нового экземпляра корзины
     *
     * @param market принадлежность к магазину
     */
    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public void cardBalancing() {

        AtomicBoolean proteins = new AtomicBoolean(foodstuffs.stream()
                .anyMatch(Food::getProteins));
        AtomicBoolean fats = new AtomicBoolean(foodstuffs.stream()
                .anyMatch(Food::getFats));
        AtomicBoolean carbohydrates = new AtomicBoolean(foodstuffs.stream()
                .anyMatch(Food::getCarbohydrates));

        if (proteins.get() && fats.get() && carbohydrates.get()) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        if (!proteins.get()) {
            market.getThings(clazz).stream()
                    .filter(Food::getProteins)
                    .findAny()
                    .ifPresentOrElse(food -> {
                                foodstuffs.add(food);
                                proteins.set(true);
                            },
                            () -> System.out.println("Невозможно сбалансировать корзину по БЖУ: белков нет хватает(((")
                    );
            if (!proteins.get()) return;
        }
        if (!fats.get()) {
            market.getThings(clazz).stream()
                    .filter(Food::getFats)
                    .findAny()
                    .ifPresentOrElse(food -> {
                                foodstuffs.add(food);
                                fats.set(true);
                            },
                            () -> System.out.println("Невозможно сбалансировать корзину по БЖУ: жиров нет хватает((("));
            if (!fats.get()) return;
        }
        if (!carbohydrates.get()) {
            market.getThings(clazz).stream()
                    .filter(Food::getCarbohydrates)
                    .findAny()
                    .ifPresentOrElse(food -> {
                                foodstuffs.add(food);
                                carbohydrates.set(true);
                            },
                            () -> System.out.println("Невозможно сбалансировать корзину по БЖУ: углеводов нет хватает(((")
                    );
            if (!carbohydrates.get()) return;
        }
        if (proteins.get() && fats.get() && carbohydrates.get()) {
            System.out.println("Корзина cбалансирована по БЖУ.");
        }

    }

    //endregion

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }


    public void printFoodstuffs() {
        /*int index = 1;
        for (var food : foodstuffs)
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, food.getName(), food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет", food.getCarbohydrates() ? "Да" : "Нет");*/


        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                index.getAndIncrement(), food.getName(),
                food.getProteins() ? "Да" : "Нет",
                food.getFats() ? "Да" : "Нет",
                food.getCarbohydrates() ? "Да" : "Нет"));
    }
}
