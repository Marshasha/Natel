package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class FrameContactsEdit extends FrameContacts implements PanelMulti {

    private static String nomFichier = new String("c:/temp/Contacts.txt");

    private static String[] listAffichageJList;
    private static String[] chaine;

    private ContactsValidator valide = new ContactsValidator();

    protected static ContactsData[] tabContactData;

    private JButton buttonRetour = new JButton("Retour");
    private JButton buttonEnregister = new JButton("Enregister");
    private JButton buttonVider = new JButton("Vider");


    private JLabel labelTitre = new JLabel("Veuillez entrer les données du contact :");

    private JLabel labelNom = new JLabel("Nom");
    private JLabel labelPrenom = new JLabel("Prénom");
    private JLabel labelEmail = new JLabel("Adresse email");
    private JLabel labelNumTel = new JLabel("Numéro de natel");
    private JLabel labelAdresse = new JLabel("Adresse");
    private JLabel labelNpa = new JLabel("NPA et Localité");
    private JLabel imagePhoto = new JLabel();

    private JPanel panelContEdit = new JPanel();

    private Font fontText = new Font("Verdana", Font.BOLD, 15);
    private Font fontInside = new Font("Verdana", Font.PLAIN, 10);





    public FrameContactsEdit() {

        super();

        miseEnPlaceCE();

        buttonRetour.addActionListener(new Fermeture());
        buttonEnregister.addActionListener(new Enregister());
        buttonVider.addActionListener(new ViderLesChamps());


    }

    public void miseEnPlaceCE() {

        panelImage.setBackground(Color.lightGray);

        buttonNewCon.setVisible(false);
        buttonRetour.setBounds(buttonNewCon.getBounds());
        panelMenu.add(buttonRetour);


        buttonEdiCon.setVisible(false);
        buttonEnregister.setBounds(buttonEdiCon.getBounds());
        panelMenu.add(buttonEnregister);

        buttonSupCon.setVisible(false);
        buttonVider.setBounds(buttonSupCon.getBounds());
        panelMenu.add(buttonVider);


        labelTitre.setBounds(0, 0, 401, 40);
        labelTitre.setForeground(Color.WHITE);
        labelTitre.setOpaque(true);
        labelTitre.setBackground(Color.BLACK);
        labelTitre.setFont(fontText);
        labelTitre.setHorizontalAlignment(SwingConstants.CENTER);

        labelNom.setBounds(0, 40, 401, 30);
        labelNom.setForeground(Color.WHITE);
        labelNom.setOpaque(true);
        labelNom.setBackground(Color.BLACK);
        labelNom.setFont(fontText);

        textNom.setBounds(0, 70, 401, 30);
        textNom.setForeground(Color.BLACK);
        textNom.setFont(fontText);

        labelPrenom.setBounds(0, 100, 401, 30);
        labelPrenom.setForeground(Color.WHITE);
        labelPrenom.setOpaque(true);
        labelPrenom.setBackground(Color.BLACK);
        labelPrenom.setFont(fontText);

        textPrenom.setBounds(0, 130, 401, 30);
        textPrenom.setForeground(Color.BLACK);
        textPrenom.setFont(fontText);

        labelEmail.setBounds(0, 160, 401, 30);
        labelEmail.setForeground(Color.WHITE);
        labelEmail.setOpaque(true);
        labelEmail.setBackground(Color.BLACK);
        labelEmail.setFont(fontText);

        textEmail.setBounds(0, 190, 401, 30);
        textEmail.setForeground(Color.BLACK);
        textEmail.setFont(fontText);

        labelNumTel.setBounds(0, 220, 401, 30);
        labelNumTel.setForeground(Color.WHITE);
        labelNumTel.setOpaque(true);
        labelNumTel.setBackground(Color.BLACK);
        labelNumTel.setFont(fontText);

        textNumTel.setBounds(0, 250, 401, 30);
        textNumTel.setForeground(Color.BLACK);
        textNumTel.setFont(fontText);

        labelAdresse.setBounds(0, 280, 401, 30);
        labelAdresse.setForeground(Color.WHITE);
        labelAdresse.setOpaque(true);
        labelAdresse.setBackground(Color.BLACK);
        labelAdresse.setFont(fontText);

        textAdresse.setBounds(0, 310, 401, 30);
        textAdresse.setForeground(Color.BLACK);
        textAdresse.setFont(fontText);

        labelNpa.setBounds(0, 340, 401, 30);
        labelNpa.setForeground(Color.WHITE);
        labelNpa.setOpaque(true);
        labelNpa.setBackground(Color.BLACK);
        labelNpa.setFont(fontText);

        textNpa.setBounds(0, 370, 401, 30);
        textNpa.setForeground(Color.BLACK);
        textNpa.setFont(fontText);

        panelList.setVisible(false);

        panelContEdit.setBounds(panelList.getBounds());
        panelContEdit.setBackground(Color.BLACK);
        panelContEdit.setOpaque(true);
        panelContEdit.setLayout(null);

        panelContEdit.add(labelTitre);

        panelContEdit.add(labelNom);
        panelContEdit.add(textNom);
        panelContEdit.add(labelPrenom);
        panelContEdit.add(textPrenom);
        panelContEdit.add(labelEmail);
        panelContEdit.add(textEmail);
        panelContEdit.add(labelNumTel);
        panelContEdit.add(textNumTel);
        panelContEdit.add(labelAdresse);
        panelContEdit.add(textAdresse);
        panelContEdit.add(labelNpa);
        panelContEdit.add(textNpa);

        panelInside.add(panelContEdit);


    }

    class ViderLesChamps implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            textNom.setText(null);
            textPrenom.setText(null);
            textEmail.setText(null);
            textNumTel.setText(null);
            textAdresse.setText(null);
            textNpa.setText(null);


        }
    }

    class Fermeture implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            fce.setVisible(false);

        }
    }

    class Enregister implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int valJList = jlistContact.getSelectedIndex();
            if (valideEmail(textEmail.getText())) {
                textEmail.setForeground(Color.BLACK);
                if (valideTel(textNumTel.getText())) {
                    textNumTel.setForeground(Color.BLACK);
                    addInChaine(valJList);
                    new ViderLesChamps();

                } else {
                    textNumTel.setForeground(Color.RED);
                }
            } else {
                textEmail.setForeground(Color.RED);
            }
        }
    }





    public boolean valideTel(String phone){

        boolean response;
        response = valide.validerTel(phone);

        return response;
    }

    public boolean valideEmail(String mail){

        boolean response;
        response = valide.validerEmail(mail);

        return response;
    }


    public void addInChaine(int numJList){
        String temp [] = new String[chaine.length+1];

        for(int i=0; i<chaine.length; i++){
            temp[i] = chaine[i];

        }
        // Creation du tableau temporaire avec les valeur à inscrire
        temp[chaine.length] = textNom.getText() + " - " + textPrenom.getText() + " - "
                + textEmail.getText() + " - " + textNumTel.getText() + " - "
                + textAdresse.getText() + " - " + textNpa.getText() ;
        chaine = new String [temp.length];
        chaine = temp;
        updateList();
    }

    public void LectureContact() {

        String ligne;
        try{
            BufferedReader br=new BufferedReader( new InputStreamReader( new FileInputStream(nomFichier)));
            int cptLengthChaine = 0;
            while ((br.readLine())!= null){
                cptLengthChaine++;
            }
            chaine = new String[cptLengthChaine];
            listAffichageJList = new String[chaine.length];
            tabContactData = new ContactsData[chaine.length];
            br.close();

        }catch (Exception e){
            System.out.println("Lecture fichier");
            System.out.println(e.toString());
        }

        try{
            int cpt = 0;
            BufferedReader br=new BufferedReader( new InputStreamReader( new FileInputStream(nomFichier)));

            while ((ligne=br.readLine())!=null ){
                chaine[cpt] = ligne ;
                cpt++;
            }
            br.close();
            updateList();
            jlistContact.setEnabled(true);
        }
        catch (Exception e){
            System.out.println("problème lecture fichier");
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    public static void updateList(){
        listAffichageJList = new String[chaine.length];
        tabContactData = new ContactsData[chaine.length];

        String[] tempo = new String[5];
        try {
            for (int i = 0; i<chaine.length; i++){
                if(chaine[i]!= null){

                    // On découpe chaque ligne du fichier en 5 partie distinctement séparée
                    tempo = chaine[i].split(" - ", 6);

                    // On crée un tableau de contact qui contiendra un objet contact avec les infos
                    tabContactData[i] = new ContactsData(tempo[0], tempo[1], tempo[2], tempo[3]
                            , tempo[4], tempo[5]);

                    // On crée le text d'affichage de la JList
                    listAffichageJList[i] = tempo[0] + " " + tempo[1];

                    if(chaine[i].contains("#deleted")){
                        listAffichageJList[i] = null;
                    }
                }
            }

            jlistContact.setListData(listAffichageJList);
            jlistContact.setEnabled(true);


            // A VOIR SI JE VEUX FERMER LE LAYERED OU PAS


        }catch (Exception e){
            System.out.println("Erreur lors de la mise a jour des informations");
            System.out.println(e.toString());
        }
    }


}
