package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem {

        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode()
        {
            String searchStr = customer.getCountryName();
            String foundKey = null;
            if (countries.containsValue(searchStr))
            {
                for (Map.Entry<String,String> eachItem : countries.entrySet())
                {
                    if (eachItem.getValue().equals(searchStr))
                    {
                        foundKey = eachItem.getKey();
                        break;
                    }
                }
                return foundKey;
            }
            else
                return null;
        }

        @Override
        public String getCompany()
        {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            if (contact.getName().contains(", "))
            {
                String[] strArray = contact.getName().split(", ");
                return strArray[1].trim();
            }
            else
                return null;
        }

        @Override
        public String getContactLastName()
        {
            if (contact.getName().contains(", "))
            {
                String[] strArray = contact.getName().split(", ");
                return strArray[0].trim();
            }
            else
                return null;
        }

        @Override
        public String getDialString()
        {
            String convertedStr = contact.getPhoneNumber();
            if (convertedStr.contains("(") && convertedStr.contains(")") && convertedStr.contains("-"))
            {
                convertedStr = convertedStr.replace("(", "");
                convertedStr = convertedStr.replace(")", "");
                convertedStr = convertedStr.replace("-", "");

                return "callto://" + convertedStr;
            }
            else
                return contact.getPhoneNumber();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}