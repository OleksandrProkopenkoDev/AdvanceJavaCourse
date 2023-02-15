package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHandlingDemo {

	public static void main(String[] args) {
		int width = 2000;
		int height = 2000;
		
		BufferedImage image = null;
		image = readFromFile(width, height, image);
		writeToFile(image);		
	}

	private static BufferedImage readFromFile(int width, int height, BufferedImage image) {
		try {
			File sampleFile = new File("140.jpg");
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(sampleFile);
			System.out.println("reading complete "+image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return image;
	}
	
	private static void writeToFile(BufferedImage image) {
		File output = new File("copy of 140.jpg");
		try {
			ImageIO.write(image, "jpg", output);
			System.out.println("Writing complete");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
