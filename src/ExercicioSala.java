import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 10/03/2017.
 */
public class ExercicioSala {
    public static void main(String [] args) throws IOException {

        BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

        float increment = 255 / 600.0f;
        float r = 0;

        for(int y = 0; y < image.getHeight(); y++){
            for(int x = 0; x < image.getWidth(); x++){
                Color cor = new Color((int)r, 0, 0);
                //image.setRGB(x, y, 0xFFFF0000);
                image.setRGB(x, y, cor.getRGB());
            }
            r += increment;
        }

        ImageIO.write(image, "png", new File("ex_sala_01_red.png"));
    }
}
