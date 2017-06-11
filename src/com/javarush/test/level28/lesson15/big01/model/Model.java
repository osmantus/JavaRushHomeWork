package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;
import com.javarush.test.level28.lesson15.big01.view.View;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by Alex on 13.01.2017.
 */
public class Model
{
    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers)
    {
        if (view == null)
            throw new IllegalArgumentException();
        if (providers == null)
            throw new IllegalArgumentException();
        else
        {
            if (providers.length == 0)
                throw new IllegalArgumentException();
        }

        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city)
    {
        List<Vacancy> vacancies = null;
        for (Provider eachProvider : providers)
        {
            if (vacancies == null)
                vacancies = eachProvider.getJavaVacancies(city);
            else
                vacancies.addAll(eachProvider.getJavaVacancies(city));
        }

        if (vacancies != null)
        {
            view.update(vacancies);
        }
    }
}
