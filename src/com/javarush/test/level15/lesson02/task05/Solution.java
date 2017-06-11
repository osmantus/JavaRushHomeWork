package com.javarush.test.level15.lesson02.task05;

import java.util.ArrayList;
import java.util.List;

/* ООП - исправь ошибки в наследовании
Исправь метод containsBones и всю связанную с ним логику так, чтобы:
1. Поведение программы осталось прежним, т.е. она должна выдавать то же самое, что и выдает сейчас
2. Метод containsBones должен возвращать тип Object и значение "Yes" вместо true, "No" вместо false
*/

public class Solution {
    public static interface Alive {
        //boolean containsBones();
        Object containsBones();
    }

    public static class BodyPart implements Alive {
        private String name;

        public BodyPart(String name) {
            this.name = name;
        }

        public Object containsBones() {
            return new String("Yes");
        }

        public String toString() {
            //return containsBones() ? name + " содержит кости" : name + " не содержит кости";
            Object isBonesExisted = containsBones();
            if (isBonesExisted instanceof String)
            {
                if (((String) isBonesExisted).equals("Yes"))
                    return name + " содержит кости";
                else if (((String) isBonesExisted).equals("No"))
                    return name + " не содержит кости";
                else
                    return "";
            }
            else
                return "";
        }
    }

    public static class Finger extends BodyPart {
        private boolean isFoot;
        public Finger(String name, boolean isFoot) {
            super(name);
            this.isFoot = isFoot;
        }

        public Object containsBones() {
            //return super.containsBones() && !isFoot;

            Object isBonesExisted = super.containsBones();
            if (isBonesExisted instanceof String)
            {
                if (((String) isBonesExisted).equals("Yes") && !isFoot)
                    return new String("Yes");
                else
                    return new String("No");
            }
            else
                return "";
        }
    }
    public static void main(String[] args)
    {
        printlnFingers();
        printlnBodyParts();
        printlnAlives();
    }

    private static void printlnAlives() {
        Object isBonesExisted = new BodyPart("Рука").containsBones();
        if (isBonesExisted instanceof String)
        {
            if (isBonesExisted.equals("Yes"))
                System.out.println(true);
            else
                System.out.println(false);
        }
        else
            System.out.println(false);
    }

    private static void printlnBodyParts() {
        List<BodyPart> bodyParts = new ArrayList<BodyPart>(5);
        bodyParts.add(new BodyPart("Рука"));
        bodyParts.add(new BodyPart("Нога"));
        bodyParts.add(new BodyPart("Голова"));
        bodyParts.add(new BodyPart("Тело"));
        System.out.println(bodyParts.toString());
    }

    private static void printlnFingers() {
        List<Finger> fingers = new ArrayList<Finger>(5);
        fingers.add(new Finger("Большой", true));
        fingers.add(new Finger("Указательный", true));
        fingers.add(new Finger("Средний", true));
        fingers.add(new Finger("Безымянный", false));
        fingers.add(new Finger("Мизинец", true));
        System.out.println(fingers.toString());
    }
}

