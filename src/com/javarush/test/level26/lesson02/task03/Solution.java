package com.javarush.test.level26.lesson02.task03;

import java.util.*;

/* Убежденному убеждать других не трудно.
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напишите public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать список компараторов
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т
В конструктор передается как минимум один компаратор
*/
public class Solution {

    public static class TableRecord
    {
        private int field1;
        private double field2;
        private String field3;

        public TableRecord(int field1, double field2, String field3)
        {
            this.field1 = field1;
            this.field2 = field2;
            this.field3 = field3;
        }
    }

    public static ArrayList<TableRecord> records = new ArrayList<>();

    static {
        records.add(new TableRecord(10, 20.0, "Test2"));
        records.add(new TableRecord(10, 25.0, "Test2"));
        records.add(new TableRecord(10, 40.0, "Test2"));
        records.add(new TableRecord(12, 30.0, "Test1"));
        records.add(new TableRecord(5, 15.0, "Test3"));
    }

    /*public static HashMap<Integer, ArrayList<Object>> table = new HashMap<>();

    public static ArrayList<Object> record1 = new ArrayList<>();
    public static ArrayList<Object> record2 = new ArrayList<>();

    static {
        record1.add(new Integer(10));
        record1.add(new Integer(20));

        table.put(0, record1);

        record2.add(new Integer(30));
        record2.add(new Integer(25));

        table.put(1, record2);
    }*/

    public static class CustomizedComparator<T> implements Comparator<T>
    {
        private static ArrayList<Comparator<?>> comparatorsList = new ArrayList<>();

        public <T> CustomizedComparator(Comparator<T>... comparators)
        {
            if (comparators.length > 0)
            {
                for (Comparator<T> eachComparator : comparators)
                {
                    comparatorsList.add(eachComparator);
                }
            }
        }

        @Override
        public int compare(T o1, T o2)
        {
            if (comparatorsList.size() > 0)
            {
                for (Comparator eachComparator : comparatorsList)
                {
                    int result = eachComparator.compare(o1, o2);
                    if (result != 0)
                        return result;
                }
            }
            return 0;
        }

    }

    public static void main(String[] args)
    {
        Comparator<TableRecord> comp1 = new Comparator<TableRecord>()
        {
            @Override
            public int compare(TableRecord o1, TableRecord o2)
            {
                return o2.field1 - o1.field1;
            }
        };

        Comparator<TableRecord> comp2 = new Comparator<TableRecord>()
        {
            @Override
            public int compare(TableRecord o1, TableRecord o2)
            {
                if (o1.field2 > o2.field2)
                    return 1;
                else if (o1.field2 < o2.field2)
                    return -1;
                else
                    return 0;
            }
        };

        /*ArrayList<TableRecord> records2 = new ArrayList<>();
        records2.add(new TableRecord(10, 20.0, "Test2"));
        records2.add(new TableRecord(12, 30.0, "Test1"));
        records2.add(new TableRecord(5, 15.0, "Test3"));*/


        CustomizedComparator customComparator = new CustomizedComparator(comp1, comp2);
        //CustomizedComparator customComparator = new CustomizedComparator(comp2, comp1);

        //customComparator.sort(records);

        Collections.sort(records, customComparator);

        System.out.println();
    }
}
