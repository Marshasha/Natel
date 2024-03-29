



import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.ActionListener;

import java.rmi.activation.ActivationInstantiator;



public class FrameContactsEdit extends FrameContacts implements PanelMulti {

	private String imagePath = "user.png";

    private JButton buttonRetour = new JButton("Retour");

    private JButton buttonEnregister = new JButton("Enregister");

    private JButton buttonVider = new JButton("Vider");





    private JLabel labelTitre = new JLabel("Veuillez entrer les donn�es du contact :");



    private JLabel labelNom = new JLabel("Nom");

    private JLabel labelPrenom = new JLabel("Pr�nom");

    private JLabel labelEmail = new JLabel("Adresse email");

    private JLabel labelNumTel = new JLabel("Num�ro de natel");

    private JLabel labelAdresse = new JLabel("Adresse");

    private JLabel labelNpa = new JLabel("NPA et Localit�");

    private JLabel imagePhoto = new JLabel(new ImageIcon(imagePath));



    private JTextField textNom = new JTextField();

    private JTextField textPrenom = new JTextField();

    private JTextField textEmail = new JTextField();

    private JTextField textNumTel = new JTextField();

    private JTextField textAdresse = new JTextField();

    private JTextField textNpa = new JTextField();



    private Font fontText = new Font("Verdana", Font.BOLD, 15);

    private Font fontInside = new Font("Verdana", Font.PLAIN, 10);



    public FrameContactsEdit(){



        super();



        miseEnPlaceCE();



        buttonRetour.addActionListener(new Fermeture());

        buttonVider.addActionListener(new ViderLesChamps());
        
        imagePhoto.addMouseListener(new ChoixPhoto());





/*

        buttonNewCon.addActionListener(new Fermeture());

        buttonEdiCon.addActionListener(new Fermeture());





        getButtonNewCon().setText("Retour");

        getButtonNewCon().addActionListener(new Fermeture());



        buttonNewCon.setText("Retour");



        buttonSupCon.addActionListener(new ViderLesChamps());

        buttonSupCon.setText("Vider");



 */



    }



    public void miseEnPlaceCE (){



        panelImage.setBackground(Color.RED);
        imagePhoto.setBackground(Color.orange);
        imagePhoto.setBounds(10,10, 300, 400);
        panelImage.add(imagePhoto);



        getButtonNewCon().setVisible(false);

        buttonRetour.setBounds(getButtonNewCon().getBounds());

        panelMenu.add(buttonRetour);





        buttonEdiCon.setVisible(false);

        buttonEnregister.setBounds(buttonEdiCon.getBounds());

        panelMenu.add(buttonEnregister);



        buttonSupCon.setVisible(false);

        buttonVider.setBounds(buttonSupCon.getBounds());

        panelMenu.add(buttonVider);





        labelTitre.setBounds(0,0,401,40);

        labelTitre.setForeground(Color.WHITE);

        labelTitre.setOpaque(true);

        labelTitre.setBackground(Color.BLACK);

        labelTitre.setFont(fontText);

        labelTitre.setHorizontalAlignment(SwingConstants.CENTER);



        labelNom.setBounds(0,40,401,30);

        labelNom.setForeground(Color.WHITE);

        labelNom.setOpaque(true);

        labelNom.setBackground(Color.BLACK);

        labelNom.setFont(fontText);



        textNom.setBounds(0,70,401,30);

        textNom.setForeground(Color.BLACK);

        textNom.setFont(fontText);



        labelPrenom.setBounds(0,100,401,30);

        labelPrenom.setForeground(Color.WHITE);

        labelPrenom.setOpaque(true);

        labelPrenom.setBackground(Color.BLACK);

        labelPrenom.setFont(fontText);



        textPrenom.setBounds(0,130,401,30);

        textPrenom.setForeground(Color.BLACK);

        textPrenom.setFont(fontText);



        labelEmail.setBounds(0,160,401,30);

        labelEmail.setForeground(Color.WHITE);

        labelEmail.setOpaque(true);

        labelEmail.setBackground(Color.BLACK);

        labelEmail.setFont(fontText);



        textEmail.setBounds(0,190,401,30);

        textEmail.setForeground(Color.BLACK);

        textEmail.setFont(fontText);



        labelNumTel.setBounds(0,220,401,30);

        labelNumTel.setForeground(Color.WHITE);

        labelNumTel.setOpaque(true);

        labelNumTel.setBackground(Color.BLACK);

        labelNumTel.setFont(fontText);



        textNumTel.setBounds(0,250,401,30);

        textNumTel.setForeground(Color.BLACK);

        textNumTel.setFont(fontText);



        labelAdresse.setBounds(0,280,401,30);

        labelAdresse.setForeground(Color.WHITE);

        labelAdresse.setOpaque(true);

        labelAdresse.setBackground(Color.BLACK);

        labelAdresse.setFont(fontText);



        textAdresse.setBounds(0,310,401,30);

        textAdresse.setForeground(Color.BLACK);

        textAdresse.setFont(fontText);



        labelNpa.setBounds(0,340,401,30);

        labelNpa.setForeground(Color.WHITE);

        labelNpa.setOpaque(true);

        labelNpa.setBackground(Color.BLACK);

        labelNpa.setFont(fontText);



        textNpa.setBounds(0,370,401,30);

        textNpa.setForeground(Color.BLACK);

        textNpa.setFont(fontText);





        panelList.add(labelTitre);



        panelList.add(labelNom);

        panelList.add(textNom);

        panelList.add(labelPrenom);

        panelList.add(textPrenom);

        panelList.add(labelEmail);

        panelList.add(textEmail);

        panelList.add(labelNumTel);

        panelList.add(textNumTel);

        panelList.add(labelAdresse);

        panelList.add(textAdresse);

        panelList.add(labelNpa);

        panelList.add(textNpa);







    }

    public void setImage(String imgPath){
    	this.imagePath=imgPath;
    	
    	Rectangle bound = new Rectangle(0, 0, 401, 326);
    	
    	ImageIcon imgIcon = new ImageIcon(imgPath);
    	Image img = imgIcon.getImage();
    	img = img.getScaledInstance(bound.width, bound.height, Image.SCALE_SMOOTH);
    	imgIcon = new ImageIcon(img);
    	
    	imagePhoto.setVisible(false);
    	
    	imagePhoto = new JLabel(imgIcon);
    	imagePhoto.addMouseListener(new ChoixPhoto());
    	imagePhoto.setBounds(bound);
    	imagePhoto.setVisible(true);
    	panelImage.add(imagePhoto);
    	
    	
    }

    class ViderLesChamps implements ActionListener{


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

    class Fermeture implements ActionListener{


        @Override

        public void actionPerformed(ActionEvent e) {

            fce.setVisible(false);


        }

    }

    class ChoixPhoto implements MouseListener{
    	@Override
		public void mouseClicked(MouseEvent arg0) {
    		fce.setVisible(false);
    		fg.setFlag(true);
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





}