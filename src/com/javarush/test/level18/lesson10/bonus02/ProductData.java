package com.javarush.test.level18.lesson10.bonus02;

/**
 * Created by Alex on 31.07.2016.
 */
public class ProductData
{
    private int id;
    private String productName;
    private String price;
    private String quantity;

    public ProductData(int id, String productName, String price, String quantity)
    {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId()
    {
        String idStr = String.valueOf(id);
        if (idStr.length() < 8)
        {
            int charsToAdd = 8 - idStr.length();
            StringBuffer sBuffer = new StringBuffer(idStr);
            for (int i = 0; i < charsToAdd; i++)
                sBuffer.append(" ");
            return sBuffer.substring(0);
        }
        else if (idStr.length() > 8)
        {
            return idStr.substring(0, 8);
        }
        else
            return idStr;
    }

    public String getPrice()
    {
        if (price.length() < 8)
        {
            int charsToAdd = 8 - price.length();
            StringBuffer sBuffer = new StringBuffer(price);
            for (int i = 0; i < charsToAdd; i++)
                sBuffer.append(" ");
            return sBuffer.substring(0);
        }
        else if (price.length() > 8)
        {
            return price.substring(0, 8);
        }
        else
            return price;
    }

    public String getProductName()
    {
        char[] charsArray = productName.toCharArray();

        if (charsArray.length < 30)
        {
            int charsToAdd = 30 - charsArray.length;
            StringBuffer sBuffer = new StringBuffer(productName);
            for (int i = 0; i < charsToAdd; i++)
                sBuffer.append(" ");
            return sBuffer.substring(0);
        }
        else if (charsArray.length > 30)
        {
            StringBuffer sBuffer = new StringBuffer(productName);
            return sBuffer.substring(0, 30);
        }
        else
            return productName;
    }

    public String getQuantity()
    {
        if (quantity.length() < 4)
        {
            int charsToAdd = 4 - quantity.length();
            StringBuffer sBuffer = new StringBuffer(quantity);
            for (int i = 0; i < charsToAdd; i++)
                sBuffer.append(" ");
            return sBuffer.substring(0);
        }
        else if (quantity.length() > 4)
        {
            return quantity.substring(0, 4);
        }
        else
            return quantity;
    }
}
