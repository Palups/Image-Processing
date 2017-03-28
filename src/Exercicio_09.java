import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 27/03/2017.
 */
public class Exercicio_09 {

    int[] histogram(BufferedImage img){
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        int[] armazem = new int[256];

        for (int i = 0; i < 256; i++) {
            armazem[i] = 0;
        }

        for(int y = 0; y < img.getHeight(); y++){
            for(int x = 0; x < img.getWidth(); x++){

                Color color = new Color(img.getRGB(x, y));
                int b = color.getBlue();
                armazem[b] += 1;

            }
        }
        return armazem;
    }

//    public void run() throws IOException {
//        String PATH = "C:\\Users\\Palups\\Documents\\img\\cor";
//        BufferedImage img = ImageIO.read(new File(PATH, "puppy.png"));
//    }

    public static void main(String [] args){

    }
}
