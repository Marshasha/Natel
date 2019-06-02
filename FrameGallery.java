
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

public class FrameGallery extends FrameModel implements PanelMulti {
	
	private static final int MAX_PHOTOS = 100;
	
	boolean flagFromContact;
	
    ArrayList<GalleryImage> images;
    Rectangle boundsGallery;
    int imagesCount = 0;

    public FrameGallery(){
        super();

        panelInside.setBackground(Color.green);
        addImagePanel();
        addListenerToImages();
    }
    
    public void setFlag(boolean flag){
    	this.flagFromContact = flag;
    }

    private void addImagePanel(){
        // create grid layout with 3 columns and any count of rows
        GridLayout grid = new GridLayout(0,3);

        // create new JPanel to display images with our layout
        // and green background
        JPanel galleryPanel = new JPanel();
        galleryPanel.setLayout(grid);
        galleryPanel.setBackground(Color.gray);

        addImagesIntoPanel(galleryPanel);

        addListenerToPanelInside(galleryPanel);
    }

    private void addImagesIntoPanel(JPanel galleryPanel)  {
        // get images from Gallery directory
        this.images = CheckGallery.getImageArray();

        // if directory not null, we can add images into our panel
        // and set Bounds to our panel
        if (!images.isEmpty()) {
            for (GalleryImage img : images) {
                galleryPanel.add(img.getLabel());
                imagesCount++;
              //  if(imagesCount > MAX_PHOTOS) throw new MyExceptions ("Memory is full");
                System.out.println(imagesCount);
            }
            // get height of our JPanel from count of images
            int height = images.size();
            height = (height % 3 == 0) ? height / 3 : (height / 3) + 1;
            height = height*101;

            if (height > panelInside.getHeight()){
                this.boundsGallery =  new Rectangle(0, 0,
                        panelInside.getWidth(),
                        panelInside.getHeight());
            }else {
                this.boundsGallery = new Rectangle(0, 0, panelInside.getWidth(), height);
            }
        }
    }

    private void addListenerToPanelInside(JPanel galleryPanel){
        galleryPanel.setAutoscrolls(true);

        JScrollPane myScroll = new JScrollPane(galleryPanel);

        myScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        myScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        if (boundsGallery != null){
            myScroll.setBounds(this.boundsGallery);
        }

        myScroll.setBorder(null);
        myScroll.setViewportBorder(null);

        panelInside.add(myScroll);
        MouseAdapter mouseAdapter = CheckGallery.getMouseAdapter(galleryPanel, panelInside);

        galleryPanel.addMouseListener(mouseAdapter);
        galleryPanel.addMouseMotionListener(mouseAdapter);
    }

    private void addListenerToImages(){
        if (this.images != null){
            for (final GalleryImage img : this.images){
                img.getLabel().addMouseListener(new MouseListener() {
                	
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    	action(img.getPath());
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {}

                    @Override
                    public void mouseReleased(MouseEvent e) {}

                    @Override
                    public void mouseEntered(MouseEvent e) {}

                    @Override
                    public void mouseExited(MouseEvent e) {}
                });
            }
        }
    }
    
    private void action(String imagePath){
    	if (this.flagFromContact){
    		if(new File(imagePath).exists()){
    			fg.setVisible(false);
    			fce.setImage(imagePath);
    			fce.setVisible(true);
    		}
    	}else{
    		if(new File(imagePath).exists()){
            	fph.setPhoto(imagePath);
            	fph.setVisible(true);
            }
    	}
    	
    }

}
