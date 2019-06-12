package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



/**
 * @author Luyet Thomas
 * <p>La classe FrameContactsEdit est la classe qui va etre utilisee pour l'ajout de nouveaux contacts
 *   et egalement la modification de contacts existant.
 *
 *   Contrairement a ce que son nom pourrait nous faire penser il ne s'agit
 *   pas d'une Frame proprement dite mais d'une classe de type Panel.
 *   Ayant utilise le systeme de LayeredPane comme layout j'ai neanmoins decide de garder
 *   l'appellation Frame pour certaines des classes principales.</p>
 */

public class FrameContactsEdit extends FrameContactsSource {



    private JButton buttonVider = new JButton("Vider");

    private ContactsValidator valide = new ContactsValidator();

    private JLabel labelTitre = new JLabel("Cliquez sur l'image pour la changer");
    private JLabel labelNom = new JLabel("Nom");
    private JLabel labelPrenom = new JLabel("Prénom");
    private JLabel labelEmail = new JLabel("Adresse email");
    private JLabel labelNumTel = new JLabel("Numéro de natel");
    private JLabel labelAdresse = new JLabel("Adresse");
    private JLabel labelNpa = new JLabel("NPA et Localité");

    private JPanel panelContEdit = new JPanel();
    private JPanel panelMenu = new JPanel();




    public FrameContactsEdit() {

        super();

        miseEnPlaceContEdit();

        buttonEnregistrer.addActionListener(new Enregistrer());
        buttonAjouter.addActionListener(new Ajouter());
        buttonVider.addActionListener(new ViderLesChamps());
        labelPhoto.addMouseListener(new ChoixPhoto());

    }




    /**
     * <p>La methode miseEnPlaceCont va nous permettre de gerer toute la partie graphique
     *      de la classe.</p>
     *
     */
    public void miseEnPlaceContEdit() {


        panelMenu.setBackground(Color.BLACK);
        panelMenu.setBounds(0, 726, 401, 41);
        panelMenu.setOpaque(true);
        panelMenu.setLayout(null);


        panelMenu.add(buttonEnregistrer);
        panelMenu.add(buttonAjouter);
        panelMenu.add(buttonVider);

        buttonEnregistrer.setBounds(0, 0, 140, 40);
        buttonAjouter.setBounds(141, 0, 121, 40);
        buttonVider.setBounds(262, 0, 139, 40);

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

        panelContEdit.setBounds(0, 326, 401, 400);
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
        panelInside.add(panelImage);
        panelInside.add(panelMenu);

    }


    /**
     * <p> Le boolean va checker si le tel a la bonne forme</p>
     * @param phone
     * @return true or false
     */

    public boolean valideTel(String phone){


        boolean response;
        response = valide.validerTel(phone);

        return response;
    }

    /**
     * <p>Le boolean va checker si le mail a la bonne forme</p>
     * @param mail
     * @return true or false
     */

    public boolean valideEmail(String mail){

        boolean response;
        response = valide.validerEmail(mail);

        return response;
    }



    /**
     * <p>La classe interne Ajouter va verifier plusieurs points.
     *      1.Les controles de criteres de saisie sont effectues avant d'ajouter un contact
     *      En cas de non respect, l'erreur sera inscrite en rouge et aucun contact ajoute
     *      2. Si tout est bon on serialise les elements a la fin de la fonction saisieContacts()
     *      3. On vide les champs pour le prochain ajout
     *      4. On reactive le bouton Enregistrer qui est volontairement inactif pour eviter des confusions
     *      5. On determine le premier contact de la liste comme preselectionne</p>
     *
     */

    public boolean champsOk(){

        if (valideEmail(textEmail.getText())) {
            textEmail.setForeground(Color.BLACK);
            if (valideTel(textNumTel.getText())) {
                textNumTel.setForeground(Color.BLACK);



            } else {
                textNumTel.setForeground(Color.RED);
                return false;
            }
        } else {
            textEmail.setForeground(Color.RED);
            return false;
        }


        return true;
    }
    class Ajouter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (champsOk()==true){

                saisieConctact();
                resetChamp();
                buttonEnregistrer.setVisible(true);

                fce.setVisible(false);
                FrameContacts.jList.setSelectedIndex(0);
            }

        }

    }


    /**
     * <p>La class Enregistrer est celle qui s'occuppe d'enregistrer dans listaDataDisk
     *      les modifications liees à chaque contact.
     *      Un check va etre effectuer sur la validiter du mail et du tel car l'utilisateur
     *      comme pour l'ajout d'un nouveau contact.
     *
     *      Plusieurs actions sont necessaires pour reinitialiser le programme apres l'enregistrement.
     *      1. Retirer tous les elements de listeModel
     *      2. Charger les nouveaux noms de la liste de contacts. Ils ont potentiellement changer d'appelation.
     *      3. Vider les champs de maniere a ce qu'il ne reste pas avec les info du dernier contact edite ou ajoute.
     *      4. Definir le contact preselectionne de base.</p>
     *
     */
    class Enregistrer implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            if(champsOk()==true){

                listDataDisk.set(position,new ContactsData(textNom.getText(),
                        textPrenom.getText(),textEmail.getText(),textNumTel.getText(),
                        textAdresse.getText(),textNpa.getText(),imagePath));

                contactAEnregister();

                listModel.removeAllElements();

                chargerListeNom();

                resetChamp();

                fce.setVisible(false);
                buttonAjouter.setVisible(true);

                FrameContacts.jList.setSelectedIndex(0);


            }

        }
    }


    class ChoixPhoto implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent arg0) {

            fceCall=true;

            fce.setVisible(false);
            fg.setVisible(true);

        }

        @Override
        public void mouseEntered(MouseEvent arg0) {

        }

        @Override
        public void mouseExited(MouseEvent arg0) {

        }

        @Override
        public void mousePressed(MouseEvent arg0) {

        }

        @Override
        public void mouseReleased(MouseEvent arg0) {

        }
    }

    /**
     * @author Marina Shashkova
     * @param imgPath <p>Cette methode recoit la String imagePath
     *                grace a elle obtient l'image de la galerie puis l'adapte l'image
     *                par rapport a la taille des images de GalleryImage</p>
     */

    public void setImage(String imgPath) {
        this.imagePath = imgPath;

        Rectangle bound = new Rectangle(0, 0, 401, 326);

        ImageIcon imgIcon = new ImageIcon(imgPath);
        Image img = imgIcon.getImage();
        img = img.getScaledInstance(bound.width, bound.height, Image.SCALE_SMOOTH);
        imgIcon = new ImageIcon(img);

        labelPhoto.setVisible(false);

        labelPhoto = new JLabel(imgIcon);
        labelPhoto.addMouseListener(new ChoixPhoto());
        labelPhoto.setBounds(bound);
        labelPhoto.setVisible(true);
        panelImage.add(labelPhoto);
    }

}
