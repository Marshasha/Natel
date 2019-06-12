package com.company;



import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Marina Shashkova
 */

class CheckGallery {


    private static final int MAX_PHOTOS = 100;
    static int imagesCount = 0;

    /**
     * la creation d'une Gallery
     * @return le tableau de 2 Objets resultOfMethod
     * <p>resultOfMethod[0]=(Object)images; le tableau des image
     *    resultOfMethod[1] =(Object)resultOfCheck; le message, si le nombre des image est plus que MAX_PHOTOS</p>
     */

    public static Object [] getImageArray() {

        Object [] resultOfMethod = new Object [2];
        String resultOfCheck = "Ok";

        ArrayList<GalleryImage> images = new ArrayList<>();

        /**
         * File gallery = new File("./Gallery");
         * on montre la chemin vers le repertoire où il y a des photos
         */


        File gallery = new File("./Gallery");

        /**
         * on controle si le repertoire existe et si il y a des photos
         */


        if (gallery.exists() && gallery.listFiles() != null) {

            for (File fileImage : Objects.requireNonNull(gallery.listFiles())){

                /**
                 * Objects.requireNonNull(gallery.listFiles()))
                 * la boucle jusqu'à la dernier photo
                 */

                imagesCount++;
                if(imagesCount > MAX_PHOTOS){
                    resultOfCheck = "Memory is full";
                    resultOfMethod[0] = (Object)images;
                    resultOfMethod[1] = (Object)resultOfCheck;

                    return resultOfMethod;

                }

                ImageIcon icon = new ImageIcon(fileImage.getAbsolutePath());
                /**
                 * on trouve le String du chemin
                 * on demande retourner l'image de ce chemin
                 */

                Image iconImage = icon.getImage();

                /**
                 * on donne la taille pour l'affichage de l'image
                 */
                iconImage = iconImage.getScaledInstance(131,100,Image.SCALE_SMOOTH);

                /**
                 * on mit notre image cadré dans JLabel
                 */

                icon = new ImageIcon(iconImage);

                JLabel img = new JLabel(icon);

                /**
                 * on rampli notre ArrayList avec des Objet GalleryImage,
                 * où le premier composant est JLabel, et 2-m String nom
                 */


                images.add(new GalleryImage(img, fileImage.getAbsolutePath()));

            }
        }

        resultOfMethod[0]=(Object)images;
        resultOfMethod[1]=(Object)resultOfCheck;

        return resultOfMethod;
    }

}

