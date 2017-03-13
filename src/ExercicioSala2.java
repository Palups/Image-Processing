import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 13/03/2017.
 */
public class ExercicioSala2 {

    public static int saturate(int value){
        if(value > 255)
            return 255;
        if(value < 0){
            return 0;
        }
        return value;
    }

    public static BufferedImage negative(BufferedImage img){
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < img.getHeight(); y++){
            for(int x = 0; x < img.getWidth(); x++){
                Color pixel = new Color(img.getRGB(x, y));
                int r = saturate(255 - pixel.getRed());
                int g = saturate(255 - pixel.getGreen());
                int b = saturate(255 - pixel.getBlue());

                Color newPixel = new Color(r, g, b);
                out.setRGB(x, y, newPixel.getRGB());
            }
        }
        return out;
    }

    public static void run() throws IOException {
        String PATH = "C:\\Users\\Palups\\Documents\\img\\cor";
        BufferedImage maiLiroPonei = ImageIO.read(new File(PATH, "puppy.png"));

        BufferedImage negativoPonei = negative(maiLiroPonei);
        ImageIO.write(negativoPonei, "png", new File("negativoPonei.png"));
    }

    public static void main(String [] args) throws IOException {
        ExercicioSala2 aula = new ExercicioSala2();
        ExercicioSala2.run();
    }
}
