package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 14.01.2017.
 */
public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%s&q=java+%s";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancies = new ArrayList<>();
        int pageIndex = 1;

        try
        {
            while (true)
            {
                Document document = getDocument(searchString, pageIndex);

                Elements elements = document.getElementsByAttributeValue("id", "jobs_list");
                if (elements.isEmpty()) break;
                if (elements.first().getElementsByClass("info").isEmpty())
                    break;

                Element classElement;
                Element linkUrlElement;

                Elements testElements = null;
                boolean hasLocationClass = false;
                boolean isSetAnyField = false;

                for (Element elementsList : elements)
                {
                    if (elementsList.getElementsByClass("info").isEmpty())
                        continue;
                    for (Element element : elementsList.getElementsByClass("info"))
                    {
                        Vacancy vacancy = new Vacancy();
                        vacancy.setCity("");
                        vacancy.setCompanyName("");
                        vacancy.setTitle("");
                        vacancy.setUrl("");
                        vacancy.setSiteName("");
                        vacancy.setSalary("");

                        testElements = element.getElementsByClass("meta");
                        if (!testElements.isEmpty())
                        {
                            classElement = element.getElementsByClass("meta").first();
                            testElements = classElement.getElementsByClass("location");
                            if (!testElements.isEmpty())
                            {
                                hasLocationClass = classElement.getElementsByClass("location").first().hasText();
                                if (hasLocationClass)
                                    vacancy.setCity(classElement.getElementsByTag("a").first().text());
                                isSetAnyField = true;
                            }
                        }

                        testElements = element.getElementsByClass("company_name");
                        if (!testElements.isEmpty())
                        {
                            classElement = element.getElementsByClass("company_name").first();
                            testElements = classElement.getElementsByTag("a");
                            if (!testElements.isEmpty())
                            {
                                linkUrlElement = testElements.first();
                                vacancy.setCompanyName(linkUrlElement.text());
                                isSetAnyField = true;
                            }
                        }

                        testElements = element.getElementsByClass("title");
                        if (!testElements.isEmpty())
                        {
                            classElement = element.getElementsByClass("title").first();
                            testElements = classElement.getElementsByAttribute("title");
                            if (!testElements.isEmpty())
                            {
                                vacancy.setTitle(classElement.getElementsByAttribute("title").first().text());
                                isSetAnyField = true;
                            }

                            testElements = classElement.getElementsByTag("a");
                            if (!testElements.isEmpty())
                            {
                                linkUrlElement = classElement.getElementsByTag("a").first();
                                vacancy.setUrl("https://moikrug.ru" + linkUrlElement.attr("href"));
                                isSetAnyField = true;
                            }
                        }

                        //vacancy.setSiteName("https://moikrug.ru");

                        testElements = element.getElementsByClass("salary");
                        if (!testElements.isEmpty())
                        {
                            classElement = element.getElementsByClass("salary").first();
                            boolean hasSalary = classElement.hasText();
                            if (hasSalary)
                            {
                                testElements = classElement.getElementsByClass("count");
                                if (!testElements.isEmpty())
                                {
                                    classElement = classElement.getElementsByClass("count").first();
                                    vacancy.setSalary(classElement.text());
                                    isSetAnyField = true;
                                }
                            } else
                            {
                                vacancy.setSalary("");
                                isSetAnyField = true;
                            }
                        }

                        if (isSetAnyField)
                        {
                            vacancy.setSiteName("https://moikrug.ru");
                            vacancies.add(vacancy);
                            isSetAnyField = false;
                        }
                    }
                }

                pageIndex++;
            }
        }
        catch (IOException e)
        {}

        return vacancies;
    }


    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, page, URLEncoder.encode(searchString, "UTF-8"));
        Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").referrer("").get();
        return doc;
    }
}
