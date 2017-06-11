package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        protected Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Object clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        public Object clone() throws CloneNotSupportedException
        {
            C cObj = null;
            if (getName() != null)
                cObj = new C(getI(), getJ(), new String(getName()));
            else
                cObj = new C(getI(), getJ(), null);

            return cObj;
        }
    }

    public static void main(String[] args)
    {
        A aObj = new A(1, 2);
        B bObj = new B(3, 4, null);
        C cObj = new C(5, 6, null);

        A cloneA = null;
        A cloneB = null;
        A cloneC = null;
        try
        {
            cloneA = (A) aObj.clone();
            cloneB = (B) bObj.clone();
            cloneC = (C) cObj.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

    }
}
