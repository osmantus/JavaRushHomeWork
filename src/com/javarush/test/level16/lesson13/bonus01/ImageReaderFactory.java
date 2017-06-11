package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Alex on 26.06.2016.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes anImageType)
    {
        if (anImageType == ImageTypes.BMP)
            return new BmpReader();
        else if (anImageType == ImageTypes.JPG)
            return new JpgReader();
        else if (anImageType == ImageTypes.PNG)
            return new PngReader();
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
