import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 20/03/2017.
 */
public class Exercicio_07 {

    public static BufferedImage rgbToHsv(BufferedImage img){
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                Color color = new Color(img.getRGB(x, y));

            }
        }
    }

    public void run() throws IOException {
        String PATH = "C:\\Users\\Palups\\Documents\\img\\cor";
        BufferedImage img = ImageIO.read(new File(PATH, "puppy.png"));

        BufferedImage hsvImg;

        ImageIO.write(hsvImg, "png", new File("hsvImg.png"));
    }

    public static void main(String [] args){

    }
}
