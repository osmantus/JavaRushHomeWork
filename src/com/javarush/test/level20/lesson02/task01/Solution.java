package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            //File your_file_name = File.createTempFile("D:\\Work\\Java\\L20Les1T1\\sample.tmp", null);
            String your_file_name = "D:\\Work\\Java\\L20Les1T1\\sample.tmp";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            //OutputStream outputStream = null;
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);

            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            boolean isObjsNotEqual = false;
            if (ivanov != null && somePerson != null)
            {
                if (!ivanov.name.equals(somePerson.name))
                    isObjsNotEqual = true;
                if (ivanov.assets != null && somePerson.assets != null)
                {
                    if (ivanov.assets.size() != somePerson.assets.size())
                        isObjsNotEqual = true;
                    else
                    {
                        for (int i = 0; i < ivanov.assets.size(); i++)
                        {
                            if (!ivanov.assets.get(i).getName().equals(somePerson.assets.get(i).getName()))
                                isObjsNotEqual = true;
                            if (ivanov.assets.get(i).getPrice() != somePerson.assets.get(i).getPrice())
                                isObjsNotEqual = true;
                        }
                    }
                }
                else if ((ivanov.assets == null && somePerson.assets != null) || (ivanov.assets != null && somePerson.assets == null))
                {
                    isObjsNotEqual = true;
                }
            }
            else if ((ivanov == null && somePerson != null) || (ivanov != null && somePerson == null))
                isObjsNotEqual = true;

            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter saveFile = new PrintWriter(outputStream);

            if (!name.equals("") && assets != null)
            {
                saveFile.println("yes");
                saveFile.println(assets.size());
                saveFile.println(name);
                for (Asset eachAsset : assets)
                {
                    saveFile.println(eachAsset.getName());
                    saveFile.println(eachAsset.getPrice());
                }
                saveFile.flush();
            }
            else
            {
                saveFile.println("no");
                saveFile.flush();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader loadFile = new BufferedReader(new InputStreamReader(inputStream));
            String fileLine = loadFile.readLine();

            if (fileLine.equals("yes"))
            {
                int assetsSize = Integer.parseInt(loadFile.readLine());
                name = loadFile.readLine();
                if (assetsSize > 0)
                {
                    Asset asset = null;
                    for (int i = 1; i <= assetsSize; i++)
                    {
                        asset = new Asset(loadFile.readLine());
                        asset.setPrice(Double.parseDouble(loadFile.readLine()));
                        assets.add(asset);
                    }
                }
            }
        }
    }
}
