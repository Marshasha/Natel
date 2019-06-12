import javax.swing.JLabel;



public class GalleryImage {
	
	/**
	 * @author Marina Shashkova
	 * @param label est premier composant de l'Objet GalleryImage (photo) pour identifier son image
	 * @param path est 2em composant de l'Objet GalleryImage pour identifier son nom
	 */
	
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
