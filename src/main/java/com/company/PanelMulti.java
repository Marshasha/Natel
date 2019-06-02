import javax.swing.*;



public interface PanelMulti {





    //C'est le layeredPanel de base 0

    JPanel panelPrincipal = new JPanel();



    //C'est le layeredPanel 1

    FrameContacts fc = new FrameContacts();



    //C'est le layeredPanel 2

    FrameGallery fg= new FrameGallery();



    //C'est le layeredPanel 3

    FrameContactsEdit fce = new FrameContactsEdit();
    
    FramePhoto fph = new FramePhoto();
    



}