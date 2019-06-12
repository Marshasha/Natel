package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;



/**
 *
 * @author Marina Shashkova
 * {@code} FrameGallery montre les list des photos
 *  boolean flagFromGallery sert pour separer 2 actions:
 *  si l'entre dans FrameGallery est fait de FrameContactEdit
 *

 */

public class FrameGallery extends FrameModel implements PanelMulti {


    private ArrayList<GalleryImage> images;
    private Rectangle boundsGallery;
    private JScrollPane myScroll;

    private Font fontInfo = new Font("Verdana", Font.BOLD, 14);

    private String message;

    private JLabel labelInfo = new JLabel("Pour supprimer une photo, click doit sur l'image,");
    private JLabel labelInfo2 = new JLabel("puis click gauche sur l'image.");

    private JPanel panelInfo = new JPanel();



    public FrameGallery(){
        super();

        miseEnPlaceFG();
        addImagePanel();
        addListenerToImages();
    }

    /**
     * <p>La methode miseEnPlaceFg va adapter la miseEnPlace de FrameModel pour permettre
     *    d'ajouter le panelInfo et le label explicatif pour la suppression d'image</p>
     */

    public void miseEnPlaceFG(){

        panelInfo.setBackground(Color.BLACK);
        panelInfo.setBounds(26,755,401,80);
        panelInfo.setOpaque(true);
        panelInfo.setLayout(null);

        labelInfo.setBounds(0,0,401,40);
        labelInfo.setFont(fontInfo);
        labelInfo.setForeground(Color.cyan);
        labelInfo.setVisible(true);

        labelInfo2.setBounds(0,30,401,40);
        labelInfo2.setFont(fontInfo);
        labelInfo2.setForeground(Color.cyan);
        labelInfo2.setVisible(true);

        panelInfo.add(labelInfo);
        panelInfo.add(labelInfo2);

        panelInside.setBackground(Color.green);
        panelInside.setBounds(26,68,401,687);

        panelContenant.remove(imageVide);
        panelContenant.add(panelInfo);
        panelContenant.add(imageVide);

    }


    private void addImagePanel() {

        /*
         la creation de grid layout avec 3 columns
         */
        GridLayout grid = new GridLayout(0,3);

        /*
        la creation de new JPanel pour placer les images
        */
        JPanel galleryPanel = new JPanel();
        galleryPanel.setLayout(grid);
        galleryPanel.setBackground(Color.BLACK);


        /*
        la methode pour ajouter les images
         */
        addImagesIntoPanel(galleryPanel);

        /*
        la methode pour agir avec des images
         */
        addListenerToPanelInside(galleryPanel);
    }

    private void addImagesIntoPanel(JPanel galleryPanel){
        // recevoir des images de la class CheckGallery
        Object[] resultOfMethod = CheckGallery.getImageArray();
        if (resultOfMethod[0] instanceof ArrayList){
            this.images = (ArrayList)resultOfMethod[0];
        }
        if(resultOfMethod[1] instanceof String){
            this.message = (String)resultOfMethod[1];

        }


        /*
        si le tableau des image n'est pas null on ajoute des images
        et definir Bounds pour la panel
         */
        if (!images.isEmpty()) {

            /*
            on parcourt tous les Object GalleryImage jusqu'a la fin de notre ArrayList
             */
            for (GalleryImage img : images) {

                /*
                on ajoute que la label de l'objet GalleryImage sur galleryPanel
                 */
                galleryPanel.add(img.getLabel());

            }

            /*
            on dit que l'hauteur de notre panel est egal a nombre des photos
             */
            int height = images.size();


            /*
             apres on change le variable "hauteur" = nombre des image/3, et si nombre des image%3 n'est pas null,
             on ajoute 1 ligne de plus
             */
            height = (height % 3 == 0) ? height / 3 : (height / 3) + 1;



            /*
             la hauter d'une photo est definit comme 100 dans CheckGallery
             en plus on ajoute 1 à la taille 100, pour avoir une petite frontier entre les images
             */
            height = height*101;

            /*
            si notre taille des images et plus grand que la taille de panelInside (definit dans FrameModel)
            on etabli nouvelle
             */
            if (height > panelInside.getHeight()){
                this.boundsGallery =  new Rectangle(0, 0,
                        panelInside.getWidth(),
                        panelInside.getHeight());
            }else {
                this.boundsGallery = new Rectangle(0, 0, panelInside.getWidth(), height);
            }
        }


        /*
        la deuxième case du tableau de la methode CheckGallery.getImageArray
        donne le message. On affiche que le message "Memory is full" s'il y le cas
         */
        if(resultOfMethod[1]=="Memory is full"){
            JPanel message = addMessagePanel((String)resultOfMethod[1]);


            /*
             le placement de la Panel message au millieu
             */
            message.setBounds(0, (panelInside.getHeight())/3, boundsGallery.width, 80);
        }

    }



    /*
    creation d'un message si il y a plus des photo que MAX_PHOTOS
     */
    private JPanel addMessagePanel(String text){

        final JPanel message = new JPanel();
        JButton ok = new JButton("Ok");
        panelInside.add(message);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message.setVisible(false);
            }
        });

        message.add(new JTextArea(text));
        message.add(ok);
        return message;
    }

    /*
    la methode pour ajouter Scroll s'il y a plus des photos, que la taille d'ecran
     */

    private void addListenerToPanelInside(JPanel galleryPanel){

        galleryPanel.setAutoscrolls(true);

        this.myScroll = new JScrollPane(galleryPanel);

        myScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        if (boundsGallery != null){
            myScroll.setBounds(this.boundsGallery);
        }

        myScroll.setBorder(null);
        myScroll.setViewportBorder(null);

        panelInside.add(myScroll);

    }



    /*
    la methode pour supprimer la photo
     */
    private void deletePhoto(final GalleryImage image){
        final  JButton delete = new JButton("*");

        /*
        on ajoute le button "delete" sur l'image qu'on veux supprimer
         */
        delete.setBounds(91, 0, 40, 40);
        delete.setBackground(Color.CYAN);
        delete.setVisible(true);


        /*
        quand on click, le button apparait sur Label d'une photo
         */
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                delete.setVisible(false);

                image.getLabel().setVisible(false);

                for (GalleryImage im: images){
                    if(im.getPath() == image.getPath()){
                        images.remove(im);
                        break;
                    }
                }
                images.containsAll(images);
                resetImages();
            }
        });
        image.getLabel().add(delete);
        resetImages();
    }

    /*
     la methode pour reinitialiser le panel avec les images après la suppretion d'une photo
     il faut repeter l'initialisation de JScrollPane, parce que scroll s'adapte automatiqement
     par rapport de nombre des photos
     */

    private void resetImages() {
        JPanel galleryPanel = new JPanel();

        galleryPanel.setBounds(boundsGallery);
        galleryPanel.setBackground(Color.BLACK);
        galleryPanel.setLayout(new GridLayout(0,3));

        if (!images.isEmpty()) {
            for (GalleryImage img : images) {
                galleryPanel.add(img.getLabel());
            }

            int height = images.size();
            height = (height % 3 == 0) ? height / 3 : (height / 3) + 1;
            height = height*101;

            if (height > panelInside.getHeight()){
                this.boundsGallery =  new Rectangle(0, 0,
                        panelInside.getWidth(),
                        panelInside.getHeight());
            }else {
                this.boundsGallery = new Rectangle(0, 0, panelInside.getWidth(), height);
            }
            galleryPanel.setVisible(true);

            galleryPanel.setAutoscrolls(true);

            JScrollPane myScroll = new JScrollPane(galleryPanel);

            myScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


            if (boundsGallery != null){
                myScroll.setBounds(this.boundsGallery);
            }

            if (this.myScroll != null){
                this.myScroll.setVisible(false);
            }
            myScroll.setBorder(null);
            myScroll.setViewportBorder(null);

            this.myScroll = myScroll;
            this.myScroll.setVisible(true);

            panelInside.add(this.myScroll );
        }
    }

    private void addListenerToImages(){
        if (this.images != null){
            for (final GalleryImage img : this.images){
                img.getLabel().addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getModifiersEx() == 0) {
                            action(img.getPath());
                        }else{
                            deletePhoto(img);
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {}

                    @Override
                    public void mouseReleased(MouseEvent e) {}

                    @Override
                    public void mouseEntered(MouseEvent e) {}

                    @Override
                    public void mouseExited(MouseEvent e) {}
                });
            }
        }
    }

    private void action(String imagePath){
        if (fceCall==true){
            if(new File(imagePath).exists()){
                fg.setVisible(false);
                fce.setImage(imagePath);
                fce.setVisible(true);
            }
        }else{
            if(new File(imagePath).exists()){
                fph.setPhoto(imagePath);
                fph.setVisible(true);
            }
        }

    }

}


