
import static org.junit.Assert.*;



import java.util.ArrayList;

import javax.swing.JLabel;

import org.junit.Test;


public class CheckGalleryTest {

	@Test
	public void test() {
		

		
		Object [] images = CheckGallery.getImageArray();
		
		
		ArrayList <GalleryImage> list = (ArrayList)images[0];
		int nombre = list.size();
		
		System.out.println(nombre);
		
		
		System.out.println(CheckGallery.imagesCount);
		
		System.out.println(images[1]);
		

		assertTrue(nombre==CheckGallery.imagesCount);

	
		
	}

}
