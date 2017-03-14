import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 14/03/2017.
 */
public class Exercicio_03 {

    BufferedImage subtract(BufferedImage img1, BufferedImage img2){
        BufferedImage out1 = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage out2 = new BufferedImage(img2.getWidth(), img2.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < img1.getHeight(); y++){
            for(int x = 0; x < img1.getWidth(); x++){

                Color color1 = new Color(img1.getRGB(x, y));
                Color color2 = new Color(img2.getRGB(x, y));

                int r1 = color1.getRed();
                int g1 = color1.getGreen();
                int b1 = color1.getBlue();

                int r2 = color2.getRed();
                int g2 = color2.getGreen();
                int b2 = color2.getBlue();

                int r3 = r1 - r2;
                int g3 = g1 - g2;
                int b3 = b1 - b2;

                if(r3 < 0)
                    r3 = 0;
                if(g3 < 0)
                    g3 = 0;
                if(b3 < 0)
                    b3 = 0;

                Color color3 = new Color(r3, g3, b3);
                out1.setRGB(x, y, color3.getRGB());
            }
        }

        return out1;
    }

    BufferedImage add(BufferedImage img1, BufferedImage img2){
        BufferedImage out1 = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage out2 = new BufferedImage(img2.getWidth(), img2.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < img1.getHeight(); y++){
            for(int x = 0; x < img1.getWidth(); x++){

                Color color1 = new Color(img1.getRGB(x, y));
                Color color2 = new Color(img2.getRGB(x, y));

                int r1 = color1.getRed();
                int g1 = color1.getGreen();
                int b1 = color1.getBlue();

                int r2 = color2.getRed();
                int g2 = color2.getGreen();
                int b2 = color2.getBlue();

                int r3 = r1 + r2;
                int g3 = g1 + g2;
                int b3 = b1 + b2;

                if(r3 > 255)
                    r3 = 255;
                if(g3 > 255)
                    g3 = 255;
                if(b3 > 255)
                    b3 = 255;

                Color color3 = new Color(r3, g3, b3);
                out1.setRGB(x, y, color3.getRGB());
            }
        }

        return out1;
    }


    public void run() throws IOException {
        String PATH = "C:\\Users\\Palups\\Documents\\img\\pb";
        BufferedImage img1 = ImageIO.read(new File(PATH, "errosB1.png"));
        BufferedImage img2 = ImageIO.read(new File(PATH, "errosB2.png"));

        BufferedImage img3 = subtract(img1, img2);

        ImageIO.write(img3, "png", new File("errosB3.png"));
    }


    public static void main(String [] args) throws IOException {
        new Exercicio_03().run();
    }
}
