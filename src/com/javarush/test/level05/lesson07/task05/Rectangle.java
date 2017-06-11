package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    private Double top;
    private Double left;
    private Double width;
    private Double height;

    public void initialize(Double top)
    {
        this.top = top;
    }
    public void initialize(Double top, Double left)
    {
        this.top = top;
        this.left = left;
    }
    public void initialize(Double top, Double left, Double width)
    {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = width;
    }
    public void initialize(Double top, Double left, Double width, Double height)
    {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }
    public void initialize(Rectangle rectangle)
    {
        this.top = rectangle.top;
        this.left = rectangle.left;
        this.width = rectangle.width;
        this.height = rectangle.height;
    }
}
