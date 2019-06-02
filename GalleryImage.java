import javax.swing.JLabel;



public class GalleryImage {
	
    private JLabel label;
    private String path;

    public GalleryImage(JLabel label, String path) {
        this.label = label;
        this.path = path;
    }

    public  JLabel getLabel() {
        return label;
    }

    public String getPath() {
        return path;
    }
}
