package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



/**
 * @author Luyet Thomas
 * <p> La classe FrameContacts va nous servir a gerer l'ajout, la modification et la suppression
 *   des contacts. Contrairement a ce que son nom pourrait nous faire penser il ne s'agit
 *   pas d'une Frame proprement dite mais d'une classe de type Panel.
 *   Ayant utilise le systeme de LayeredPane comme layout j'ai neanmoins decide de garder
 *   l'appellation Frame pour certaines des classes principales.</p>
 */


public class FrameContacts extends FrameContactsSource {


    protected JButton buttonNewCon = new JButton("Nouveau contact");
    protected JButton buttonEdiCon = new JButton("Editer");
    protected JButton buttonSupCon = new JButton("Supprimer");

    private JLabel labelMaxContact = new JLabel("Maximum de contact atteint!");

    protected JPanel panelList = new JPanel();
    protected JPanel panelMenu = new JPanel();

    private JScrollPane scrollPane;



    public FrameContacts() {

        super();

        chargerListeNom();
        miseEnPlaceContact();

        buttonNewCon.addActionListener(new NouveauContact());
        buttonEdiCon.addActionListener(new EditerContact());
        buttonSupCon.addActionListener(new SupprimerContact());


        /**
         * <p>Va permettre de reagir au clic sur le contact dans la JList pour
         *    afficher l'image</p>
         */
        jList.addMouseListener(new PhotoContacts());

    }

    /**
     * <p> La methode miseEnPlaceCont va nous permettre de gerer toute la partie graphique
     *     de la classe.</p>
     */
    public void miseEnPlaceContact()  {


        panelList.setBackground(Color.WHITE);
        panelList.setBounds(0, 326, 401, 400);
        panelList.setOpaque(true);
        panelList.setLayout(null);

        jList=new JList<>(listModel);

        scrollPane=new JScrollPane(jList);
        scrollPane.setBackground(Color.YELLOW);
        scrollPane.setBounds(0,0,401,400);
        scrollPane.setOpaque(true);

        jList.setSelectedIndex(0);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setSelectionBackground(Color.GREEN);
        jList.setSelectionForeground(Color.RED);
        jList.setFont(fontText);

        labelMaxContact.setBounds(90,350,240,30);
        labelMaxContact.setBackground(Color.YELLOW);
        labelMaxContact.setForeground(Color.RED);
        labelMaxContact.setFont(fontText);
        labelMaxContact.setOpaque(true);
        labelMaxContact.setLayout(null);
        labelMaxContact.setVisible(false);

        panelList.add(labelMaxContact);
        panelList.add(scrollPane);

        panelMenu.setBackground(Color.LIGHT_GRAY);
        panelMenu.setBounds(0, 726, 401, 41);
        panelMenu.setOpaque(true);
        panelMenu.setLayout(null);
        panelMenu.add(buttonNewCon);
        panelMenu.add(buttonEdiCon);
        panelMenu.add(buttonSupCon);

        buttonNewCon.setBounds(0, 0, 140, 40);
        buttonEdiCon.setBounds(141, 0, 121, 40);
        buttonSupCon.setBounds(262, 0, 139, 40);

        panelInside.add(panelList);
        panelInside.add(panelImage);
        panelInside.add(panelMenu);

    }


    /**
     * <p>Avec la classe NouveauContact on va ouvrir FrameContactEdit et pouvoir ajouter un nouveau contact.
     *      Avant d'activer le bouton on va controler que la limite de contact n'est pas deja atteinte.
     *      Si c'est le cas on ne pourra tout simplement pas ouvrir FrameContactEdit et un message d'information
     *      s'affichera.</p>
     */
    class NouveauContact implements ActionListener {


        /**
         *
         * @param e <p>Lors de l'action du actionListener, on va dans un premier temps controler si le
         *                     nombre de contact maximum a ete atteint. Si c'est le cas, l'action ne sera pas effectuee.
         *
         *                     Cela va generer une exception qui aura comme unique fonction de faire afficher
         *                     une label d'information à l'utilisateur.
         *                     Il est à noter qu'une version alternative sans exception a également ete concue.
         *                     Elle a été conservee dans le code et peut remplacer au besoin la version exception.</p>
         */
        @Override
        public void actionPerformed(ActionEvent e)  {


            try {
                checkContacts();
            }
            catch (Exception ce){

                ce.getMessage();
            }


            /*
            Version alternative sans exception

            actualContacts=listDataDisk.size();
            newContacts=1;


            if (newContacts<=(MAXCONTACTS-actualContacts)) {

                FrameContactsEdit.buttonAjouter.setVisible(true);

                fce.setVisible(true);

                FrameContactsEdit.buttonEnregistrer.setVisible(false);

                labelMaxContact.setVisible(false);

            }

            else{
                labelMaxContact.setVisible(true);
            }
           */






    }


        /**
         * <p>Il s'agit de la methode de test du maximum de contacts avec une gestion
         *    par le biais d'exception.</p>
         *
         * @throws Exception
         */
    public void checkContacts() throws Exception  {



        try{
                actualContacts=listDataDisk.size();
                newContacts=1;

                if ( newContacts<=(MAXCONTACTS-actualContacts)) {

                    FrameContactsEdit.buttonAjouter.setVisible(true);

                    fce.setVisible(true);
                    FrameContactsEdit.buttonEnregistrer.setVisible(false);

                    return;

                }
                else{

                    throw new ContactsLimitException("Limite atteinte");

                }

            }
            catch (ContactsLimitException e){
                e.getMessage();
            }

        }



        /**
         * <p>La classe interne ContactsLimitException qui gere l'exception liee au depassement du nombre de contacts
         *    autorise.</p>
         */
    class ContactsLimitException extends Exception{

            public ContactsLimitException(String message){

                super(message);
                labelMaxContact.setVisible(true);

                /*
                    Potentiellement on pourrait afficher le message d'erreur
                    System.out.println(message);
                 */


            }
        }
    }

    /**
     * <p>La Classe interne EditerContact va recuperer selon le choix effectue dans la
     *       JList toutes les informations relatives aux contacts et les afficher dans les champs
     *       des TextField afin de pouvoir les modifier.
     *       Afin que l'utilisateur ne soit pas trouble pour comment editer la photo,
     *       nous avons decide de laisser l'image par defaut du contact.
     *
     *       Afin que l'utilisateur ne puisse pas utiliser le bouton ajouter qui est reserve
     *       a l'ajout de contacts existant, ce bouton sera rendu invisible et le bouton enregistrer
     *       sera rendu visible.</p>
     *
     */

    class EditerContact implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

                //On va determiner quel est le contact qui doit être modifier
            int select = jList.getSelectedIndex();

            if (select>=0) {

                position = jList.getSelectedIndex();

                FrameContactsEdit.buttonEnregistrer.setVisible(true);

                fce.setVisible(true);

                    //On charge dans les champs les differentes donnees du contact a modifier

                textNom.setText(listDataDisk.get(position).getNom());
                textPrenom.setText(listDataDisk.get(position).getPrenom());
                textEmail.setText(listDataDisk.get(position).getEmail());
                textNumTel.setText(listDataDisk.get(position).getNumTel());
                textAdresse.setText(listDataDisk.get(position).getAdresse());
                textNpa.setText(listDataDisk.get(position).getNpa());


                    //On retire le bouton ajouter pour eviter des conflicts entre editer et nouveau contact
                FrameContactsEdit.buttonAjouter.setVisible(false);


            }
        }

    }

    /**
     * <p>La classe interne SupprimerContact va permettre de supprimer un contact de la liste
     *      et du fichier de serialisation.</p>
     *
     */
    class SupprimerContact implements ActionListener {


        /**
         *
         * @param e <p>L'action de suppression va effectuer une serie de taches.
         *                     1. On retire de listDataDisk l'element selectionner.
         *                     2. On enregistre pour que l'information soit mise a jour dans le fichier.
         *                     3. On charge la nouvelle liste de nom de contact dans la JList
         *                     4. On redefinit le contact preselectionne de base.</p>
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            /*
            On retire de la liste l'objet selectionne et on sauvegarde
            */
            listDataDisk.remove(jList.getSelectedIndex());
			contactAEnregister();


            /*
            On retire tout les elements de la liste des contacts
            */
            listModel.removeAllElements();


            /*
            On charge les contacts a jour dans la liste.
             */
			chargerListeNom();

            /*
            On definit la preselection sur le premier contact
             */
			jList.setSelectedIndex(0);
        }

    }



    /**
     * <p>La classe interne PhotoContacts va permettre de determiner selon le contact selectionne/clique
     *      la photo de contact a afficher dans le panel se trouvant au dessus des contacts.
     *
     *      Dans le cas ou l'animation de Targaryen est effectuee. Il faut desactiver
     *      l'action du mouseClicked car la JList etant masquee par Targaryen, si l'utilisateur
     *      clique dans le vide cela va generer des exceptions.
     *
     *      Il est a noter qu'une version avec gestion d'une exception personnalisee a ete envisagee.
     *      Cette version inactive a ete conservee.</p>
     *
     */

    class PhotoContacts extends MouseAdapter {

        public void mouseClicked(MouseEvent e) throws OutOfBound{


                if(jList.getSelectedIndex()<0){
                    /*
                    alternative :
                    throw new OutOfBound("Essaie même pas ils sont tous morts!");
                     */
                    return;
                }

                position = jList.getSelectedIndex();

                imagePath = (listDataDisk.get(position).getImage());

                /*
                Ces deux petites lignes, j'ai passé un jour et demi de ma vie à les trouver!
                Variante :
                labelPhoto.setIcon(new javax.swing.ImageIcon(imagePath));
                 */
                labelPhoto.setIcon(new ImageIcon(imagePath));
                panelImage.repaint();

        }

    }


}








