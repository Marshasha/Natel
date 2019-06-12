import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FramePhoto extends FrameModel {
	
	private JLabel labelPhotoGrand = new JLabel();
	
	public FramePhoto(){
		
		super();
		
		miseEnPlacePhoto();
					
	}
	
	/**
	 * 
	 * @param imagePath la variable reçu de la methode action(String imagePath)
	 * @param labelPhotoGrand la label pour afficher une photo
	 * @param imageIcon obtient String imagePath
	 * @param image obtient image qui se trouve dans imagePath
	 * 
	 */
	
	public void setPhoto(String imagePath){
		
		labelPhotoGrand.setVisible(false);
		
		ImageIcon imageIcon = new ImageIcon(imagePath);
		Image image = imageIcon.getImage();
		image = image.getScaledInstance(350, 450, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		
		labelPhotoGrand = new JLabel(imageIcon);
		labelPhotoGrand.setOpaque(true);
	    labelPhotoGrand.setBounds(20, 100, 350, 350);
	    panelInside.add(labelPhotoGrand);	   
	}
		
	
	public void miseEnPlacePhoto(){
		
		panelInside.setBackground(Color.CYAN);	        

	}

}