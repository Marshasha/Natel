package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMenu extends JFrame implements PanelMulti {


    //private FrameContacts fc= new FrameContacts();
    //private FrameGallery fg= new FrameGallery();

    private Clock dateLable = new Clock("date");
    private Clock timeLable = new Clock("time");
    private Clock dayLable = new Clock("day");


    private JButton buttonContacts = new JButton(new ImageIcon(getClass().getResource("/contacts.png")));
    private JButton buttonGallery = new JButton(new ImageIcon(getClass().getResource("/gallery.png")));
    private JButton buttonBloc = new JButton(new ImageIcon(getClass().getResource("/notepad.png")));
    private JButton buttonJeu = new JButton(new ImageIcon(getClass().getResource("/Targaryen2.png")));

    private JLabel imageFondEcran = new JLabel(new ImageIcon(getClass().getResource("/natel.jpg")));

    //private JPanel panelPrincipal = new JPanel();

    //protected String []listContent = {"Menu","Contacts","Gallery"};

    private CardLayout cardL = new CardLayout();
    private JLayeredPane layeredPane = new JLayeredPane();



    public FrameMenu(){

        super("Le Natel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        miseEnPlace();

        buttonContacts.addActionListener(new ChoixMenu(1));
        buttonGallery.addActionListener(new ChoixMenu(2));







        //setResizable(false);


        // ne pas toucher !!!
        // setBounds(15,43,398,819);



    }


    public void miseEnPlace(){

        Dimension verti = new Dimension(470,975);
        setSize(verti);
        setLayout(cardL);
        add(layeredPane,BorderLayout.CENTER);

        layeredPane.setBounds(0, 0, 450, 945);


        //mise en place panel Principal
        panelPrincipal.setBackground(Color.white);
        panelPrincipal.setBounds(0,0,450,945);
        panelPrincipal.setOpaque(true);
        panelPrincipal.setLayout(null);


        imageFondEcran.setBounds(0,0,450,945);
        buttonContacts.setBounds(60,750,70,70 );
        buttonGallery.setBounds(150,750,70,70);
        buttonBloc.setBounds(240,750,70,70);
        buttonJeu.setBounds(330,750,70,70);

        dateLable.setBounds(145,250,200,200);
        timeLable.setBounds(145,300,200,200);
        dayLable.setBounds(145,350,200,200);


        panelPrincipal.add(buttonContacts);
        panelPrincipal.add(buttonGallery);
        panelPrincipal.add(buttonBloc);
        panelPrincipal.add(buttonJeu);

        panelPrincipal.add(dateLable);
        panelPrincipal.add(dayLable);
        panelPrincipal.add(timeLable);

        panelPrincipal.add(imageFondEcran);



        layeredPane.add(panelPrincipal,new Integer(0),0);

        fc.setVisible(false);
        layeredPane.add(fc,new Integer(1),0);

        fg.setVisible(false);
        layeredPane.add(fg, new Integer(2),0);

        fce.setVisible(false);
        layeredPane.add(fce, new Integer(3),0);


        /*
        Dimension verti = new Dimension(470,975);
        setSize(verti);

        //buttonCo.setBounds(25, 610, 90, 90);
        imageFondEcran.setBounds(0, 0, 450, 945);

        //insideBlack.setBounds(15,62,420,822);


         */


    }





    class ChoixMenu implements ActionListener {

        int i = 0;
        public ChoixMenu(int indic){
            i = indic;
        }


        @Override
        public void actionPerformed(ActionEvent e) {

            switch (i){

                case 1: fc.setVisible(true);
                        break;
                case 2: fg.setVisible(true);
                        break;

                default: return;
            }





            //add(new FrameInside());

        }
    }
}
