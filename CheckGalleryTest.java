package com.company;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CheckGalleryTest {

    @Test
    public void test() {

        Object [] images = CheckGallery.getImageArray();


        ArrayList<GalleryImage> list = (ArrayList)images[0];
        int nombre = list.size();

        String s = (String)images[1];

        System.out.println(images);
        System.out.println(CheckGallery.imagesCount);
        System.out.println(s);


        assertTrue(nombre==CheckGallery.imagesCount);

    }

}
