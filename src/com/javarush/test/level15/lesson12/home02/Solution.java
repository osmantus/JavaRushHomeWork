package com.javarush.test.level15.lesson12.home02;

/* Тренировка мозга
Найти логическую ошибку: метод doAction в реализации интерфейса Movable должен выдавать "moving".
Исправьте ошибку, при необходимости измените (отрефакторите) интерфейс Movable.
Результат вывода в консоль должен быть:
flying
moving
*/

public class Solution {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Util.fly(duck);
        Util.move(duck);
    }

    public static class Duck implements Flyable {
        @Override
        public void doActionFlying() {
            System.out.println("flying");
        }
        @Override
        public void doAction() {
            System.out.println("moving");
        }
    }

    public static class Util {
        static void fly(Flyable animal) {
            animal.doActionFlying();
        }

        static void move(Movable animal) {
            animal.doAction();
        }
    }

    public static interface Flyable extends Movable {
        void doActionFlying();
    }

    public static interface Movable {
        void doAction();
    }
}
