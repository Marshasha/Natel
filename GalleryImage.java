package com.company;

import javax.swing.*;

/**
 * @author Marina Shashkova
 * <p>label est premier composant de l'Objet GalleryImage (photo) pour identifier son image
 *    est 2em composant de l'Objet GalleryImage pour identifier son nom</p>
 */


public class GalleryImage {

    private JLabel label;
    private String path;

    public GalleryImage(JLabel label, String path) {
        this.label = label;
        this.path = path;
    }

    public  JLabel getLabel() {
        return label;
    }

    public String getPath() {
        return path;
    }
}

