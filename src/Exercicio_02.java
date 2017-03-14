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

                Color cor = new Color(img.getRGB(x, y));
                int r = cor.getRed();
                int g = cor.getGreen();
                int b = cor.getBlue();

                if(r >= value || b >= value || g >= value){
                    Color outColor = new Color(255, 255, 255);
                    out.setRGB(x, y, outColor.getRGB());
                }
                else{
                    Color outColor = new Color(0, 0, 0);
                    out.setRGB(x, y, outColor.getRGB());
                }
            }
        }
        return out;
    }

    public static BufferedImage grayScale(BufferedImage img){
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < img.getHeight(); y++){
            for(int x = 0; x < img.getWidth(); x++){
                //primeiro método---------------------------------------------
                /*Color color = new Color(img.getRGB(x, y));
                int r = color.getRed();

                Color outColor = new Color(r, r, r);
                out.setRGB(x, y, outColor.getRGB());*/
                //------------------------------------------------------------


                //segundo método----------------------------------------------
                Color color = new Color(img.getRGB(x, y));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                int media = (r + g + b) / 3;

                Color outColor = new Color(media, media, media);
                out.setRGB(x, y, outColor.getRGB());
                //------------------------------------------------------------


                //terceiro método---------------------------------------------
                /*Color color = new Color(img.getRGB(x, y));
                int r = ((int)(color.getRed() * 0.3));
                int g = ((int)(color.getGreen() * 0.59));
                int b = ((int)(color.getBlue() * 0.11));

                Color outColor = new Color(r, g, b);
                out.setRGB(x, y, outColor.getRGB());*/
                //------------------------------------------------------------
            }
        }
        return out;
    }

    public void run() throws IOException {
        String PATH = "C:\\Users\\Palups\\Documents\\img\\cor";
        BufferedImage img = ImageIO.read(new File(PATH, "puppy.png"));

        BufferedImage grayScale_IMG = grayScale(img);
        BufferedImage threshold_IMG = threshold(img, 120);

        ImageIO.write(grayScale_IMG, "png", new File("grayScale.png"));
        ImageIO.write(threshold_IMG, "png", new File("threshold.png"));
    }

    public static void main(String [] args) throws IOException {
        new Exercicio_02().run();
    }
}
