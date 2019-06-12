package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Luyet Thomas
 * <p>FrameModel est une classe abstraite qui va servir de model pour l'aspect graphique de la plupart
 * des classes. FrameModel apporte un bouton retour en arrière universel</p>
 */
public abstract class FrameModel extends JPanel implements PanelMulti{


    protected static JButton buttonEnregistrer = new JButton("Enregistrer");
    protected static JButton buttonAjouter = new JButton("Ajouter");
    protected static boolean fceCall = false;

    protected JButton buttonHome = new JButton(new ImageIcon(getClass().getResource("/home.png")));

    protected CardLayout cardL = new CardLayout();

    protected Font fontText = new Font("Verdana", Font.BOLD, 15);

    protected JLabel imageVide = new JLabel (new ImageIcon(getClass().getResource("/natelBlack.jpg")));


    protected JPanel panelContenant = new JPanel();
    protected JPanel panelInside = new JPanel();
    protected JPanel panelBackHome = new JPanel();


    public FrameModel() {


        super();

        miseEnPlace();

        buttonHome.addActionListener(new BackHomeMenu());

    }


    /**
     * <p>La methode MiseEnPlace va servir a generer l'aspect graphique d'un panel de base</p>
     */
    public void miseEnPlace() {


        Dimension verti = new Dimension(470, 975);
        setSize(verti);
        setLayout(cardL);



        /*
        mise en place panel Contenant
         */
        panelContenant.setBackground(Color.white);
        panelContenant.setBounds(0, 0, 450, 945);
        panelContenant.setOpaque(true);
        panelContenant.setLayout(null);
        imageVide.setBounds(0, 0, 450, 945);



        /*
        mise en place panel inside
         */
        panelInside.setBackground(Color.BLACK);
        panelInside.setBounds(26, 68, 401, 767);
        panelInside.setOpaque(true);
        panelInside.setLayout(null);


        /*
        mise en place panel backHome
         */
        panelBackHome.setBackground(Color.BLACK);
        panelBackHome.setBounds(26, 835, 401, 44);
        panelBackHome.setOpaque(true);
        panelBackHome.setLayout(null);

        buttonHome.setBounds(185, 8, 30, 30);
        panelBackHome.add(buttonHome);

        panelContenant.add(panelBackHome);
        panelContenant.add(panelInside);
        panelContenant.add(imageVide);

        add(panelContenant);
    }

    /**
     * <p>La classe interne BackHomeMenu va permettre de faire un retour en arriere.
     * Concretement l'application va fermer le layeredPane en cours et l'on va se retrouver avec
     * le dernier layeredPane utilise auparavant</p>
     */

    class BackHomeMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            fceCall=false;
            setVisible(false);

        }
    }

}
