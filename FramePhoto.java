import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FramePhoto extends FrameModel {
	
	private JLabel labelPhoto = new JLabel();
	
	/*
	private JButton next = new JButton(">");
	private JButton previous = new JButton("<");
	*/
	
	private JButton back = new JButton("back to Gallery");
	private JButton delete = new JButton("delete");

	
	public FramePhoto(){
		
		super();
		
		miseEnPlacePhoto();
					
	}
	
	public void setPhoto(String imagePath){
		
		labelPhoto.setVisible(false);

		ImageIcon imageIcon = new ImageIcon(imagePath);
		Image image = imageIcon.getImage();
		image = image.getScaledInstance(350, 450, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		
		labelPhoto = new JLabel(imageIcon);
		labelPhoto.setOpaque(true);
	    labelPhoto.setBounds(20, 100, 350, 350);
	    panelInside.add(labelPhoto);
	    
	}
	
	
	public void miseEnPlacePhoto(){
		
		panelInside.setBackground(Color.ORANGE);
		
		/*
		next.setBounds(310, 5, 60, 60);
		next.setOpaque(true);
		panelInside.add(next, BorderLayout.EAST);
		
		previous.setBounds(5, 5, 60, 60);
		previous.setOpaque(true);
		panelInside.add(previous, BorderLayout.WEST);
		*/
		
		back.setBounds(130, 5, 130, 60);
		back.setOpaque(true);
		panelInside.add(back, BorderLayout.NORTH);
		
		delete.setBounds(130, 600, 80, 40);
		delete.setOpaque(true);
		panelInside.add(delete, BorderLayout.SOUTH);
	        

	}

}