package image_analyzer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Analyzer {

	public static void main(String[] args) {
		//Open an image file into a buffer
		File imageFile = new File("testImage.jpg");
		getMapOfPixelColorCount(imageFile);
	}
	
	public static Map<Color, Integer> getMapOfPixelColorCount(File imageFile){
		Map<Color, Integer>colorCount = new HashMap<Color, Integer>();
		try {
			BufferedImage image = ImageIO.read(imageFile);
			int imageHeight = image.getHeight();
			int imageWidth = image.getWidth();
			Color color = null;

			for (int y = 0; y < imageHeight; y++) {
				for (int x = 0; x < imageWidth; x++) {
					color = new Color(image.getRGB(x, y), true);
					countPixelColors(colorCount, color);
				}
			}
			
			System.out.println(colorCount.keySet().size());
		
		} catch (IOException e) {
			System.out.println("Unable to open " + imageFile);
			e.printStackTrace();
		}
		
		return colorCount;
		
	}
	
	public static void countPixelColors(Map<Color, Integer> colorCount, Color color) {
		if (colorCount.containsKey(color)) {
			int currentCount = (int) colorCount.get(color);
			colorCount.put(color, currentCount + 1);
		} else {
			int defaultValue = 1;
			colorCount.put(color, defaultValue);
		}	
	}

}
