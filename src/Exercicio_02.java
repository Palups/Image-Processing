import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 10/03/2017.
 */
public class Exercicio_02 {

    public static BufferedImage grayScale(BufferedImage img){
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < img.getHeight(); y++){
            for(int x = 0; x < img.getWidth(); x++){
                Color color = new Color(img.getRGB(x, y));

            }
        }
    }

    public void run() throws IOException {
        String PATH = "C:\\Users\\Palups\\Documents\\img\\cor";
        BufferedImage img = ImageIO.read(new File(PATH, "puppy.png"));

        BufferedImage bwImg = grayScale(img);

        ImageIO.write(bwImg, "png", new File("bwImg.png"));
    }

    public static void man(String [] args) throws IOException {
        new Exercicio_02().run();
    }
}
