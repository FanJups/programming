package asciiart;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ASCIIArtServiceReverse {

	public void asciiArt(String L, String symbol) {
		int width = 100;
		int height = 30;

		// BufferedImage image = ImageIO.read(new
		// File("/Users/mkyong/Desktop/logo.jpg"));
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("SansSerif", Font.BOLD, 24));

		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString(L, 10, 20);

		// save this image
		// ImageIO.write(image, "png", new File("/users/mkyong/ascii-art.png"));

		for (int y = 0; y < height; y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < width; x++) {

				sb.append(image.getRGB(x, y) == -16777216 ? " " : symbol);

			}

			if (sb.toString().trim().isEmpty()) {
				continue;
			}

			System.out.println(sb.toString());
		}

	}

	public static void printAlphabet() {

		// 26 : A - Z

		// 52 : A - Z a - z
		char[] data = new char[26];
		for (int i = 0; i < 26; i++) {
			data[i] = (char) (65 + (i / 26) * 6 + i);
			System.out.println(data[i]);
		}
	}

	public static void main(String[] args) {

		ASCIIArtServiceReverse test = new ASCIIArtServiceReverse();

		// test.asciiArt("N", "*");

		test.asciiArt("N", "*");

		printAlphabet();

	}

}
