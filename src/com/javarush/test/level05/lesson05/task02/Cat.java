package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

public class Cat
{
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat()
    {
    }

    public boolean fight(Cat anotherCat)
    {
        boolean result = false;

        if (this.age >= 2 && this.age <= 5)
        {
            if (anotherCat.age > this.age || anotherCat.age < this.age)
                result = true;
            else
            {
                if (this.strength > anotherCat.strength)
                    result = true;
                else if (this.strength < anotherCat.strength)
                    result = false;
                else
                {
                    if (this.weight >= 5 && this.weight <= 7)
                    {
                        if (anotherCat.weight > this.weight || anotherCat.weight < this.weight)
                            result = true;
                        else
                        {
                            if (anotherCat.weight > this.weight)
                                result = false;
                            else
                                result = true;
                        }
                    } else if (this.weight < 5)
                    {
                        if (anotherCat.weight >= 5 && anotherCat.weight <= 7)
                            result = false;
                        else if (anotherCat.weight > 7)
                            result = true;
                        else if (anotherCat.weight < 5)
                        {
                            if (this.weight > anotherCat.weight)
                                result = true;
                            else
                                result = false;
                        }
                    } else if (this.weight > 7)
                    {
                        if (anotherCat.weight >= 5 && anotherCat.weight <= 7)
                            result = false;
                        else if (anotherCat.weight > 7)
                            if (this.weight < anotherCat.weight)
                                result = true;
                            else
                                result = false;
                        else if (anotherCat.weight < 5)
                            result = true;
                    }
                }
            }
        }
        else if (this.age < 2)
        {
            if (anotherCat.age < 2)
            {
                if (this.age > anotherCat.age)
                    result = true;
                else
                    result = false;
            }
            else if (anotherCat.age <= 2 && anotherCat.age >= 5)
                result = false;
            else if (anotherCat.age > 5)
                result = true;
        }
        else if (this.age > 5)
        {
            if (anotherCat.age > 5)
            {
                if (this.age < anotherCat.age)
                    result = true;
                else
                    result = false;
            }
            else if (anotherCat.age <= 2 && anotherCat.age >= 5)
                result = false;
            else if (anotherCat.age < 2)
                result = false;
        }

        return result;
    }
}
