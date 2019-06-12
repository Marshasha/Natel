package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Luyet Thomas
 * <p>La Classe FrameMenu est la Frame de base. C'est elle qui va permettre l'acces a
 *    l'ensemble des autres classes par le biais de layeredPane.</p>
 *
 */

public class FrameMenu extends JFrame implements PanelMulti {

    private CardLayout cardL = new CardLayout();

        //Pour chaque element supplementaire que l'on veut pour l'horloge
    private Clock dateLable = new Clock("date");
    private Clock timeLable = new Clock("time");
    private Clock dayLable = new Clock("day");


    private JButton buttonContacts = new JButton(new ImageIcon(getClass().getResource("/contacts.png")));
    private JButton buttonGallery = new JButton(new ImageIcon(getClass().getResource("/gallery.png")));
    private JButton buttonJeu = new JButton(new ImageIcon(getClass().getResource("/Targaryen2.png")));
    private JButton buttonCalcul = new JButton(new ImageIcon(getClass().getResource("/calculation.png")));

        //Il s'agit de l'image de fond du natel avec inscrusté à l'intérieur le papier peint
    private JLabel imageFondEcran = new JLabel(new ImageIcon(getClass().getResource("/natel.jpg")));


    private JLayeredPane layeredPane = new JLayeredPane();



    public FrameMenu(){


        super("Le Natel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        miseEnPlace();

        /*
        On definit les bouttons et leur action
        Pour cette configuration on utilisera un seul ActionListener
        qui agira selon l'indice du bouton
         */

        buttonContacts.addActionListener(new ChoixMenu(1));
        buttonGallery.addActionListener(new ChoixMenu(2));
        buttonCalcul.addActionListener(new ChoixMenu(3));
        buttonJeu.addActionListener(new ChoixMenu(4));


    }


    /**
     * <p>Avec la methode miseEnPlace, on va preparer l'ensemble de l'affichage de la Frame
     * On va notemment generer l'aspect graphique de FrameMenu mais aussi la gestion des
     * layeredPane que l'on va ouvrir par le biais de JButton</p>
     */

    public void miseEnPlace(){


        /*
        Ici les informations de base afin de preparer le layeredPane
         */
        Dimension verti = new Dimension(470,975);
        setSize(verti);
        setLayout(cardL);
        add(layeredPane,BorderLayout.CENTER);

        layeredPane.setBounds(0, 0, 450, 945);

        /*
        mise en place panel Principal
         */
        panelPrincipal.setBackground(Color.white);
        panelPrincipal.setBounds(0,0,450,945);
        panelPrincipal.setOpaque(true);
        panelPrincipal.setLayout(null);


        imageFondEcran.setBounds(0,0,450,945);

        buttonContacts.setBounds(60,750,70,70 );
        buttonGallery.setBounds(150,750,70,70);
        buttonCalcul.setBounds(240,750,70,70);

        buttonJeu.setBounds(330,750,70,70);

        dateLable.setBounds(145,250,200,200);
        timeLable.setBounds(145,300,200,200);
        dayLable.setBounds(145,350,200,200);

        panelPrincipal.add(buttonContacts);
        panelPrincipal.add(buttonGallery);
        panelPrincipal.add(buttonJeu);
        panelPrincipal.add(buttonCalcul);

        panelPrincipal.add(dateLable);
        panelPrincipal.add(dayLable);
        panelPrincipal.add(timeLable);

        panelPrincipal.add(imageFondEcran);

        /*
        Tres important la definition des differents layeredPane
        De base à l'exception de la FrameMenu, les autres sont tous invisibles
        Ils seront appeles et donc rendus visible au besoin.
        */

        layeredPane.add(panelPrincipal,new Integer(0),0);

        fc.setVisible(false);
        layeredPane.add(fc,new Integer(1),0);

        fg.setVisible(false);
        layeredPane.add(fg, new Integer(2),0);

        fce.setVisible(false);
        layeredPane.add(fce, new Integer(3),0);

        cal.setVisible(false);
        layeredPane.add(cal,new Integer(4),0);

        tar.setVisible(false);
        layeredPane.add(tar,new Integer(5),0);

        tar2.setVisible(false);
        layeredPane.add(tar2,new Integer(6),0);

        fph.setVisible(false);
        layeredPane.add(fph, new Integer(7), 0);


    }


    /**
     * <p>La classe interne ChoixMenu va nous permettre de partir selon le choix effectuer
     * dans telle ou telle application.</p>
     */

    class ChoixMenu implements ActionListener {


        int i = 0;
        public ChoixMenu(int indic){
            i = indic;
        }

        /**
         *
         * @param e <p>On va recuperer l'indice du bouton pour pouvoir l'utiliser dans un switch
         *      *     et de ce fait determiner quel JPanel ouvrir avec un LayeredPane</p>
         */

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (i){

                case 1: fc.setVisible(true);
                        break;

                case 2: fg.setVisible(true);
                        break;

                case 3: cal.setVisible(true);
                        break;

                case 4: tar.setVisible(true);
                        break;

                default: return;
            }

        }
    }
}
