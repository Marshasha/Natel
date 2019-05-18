package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameModel extends JPanel {

    private JButton buttonHome = new JButton(new ImageIcon(getClass().getResource("/home.png")));

    private JLabel imageVide = new JLabel (new ImageIcon(getClass().getResource("/natelBlack.jpg")));

    protected JPanel panelContenant = new JPanel();
    protected JPanel panelInside = new JPanel();
    protected JPanel panelBackHome = new JPanel();

    private CardLayout cardL = new CardLayout();

    public FrameModel() {

        miseEnPlace();

        buttonHome.addActionListener(new BackHomeMenu());

    }

    public void miseEnPlace() {

        Dimension verti = new Dimension(470, 975);
        setSize(verti);
        setLayout(cardL);



        //mise en place panel Contenant
        panelContenant.setBackground(Color.white);
        panelContenant.setBounds(0, 0, 450, 945);
        panelContenant.setOpaque(true);

        panelContenant.setLayout(null);
        imageVide.setBounds(0, 0, 450, 945);


        //mise en place panel inside
        panelInside.setBackground(Color.CYAN);
        panelInside.setBounds(26, 68, 401, 767);

        panelInside.setOpaque(true);

        panelInside.setLayout(null);


        //mise en place panel backHome
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

    class BackHomeMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        setVisible(false);

        }
    }

}
