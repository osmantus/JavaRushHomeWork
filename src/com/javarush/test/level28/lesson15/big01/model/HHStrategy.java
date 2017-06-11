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
 * Created by Alex on 10.01.2017.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancies = new ArrayList<>();
        int pageIndex = 0;

        try
        {
            while (true)
            {
                Document document = getDocument(searchString, pageIndex);
                Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.isEmpty()) break;

                for (Element element : elements)
                {
                    Vacancy vacancy = new Vacancy();

                    vacancy.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                    vacancy.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());

                    vacancy.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));

                    vacancy.setSiteName("http://hh.ua");

                    boolean hasSalary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").hasText();
                    if (hasSalary)
                        vacancy.setSalary(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
                    else
                        vacancy.setSalary("");

                    vacancies.add(vacancy);
                }
                pageIndex++;
            }
        }
        catch (IOException ignored)
        {}

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, URLEncoder.encode(searchString, "UTF-8"), page);
        Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").referrer("").timeout(5000).get();
        return doc;
    }
}
