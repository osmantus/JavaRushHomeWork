package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alex on 10.01.2017.
 */
public interface Strategy
{
    List<Vacancy> getVacancies(String searchString);
}
