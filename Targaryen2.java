package com.company;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author Luyet Thomas
 *<p>La classe Targaryen2 est la deuxieme partie de l'application Targaryen.
 *   Dans cette classe, on va uniquement jouer l'audio et afficher un gif de dragon
 *   ainsi que les flames provenant de la classe Fire.</p>
 */

public class Targaryen2 extends FrameModel {


    private JPanel panelFeu = new JPanel();
    private JPanel panelDany = new JPanel();

    private JLabel labelDrogo = new JLabel(new ImageIcon(getClass().getResource("/tenor.gif")));

    private Font fontDeath = new Font("Verdana", Font.BOLD, 18);


    private JLabel labelDeath = new JLabel("All of your contacts");
    private JLabel labelDeath2 = new JLabel("have been destroyed.");



    private Fire feu = new Fire();


    public Targaryen2() {

        super();


        MiseEnPlace();

    }

    /**
     * <p>La methode MisenEnPlace() va servir uniquement a gerer l'aspect graphique de la classe.</p>
     */

    public void MiseEnPlace() {

        panelInside.setBackground(Color.RED);

        panelFeu.setBounds(0, 470, 401, 300);
        panelFeu.setOpaque(false);
        panelFeu.setLayout(null);

        panelFeu.setBackground(Color.yellow);

        panelFeu.add(feu);
        feu.setBounds(0, 0, 401, 600);
        panelFeu.setVisible(true);


        panelDany.setBounds(0, 0, 401, 470);
        panelDany.setOpaque(true);
        panelDany.setLayout(null);

        panelDany.setBackground(Color.BLACK);
        labelDrogo.setBackground(Color.BLACK);
        labelDrogo.setBounds(0, 0, 401, 470);
        labelDrogo.setOpaque(false);
        labelDrogo.setLayout(null);
        labelDrogo.setVisible(true);


        labelDeath.setBackground(Color.BLACK);
        labelDeath.setForeground(Color.YELLOW);
        labelDeath.setBounds(90,350,300,40);
        labelDeath.setOpaque(true);
        labelDeath.setLayout(null);
        labelDeath.setVisible(true);
        labelDeath.setFont(fontDeath);

        labelDeath2.setBackground(Color.BLACK);
        labelDeath2.setForeground(Color.YELLOW);
        labelDeath2.setBounds(90,400,300,40);
        labelDeath2.setOpaque(true);
        labelDeath2.setLayout(null);
        labelDeath2.setVisible(true);
        labelDeath2.setFont(fontDeath);


        panelDany.add(labelDeath);
        panelDany.add(labelDeath2);
        panelDany.add(labelDrogo);

        panelInside.add(panelDany);
        panelInside.add(panelFeu);

    }

    /**
     *
     * @param sound <p>La methode playSound() va ouvrir un fichier audio et le jouer
     *              pour la duree du morceau.</p>
     */

    public static void playSound(File sound) {

        try {

            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.wait(5000);
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 1000);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}