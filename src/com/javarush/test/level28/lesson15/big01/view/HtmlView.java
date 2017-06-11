package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

/**
 * Created by Alex on 13.01.2017.
 */
public class HtmlView implements View
{
    private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace(".", "/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies)
    {
        try
        {
            updateFile(getUpdatedFileContent(vacancies));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod()
    {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies)
    {
        try
        {
            Document doc = getDocument();

            Elements elementsTemplate = doc.getElementsByAttributeValueContaining("class", "template");
            if (!elementsTemplate.isEmpty())
            {
                Element element = elementsTemplate.first();
                Element templateVacancyCopyBlock = element.clone();
                templateVacancyCopyBlock.removeAttr("style");
                templateVacancyCopyBlock.removeClass("template");

                /*Elements elementsVacancy = doc.getElementsByClass("vacancy");

                Element eachElement, nextElement;

                eachElement = elementsVacancy.first();
                while (eachElement != null)
                {
                    if (!eachElement.hasClass("vacancy template"))
                    {
                        nextElement = eachElement.nextElementSibling();
                        eachElement.remove();
                        elementsVacancy.remove(eachElement);
                        eachElement = nextElement;
                    }
                    else
                        eachElement = eachElement.nextElementSibling();
                }*/

                doc.getElementsByAttributeValue("class", "vacancy").remove();

                for (Vacancy vacancy : vacancies)
                {
                    Element newVacancyBlock = templateVacancyCopyBlock.clone();

                    element = newVacancyBlock.getElementsByClass("city").first();
                    element.append(vacancy.getCity());
                    element = newVacancyBlock.getElementsByClass("companyName").first();
                    element.append(vacancy.getCompanyName());
                    element = newVacancyBlock.getElementsByClass("salary").first();
                    element.append(vacancy.getSalary());

                    element = newVacancyBlock.getElementsByClass("title").select("a").first();
                    element.append(vacancy.getTitle());
                    element.attr("href", vacancy.getUrl());

                    elementsTemplate.first().before(newVacancyBlock.outerHtml());
                }
            }

            return doc.html();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "Some exception occurred";
        }
    }

    private void updateFile(String htmlContent)
    {
        try
        {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write(htmlContent);
            bufferedWriter.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException
    {
        File currentDirFile = new File(filePath);
        Document doc = Jsoup.parse(currentDirFile, "UTF-8");
        return doc;
    }
}
