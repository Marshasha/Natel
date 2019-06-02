import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

class CheckGallery {

    static ArrayList<GalleryImage> getImageArray(){
        ArrayList<GalleryImage> images = new ArrayList<>();
        File gallery = new File("./Gallery");

        if (gallery.exists() && gallery.listFiles() != null) {
            for (File fileImage : Objects.requireNonNull(gallery.listFiles())) {

                ImageIcon icon = new ImageIcon(fileImage.getAbsolutePath());
                Image iconImage = icon.getImage();
                iconImage = iconImage.getScaledInstance(131,100,Image.SCALE_SMOOTH);
                icon = new ImageIcon(iconImage);

                JLabel img = new JLabel(icon);
                images.add(new GalleryImage(img, fileImage.getAbsolutePath()));
            }
        }

        return images;
    }

    static MouseAdapter getMouseAdapter(final JPanel panel, final JPanel parentsPanel){
        return new MouseAdapter() {
            private Point yPoint;
            @Override
            public void mousePressed(MouseEvent e) {
                yPoint = e.getPoint();
                System.out.println("mouse Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println(yPoint.y);
                System.out.println("mouse Dragged");
                if ((yPoint != null) &&
                        (panel.getHeight() > parentsPanel.getHeight())){
                    JViewport viewPort = (JViewport)SwingUtilities.getAncestorOfClass(JViewport.class, panel);
                    if (viewPort != null){
                        Rectangle view = viewPort.getViewRect();

                        view.y += yPoint.y;

                        panel.scrollRectToVisible(view);
                    }
                }
            }
        };

    }
}

