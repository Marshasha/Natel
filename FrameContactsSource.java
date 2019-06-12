package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertNull;


/**
 * @author Luyet Thomas
 * <p>La classe FrameContactsSource est la classe abstraite qui contient les principales donnees servant a la serialisation.
 * C'est la classe Mere pour FrameContacts et FrameContactsEdit</p>
 *
 */
public abstract class FrameContactsSource extends FrameModel {

    protected JPanel panelImage = new JPanel();

    protected String imagePath = "./src/main/ressources/user.png";

    protected JLabel labelPhoto = new JLabel(new ImageIcon(imagePath));

    protected static final int MAXCONTACTS = 4;

    protected static int newContacts = 0;
    protected static int actualContacts = 0;
    protected static int position;

    protected Exception ex = null;

    protected static JTextField textNom = new JTextField();
    protected static JTextField textPrenom = new JTextField();
    protected static JTextField textEmail = new JTextField();
    protected static JTextField textNumTel = new JTextField();
    protected static JTextField textAdresse = new JTextField();
    protected static JTextField textNpa = new JTextField();

    protected static JList<String> jList;
    protected static DefaultListModel<String> listModel = new DefaultListModel<>();
    protected static ArrayList<ContactsData> listData = new ArrayList<ContactsData>();
    protected static ArrayList<ContactsData>listDataDisk=new ArrayList<ContactsData>();

    protected static ObjectMapper obMap = new ObjectMapper();
    protected static String myFile = "./src/main/ressources/contact.json";
    protected static File file = new File(myFile);


    /**
     * <p>Dans le Constructeur de FrameContatsSource on va generer un fichier .json qui aura une forme
     * de type listaData si lors du lancement de l'application cette derniere n'existe pas/est vide.</p>
     */

    public FrameContactsSource() {

        super();

        miseEnPlaceSource();

        if (listData == null) {

            try {
                obMap.writeValue(file, listData);


                listDataDisk = obMap.readValue(file,
                        obMap.getTypeFactory().constructCollectionType(ArrayList.class, ContactsData.class));


            } catch (Exception e) {
                ex = e;
            }
            assertNull(ex);

        }

        buttonHome.addActionListener(new BackHomeMenu());
    }

    /**
     * <p>La methode miseEnPlaceSource() va mettre en place des elements graphiques
     *    commun a FrameContacts et FrameContactsEdit</p>
     */
    public void miseEnPlaceSource() {


        panelImage.setBackground(Color.lightGray);
        panelImage.setBounds(0, 0, 401, 326);
        panelImage.setOpaque(true);
        panelImage.setLayout(null);


        panelImage.add(labelPhoto);
        labelPhoto.setBounds(0, 0, 400, 325);

    }


    /**
     * <p>La saisie d'un nouveau contact
     *    On va recuperer toutes les donnees necessaires
     *    Les serialiser
     *    Retirer l'ancienne JList
     *    Charger la nouvelle pour la mise a jour</p>
     */

    public void saisieConctact() {

        String nom = textNom.getText();
        String prenom = textPrenom.getText();
        String email = textEmail.getText();
        String numTel = textNumTel.getText();
        String adresse = textAdresse.getText();
        String npa = textNpa.getText();


        String image = imagePath;

        listDataDisk.add(new ContactsData(nom, prenom, email, numTel, adresse, npa, image));


        contactAEnregister();

        listModel.removeAllElements();

        chargerListeNom();


    }

    /**
     * <p>La methode resetChamp() va definir tous les champs de text comme vide
     *    et redefinir la photo de contact par celle par defaut.</p>
     */

    public void resetChamp() {

        /*
        On definit les champs comme vide
         */

        textNom.setText(null);
        textPrenom.setText(null);
        textEmail.setText(null);
        textNumTel.setText(null);
        textAdresse.setText(null);
        textNpa.setText(null);

        imagePath="./src/main/ressources/user.png";
        labelPhoto.setIcon(new ImageIcon(imagePath));
        panelImage.repaint();


    }


    /**
     * <p>La classe qui permet de tout vider et preparer pour les suivants. On fait appel a la
     * methode resetChamp()</p>
     */

    class ViderLesChamps implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {


            resetChamp();

        }
    }

    /**
     * <p>La methode chargerListeNom va charger dans la liste uniquement
     * nom + prenom comme reference</p>
     */
    public void chargerListeNom() {


        try {
            listDataDisk = obMap.readValue(file,
                    obMap.getTypeFactory().constructCollectionType(ArrayList.class, ContactsData.class));

            for (int i = 0; i < listDataDisk.size(); i++) {


                listModel.addElement(listDataDisk.get(i).NameInfoAsString());

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * <p>La methode qui va charger la nouvelle liste de contact depuis le fichier de .json</p>
     */

    public void contactAEnregister() {

        Exception ex = null;

        try {

            obMap.writeValue(file, listDataDisk);


        } catch (Exception e1) {
            ex = e1;
        }
        assertNull(ex);

    }

    /**
     * <p>La Classe BackHomeMenu de FrameContactsSource
     *    redefinit la Classe BackHomeMenu de FrameModel
     *    de maniere a pouvoir lui rajouter la methode viderDesChamps();
     *    Ainsi en quittant par le biais de ce bouton l'edition ou l'ajout d'un nouveau contact
     *    on efface les champs et la photo qui auraient pu etre modifier pour remettre tout a zero.</p>
     */

    class BackHomeMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            setVisible(false);
            resetChamp();

        }
    }


}
