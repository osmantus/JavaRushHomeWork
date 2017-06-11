package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            /*File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);*/

            String your_file_name = "D:\\Work\\Java\\L20Les1T2\\sample.tmp";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User someUser = new User();
            someUser.setFirstName("First Name");
            someUser.setLastName("Last Name");
            someUser.setBirthDate(new Date());
            someUser.setMale(true);
            someUser.setCountry(User.Country.UKRAINE);
            javaRush.users.add(someUser);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

            if (outputStream != null)
            {
                PrintWriter saveFile = new PrintWriter(outputStream);

                if (saveFile != null)
                {
                    if (users != null)
                    {
                        User user = null;
                        Calendar calendar = null;
                        Date date = null;
                        String dateStr = null;

                        for (int i = 0; i < users.size(); i++)
                        {
                            user = users.get(i);

                            saveFile.println(user.getFirstName());
                            saveFile.println(user.getLastName());

                            date = user.getBirthDate();
                            saveFile.println(date.getTime());

                            if (user.isMale())
                                saveFile.println("true");
                            else
                                saveFile.println("false");

                            saveFile.println(user.getCountry().getDisplayedName());
                        }

                        saveFile.flush();
                    }
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод

            if (inputStream != null)
            {
                BufferedReader loadFile = new BufferedReader(new InputStreamReader(inputStream));

                if (loadFile != null)
                {
                    while (loadFile.ready())
                    {
                        String fileLine = null;

                        User user = new User();

                        String isMaleStr = null;
                        String country = null;

                        user.setFirstName(loadFile.readLine());
                        user.setLastName(loadFile.readLine());

                        fileLine = loadFile.readLine();

                        Date date = new Date();
                        date.setTime(Long.parseLong(fileLine));
                        user.setBirthDate(date);

                        isMaleStr = loadFile.readLine();
                        if (isMaleStr.equals("true"))
                            user.setMale(true);
                        else
                            user.setMale(false);

                        country = loadFile.readLine();
                        if (country.equals("Ukraine"))
                            user.setCountry(User.Country.UKRAINE);
                        else if (country.equals("Russia"))
                            user.setCountry(User.Country.RUSSIA);
                        else
                            user.setCountry(User.Country.OTHER);

                        users.add(user);
                    }
                }
            }
        }
    }
}
