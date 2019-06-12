package com.company;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Luyet Thomas
 * <p>Cette classe est une application annexe dont le but est purement recreatif.
 * A la suite de quelques interactions par le biais de questions l'utilisateur se retrouve
 * face a un choix. S'il decide de trahir Daenerys Targaryen, cette derniere le condamnera
 * a mort et supprimera tous ses contacts par mesure de repression.
 * Valar Morgulis</p>
 */

public class Targaryen extends FrameContactsSource {


    private JButton buttonYes = new JButton("Yes");
    private JButton buttonNo = new JButton("No");
    private JButton buttonBetray = new JButton("Betray");

    private JPanel panelDany = new JPanel();



    protected Font fontQuestion = new Font("Verdana", Font.BOLD, 17);
    private Font fontloyal = new Font("Verdana", Font.BOLD, 15);
    private Font fontSentence = new Font("Verdana", Font.BOLD, 16);

    private File clap = new File("./src/main/ressources/Spoils.wav");


    private JLabel labelDany = new JLabel(new ImageIcon(getClass().getResource("/dany.jpg")));

    private JLabel labelquestion = new JLabel("Bend the knee for your queen ?");
    private JLabel labelLoyalty = new JLabel("I swear this: If you ever betray me,");
    private JLabel labelLoyalty2 = new JLabel( "I'll burn you alive.");

    private JLabel labelSentence = new JLabel("I Daenerys of House Targaryen,");
    private JLabel labelSentence2 = new JLabel("first of my name,");
    private JLabel labelSentence3 = new JLabel("Breaker of Chains,");
    private JLabel labelSentence4 = new JLabel("and Mother of Dragons,");
    private JLabel labelSentence5 = new JLabel("sentence you to die !");

    private int seconds;
    private int secondes;




    public Targaryen(){

        super();


        buttonYes.addActionListener(new Loyalty());
        buttonNo.addActionListener(new Treason());
        buttonBetray.addActionListener(new Treason());


        MiseEnPlace();


    }

    /**
     * <p>La methode MiseEnPlace() va permettre de determiner l'aspect graphique de la classe.</p>
     */

    public void MiseEnPlace(){

        panelInside.setBackground(Color.BLACK);


        panelDany.setBounds(0,100,401,470);
        panelDany.setOpaque(true);
        panelDany.setLayout(null);


        labelDany.setBackground(Color.black);
        labelDany.setBounds(0,0,401,470);
        labelDany.setOpaque(true);
        labelDany.setLayout(null);
        panelDany.add(labelDany);


        labelquestion.setBackground(Color.red);
        labelquestion.setBounds(50,550,300,40);
        labelquestion.setFont(fontQuestion);
        labelquestion.setForeground(Color.RED);


        labelLoyalty.setBounds(50,550,300,40);
        labelLoyalty.setFont(fontloyal);
        labelLoyalty.setForeground(Color.YELLOW);
        labelLoyalty.setVisible(false);

        labelLoyalty2.setBounds(50,600,300,40);
        labelLoyalty2.setFont(fontloyal);
        labelLoyalty2.setForeground(Color.YELLOW);
        labelLoyalty2.setVisible(false);

        labelSentence.setBounds(50,550,300,40);
        labelSentence.setFont(fontSentence);
        labelSentence.setForeground(Color.RED);
        labelSentence.setVisible(false);

        labelSentence2.setBounds(50,570,300,40);
        labelSentence2.setFont(fontSentence);
        labelSentence2.setForeground(Color.RED);
        labelSentence2.setVisible(false);

        labelSentence3.setBounds(50,590,300,40);
        labelSentence3.setFont(fontSentence);
        labelSentence3.setForeground(Color.RED);
        labelSentence3.setVisible(false);

        labelSentence4.setBounds(50,610,300,40);
        labelSentence4.setFont(fontSentence);
        labelSentence4.setForeground(Color.RED);
        labelSentence4.setVisible(false);

        labelSentence5.setBounds(50,630,300,40);
        labelSentence5.setFont(fontSentence);
        labelSentence5.setForeground(Color.RED);
        labelSentence5.setVisible(false);

        buttonYes.setBounds(130,650,60,40);
        buttonNo.setBounds(220,650,60,40);
        buttonBetray.setBounds(150,680,100,40);
        buttonBetray.setVisible(false);


        panelInside.add(labelLoyalty);
        panelInside.add(labelLoyalty2);
        panelInside.add(labelquestion);
        panelInside.add(labelSentence);
        panelInside.add(labelSentence2);
        panelInside.add(labelSentence3);
        panelInside.add(labelSentence4);
        panelInside.add(labelSentence5);
        panelInside.add(buttonBetray);
        panelInside.add(buttonYes);
        panelInside.add(buttonNo);
        panelInside.add(panelDany);


    }

    /**
     *
     * @param sound <p>La methode playSound va permettre de charger le fichier audio et
     *              de le jouer</p>
     */
    public static void playSound(File sound){


        try{


            /*
            On va récupérer le fichier audio puis le charger
             */
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));


            /*
            Lancement du fichier audio
             */
            clip.start();


            /*
            Le programme est mis en veille pendant la durée du fichier audio
            */
            Thread.sleep(clip.getMicrosecondLength()/1000);


        }catch (Exception e){
            System.out.println("Oups!");
        }

    }

    /**
     * <p>La classe interne va effectuer plusieurs taches a la suite.
     * Notemment retirer la JList de FrameContact pour faire croire
     * a l'utilisateur a la suppression des contacts. Neanmoins il n'en est rien. Un simple ajout
     * de contact va reafficher la liste a jour.
     * La classe comporte un timemr de quelques secondes qui permet a l'utilisateur de lire
     * la sentence que Daenerys prononce a son encontre.
     * Apres quoi Targaryen2 s'affiche.
     * </p>
     */

    class Treason implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            buttonNo.setVisible(false);
            buttonYes.setVisible(false);


            labelquestion.setVisible(false);
            buttonBetray.setVisible(false);
            labelLoyalty.setVisible(false);
            labelLoyalty2.setVisible(false);

            labelSentence.setVisible(true);
            labelSentence2.setVisible(true);
            labelSentence3.setVisible(true);
            labelSentence4.setVisible(true);
            labelSentence5.setVisible(true);



            /*
            A vrai dire on pourrait supprimer entièrement la liste des contacts
            Par commodité afin de ne pas avoir à tous les réécrire
            On va uniquement faire croire qu'ils ont été supprimés en masquant la liste
             */
            listModel.removeAllElements();

            jList.setSelectedIndex(0);

            /*
             Mise en place de Timers afin que le LayeredPane Tar2 puisse se lancer avant
             que commence le fichier audio. De cette façon, le visuel du dragon et du message
             accompagne le son, rendant le tout plus dramatique.

             Premier Timer de 3 secondes permettant a l'utilisateur de lire le nouveau
             message, soit la condamnation.
             */


            Timer timer=new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    secondes++;


                    if(secondes==3){
                        timer.cancel();
                        timer.purge();

                        tar2.setVisible(true);

                        /*
                        Lancement du deuxième Timer
                         */
                        countdown();

                        return;
                    }
                }
            };

            timer.scheduleAtFixedRate(task,1000,1000);

        }
    }

    /**
     * <p>La classe interne Loyalty va jouer avec differents panels dans le cadre des questions posees a
     * l'utilisateur</p>
     */

    class Loyalty implements ActionListener{


        /*
        Simple mise à jour du visuel
        */
        @Override
        public void actionPerformed(ActionEvent e) {

            labelquestion.setVisible(false);
            buttonYes.setVisible(false);
            buttonNo.setVisible(false);


            labelLoyalty.setVisible(true);
            labelLoyalty2.setVisible(true);
            buttonBetray.setVisible(true);

        }

    }

    /**
     * <p>La methode countdown() sert a declancher un bref timer
     *       Le programme attend 1 seconde avant de debuter l'audio
     *       Ce qui est suffisant pour activer le LayeredPane Tar2
     *       Sinon le son se lance alors que l'utilisateur est encore sur Tar
     *       puis à la fin de l'audio
     *       Tar2 s'ouvre.</p>
     *
     */

    public void countdown(){

        Timer timer=new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                seconds++;

                if(seconds==1){
                    timer.cancel();
                    timer.purge();

                    playSound(clap);


                    return;
                }
            }
        };

        timer.scheduleAtFixedRate(task,1000,1000);


    }

}
