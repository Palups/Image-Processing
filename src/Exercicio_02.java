import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 10/03/2017.
 */
public class Exercicio_02 {

    public static BufferedImage threshold(BufferedImage img, int value){
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < img.getHeight(); y++){
            for(int x = 0; x < img.getWidth(); x++){
                if(img.getRGB(x, y) >= value)
                    img.setRGB(x, y, 0xFFFFFF);
                else
                    img.setRGB(x, y, 0x000000);
            }
        }
        return out;
    }

    public static BufferedImage grayScale(BufferedImage img){
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < img.getHeight(); y++){
            for(int x = 0; x < img.getWidth(); x++){
                Color color = new Color(img.getRGB(x, y));
                    int r = ((int)(color.getRed() * 0.3));
                    int g = ((int)(color.getGreen() * 0.59));
                    int b = ((int)(color.getBlue() * 0.11));

                    Color outColor = new Color(r, g, b);
                    out.setRGB(x, y, outColor.getRGB());
            }
        }
        return out;
    }

    public void run() throws IOException {
        String PATH = "C:\\Users\\Palups\\Documents\\img\\cor";
        BufferedImage img = ImageIO.read(new File(PATH, "puppy.png"));

        BufferedImage bwImg = grayScale(img);
        //BufferedImage bwImg = threshold(img, 50);

        ImageIO.write(bwImg, "png", new File("bwImg.png"));
    }

    public static void main(String [] args) throws IOException {
        new Exercicio_02().run();
    }
}
