package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameContacts extends FrameModel implements PanelMulti {


    //private FrameContactsEdit fce = new FrameContactsEdit();

    protected static JList jlistContact = new JList();

    protected JButton buttonNewCon = new JButton("Nouveau contact");
    protected JButton buttonEdiCon = new JButton("Editer");
    protected JButton buttonSupCon = new JButton("Supprimer");

    private JList listCon = new JList();
    private JScrollPane scrollList = new JScrollPane(listCon);

    protected JTextField textNom = new JTextField();
    protected JTextField textPrenom = new JTextField();
    protected JTextField textEmail = new JTextField();
    protected JTextField textNumTel = new JTextField();
    protected JTextField textAdresse = new JTextField();
    protected JTextField textNpa = new JTextField();


    private JLabel imageVideCon = new JLabel(new ImageIcon(getClass().getResource("/user.png")));

    protected JPanel panelList = new JPanel();
    protected JPanel panelImage = new JPanel();
    protected JPanel panelMenu = new JPanel();




    public FrameContacts(){

        super();

        miseEnPlaceCont();

        buttonNewCon.addActionListener(new ContactsEdit(1));




    }


    public void miseEnPlaceCont(){

        panelImage.setBackground(Color.CYAN);
        panelImage.setBounds(0,0,401,326);
        panelImage.setOpaque(true);
        panelImage.setLayout(null);

        panelImage.add(imageVideCon);
        imageVideCon.setBounds(140,60,128,128);


        scrollList.setBackground(Color.LIGHT_GRAY);
        scrollList.setBounds(0,0,402,400);
        scrollList.setOpaque(true);
        scrollList.setLayout(null);

        panelList.setBackground(Color.CYAN);
        panelList.setBounds(0,326,401,400);
        panelList.setOpaque(true);
        panelList.setLayout(null);
        panelList.add(scrollList);


        panelMenu.setBackground(Color.LIGHT_GRAY);
        panelMenu.setBounds(0,726,401,41);
        panelMenu.setOpaque(true);
        panelMenu.setLayout(null);

        panelMenu.add(buttonNewCon);
        panelMenu.add(buttonEdiCon);
        panelMenu.add(buttonSupCon);
        buttonNewCon.setBounds(0,0,140,40);
        buttonEdiCon.setBounds(141,0,121,40);
        buttonSupCon.setBounds(262,0,139,40);


        panelInside.add(panelList);
        panelInside.add(panelImage);
        panelInside.add(panelMenu);

    }




    class ContactsEdit implements ActionListener{


        int i = 0;
        public ContactsEdit(int indic){
            i = indic;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            fce.setVisible(true);

            int numJList = jlistContact.getSelectedIndex();
            if(numJList == -1){
                return;
            }
            jlistContact.setEnabled(false);
            setEditable(true);




        }

        public void setEditable(boolean val){
            textNom.setEditable(val);
            textPrenom.setEditable(val);
            textEmail.setEditable(val);
            textNumTel.setEditable(val);
            textAdresse.setEditable(val);
            textNpa.setEditable(val);

        }
    }


}
