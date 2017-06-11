package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.*;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

/**
 * Created by Alex on 10.01.2017.
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        HHStrategy hhStrategy = new HHStrategy();
        MoikrugStrategy moikrugStrategy = new MoikrugStrategy();

        Provider provider = new Provider(hhStrategy);
        Provider provider2 = new Provider(moikrugStrategy);
        Provider[] providers = new Provider[]{provider, provider2};

        HtmlView view = new HtmlView();
        Model model = new Model(view, provider2);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
