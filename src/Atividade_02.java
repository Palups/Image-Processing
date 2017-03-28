import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 27/03/2017.
 */
/*public class Atividade_02 {

    public static BufferedImage pixelate(BufferedImage img){
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < img.getHeight(); y++){
            for(int x = 0; x < img.getWidth(); x++){

                Color color = new Color(img.getRGB(x, y));

                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
            }
        }
    }



    public void run() throws IOException {
        String PATH = "C:\\Users\\Palups\\Documents\\img\\cor";
        BufferedImage img = ImageIO.read(new File(PATH, "puppy.png"));
    }

    public static void main(String [] args){

    }
}/*
