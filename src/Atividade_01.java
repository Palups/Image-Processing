import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 18/03/2017.
 */
public class Atividade_01 {

    public static int newValue(int value){
        if(value <= 64)
            return 0;  //32
        else if(value > 64 && value <= 128)
            return 64; //96
        else if(value > 128 && value <= 192)
            return 128; //160
        else
            return 255; //223
    }

    public static BufferedImage rgbToEga(BufferedImage img){
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                Color color = new Color(img.getRGB(x, y));
                int r = newValue(color.getRed());
                int g = newValue(color.getGreen());
                int b = newValue(color.getBlue());

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

        ImageIO.write(egaImg, "png", new File("atv_01_egaImg.png"));
    }

    public static void main(String [] args) throws IOException {
        new Atividade_01().run();
    }
}
