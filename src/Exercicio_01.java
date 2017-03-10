import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 10/03/2017.
 */
public class Exercicio_01 {

    public static int saturation(int value){
        if(value > 255)
            return 255;
        if(value < 0)
            return 0;

        return value;
    }

    public static BufferedImage bright (BufferedImage img, float intensity){
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                Color color = new Color(img.getRGB(x, y));
                int r = saturation((int)(color.getRed() * intensity));
                int g = saturation((int)(color.getGreen() * intensity));
                int b = saturation((int)(color.getBlue() * intensity));

                Color outColor = new Color(r, g, b);
                out.setRGB(x, y, outColor.getRGB());
            }
        }
        return out;
    }

    public void run() throws IOException {
        String PATH = "C:\\Users\\Palups\\Documents\\img\\cor";
        BufferedImage img = ImageIO.read(new File(PATH, "puppy.png"));

        BufferedImage darkImg = bright(img, 0.5f);
        BufferedImage brightImg = bright(img, 2.0f);

        ImageIO.write(darkImg, "png", new File("darkPuppy.png"));
        ImageIO.write(brightImg, "png", new File("brightPuppy.png"));
    }

    public static void main(String [] args) throws IOException {
        new Exercicio_01().run();
    }
}
