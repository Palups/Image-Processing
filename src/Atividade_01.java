import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 18/03/2017.
 */
public class Atividade_01 {



    public static BufferedImage rgbToEga(BufferedImage img){
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                Color color = new Color(img.getRGB(x, y));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                Color outColor = new Color(r, g, b);
                out.setRGB(x, y, outColor.getRGB());
            }
        }

        return out;
    }

    public void run() throws IOException {
        String PATH = "C:\\Users\\Palups\\Documents\\img\\cor";
        BufferedImage img = ImageIO.read(new File(PATH, "puppy.png"));

        BufferedImage egaImg = rgbToEga(img);

        ImageIO.write(egaImg, "png", new File("egaImg.png"));
    }

    public static void main(String [] args) throws IOException {
        new Atividade_01().run();
    }
}
