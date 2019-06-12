package com.company;


import javax.swing.*;


/**
 * @author Luyet Thomas
 * <p>Cette classe de type interface va etre utilisee dans un seul but partager
 * les instances des differents classes qui permettent d'afficher soit la Frame de base
 * soit des panels.
 * Cela afin de faire fonctionner le systeme de layout layeredPane.
 * C'est une vision novatrice et inabituelle de l'interface tel qu'on la connait
 * neanmoins cela fonctionne a merveille.
 * Il est essentiel de rajouter chaque nouvelle classe de type JPanel que l'on souhaite utiliser
 * dans le cadre du layeredPane</p>
 */

public interface PanelMulti {


    /*
    C'est le layeredPanel de base 0
     */
    JPanel panelPrincipal = new JPanel();

    /*
    C'est le layeredPanel 1
     */
    FrameContacts fc = new FrameContacts();

    /*
    C'est le layeredPanel 2
     */
    FrameGallery fg= new FrameGallery();

    /*
    C'est le layeredPanel 3
     */
    FrameContactsEdit fce = new FrameContactsEdit();

    /*
    C'est le layeredPanel 4
     */
    Calculatrice cal = new Calculatrice();

    /*
    C'est le layeredPanel 5
     */
    Targaryen tar  = new Targaryen();

    /*
    C'est le layeredPanel 6
    */
    Targaryen2 tar2 = new Targaryen2();

    /*
    C'est le layeredPanel 7
     */
    FramePhoto fph = new FramePhoto();


}
