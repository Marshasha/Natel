package com.company;


import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Marina Shashkova
 * <p>La classe FramePhoto sert a afficher en grand les photos de gallery</p>
 */

public class FramePhoto extends FrameModel {

    private JLabel labelPhotoGrand = new JLabel();

    private File filePhoto;



    public FramePhoto(){

        super();

        miseEnPlacePhoto();


    }

    /**
     *
     * <p>imagePath la variable reçu de la methode action(String imagePath)
     *    labelPhotoGrand la label pour afficher une photo
     *    imageIcon obtient String imagePath
     *    image obtient image qui se trouve dans imagePath</p>
     *
     */

    public void setPhoto(String imagePath){

        labelPhotoGrand.setVisible(false);

        filePhoto = new File(imagePath);

        filePhoto.getAbsolutePath();

        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(400, 450, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);

        labelPhotoGrand = new JLabel(imageIcon);
        labelPhotoGrand.setOpaque(true);
        labelPhotoGrand.setBounds(0, 200, 402, 350);
        panelInside.add(labelPhotoGrand);


    }


    public void miseEnPlacePhoto(){

        panelInside.setBackground(Color.BLACK);

    }


}