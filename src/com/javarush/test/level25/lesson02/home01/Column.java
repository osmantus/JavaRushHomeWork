package com.javarush.test.level25.lesson02.home01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public String getColumnName()
    {
        return columnName;
    }

    @Override
    public boolean isShown()
    {
        if (ordinal() >= 0)
        {
            if (realOrder.length >= ordinal())
            {
                if (realOrder[ordinal()] >= 0)
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        return false;
    }

    @Override
    public void hide()
    {
        if (ordinal() >= 0)
        {
            if (realOrder.length >= ordinal())
            {
                int hiddenColIndex = realOrder[ordinal()];

                if (realOrder[ordinal()] != -1)
                {
                    realOrder[ordinal()] = -1;

                    Column[] cols = Column.values();
                    for (int i = 0; i < cols.length; i++)
                    {
                        if (realOrder[i] >= hiddenColIndex)
                        {
                            realOrder[i] = realOrder[i] - 1;
                        }
                    }
                }
            }
        }
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result;

        Column[] colsArray = Column.values();
        Column col = null;
        Column[] sortedColsArray = Column.values();

        for (int i = 0; i < realOrder.length; i++)
        {
            col = colsArray[i];
            if (col != null)
            {
                if (!col.isShown())
                {
                    sortedColsArray[i] = null;
                }
            }
        }

        ArrayList<Column> sortedColsArrayList = new ArrayList<>(sortedColsArray.length);
        for (Column eachCol : sortedColsArray)
        {
            if (eachCol != null)
                sortedColsArrayList.add(eachCol);
        }

        int i = 0;
        for (Column eachCol : sortedColsArray)
        {
            if (eachCol != null)
            {
                i = eachCol.ordinal();
                col = sortedColsArray[i];
                    if (col.isShown())
                    {
                        if (sortedColsArrayList.size()-1 >= realOrder[i])
                            sortedColsArrayList.set(realOrder[i], col);
                    }
            }
        }

        result = sortedColsArrayList.subList(0, sortedColsArrayList.size());

        return result;
    }

}
