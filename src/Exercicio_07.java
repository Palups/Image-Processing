import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 20/03/2017.
 */
public class Exercicio_07 {

    public static float[] changeHSV(float[] hsv, float v, int n){  //n = 0 -> hue, n = 1 -> saturation, n = 2 -> value
        if(n>= 0 && n <=2)
            hsv[n] *= v;

        return hsv;
    }

    public static float getHSV(float[] hsv, int n){
        return hsv[n];
    }

    public static BufferedImage rgbToHsv(BufferedImage img){
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){

                Color color = new Color(img.getRGB(x, y));
                float[] hsv = new float[3];

                Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsv);
                hsv = changeHSV(hsv, 2.0f, 2); //luminosidade
                hsv = changeHSV(hsv, 1.2f, 0); //hue
                hsv = changeHSV(hsv, 1.0f, 1); //saturação

                color = new Color(Color.HSBtoRGB(getHSV(hsv, 0), getHSV(hsv, 1), getHSV(hsv, 2)));
                out.setRGB(x, y, color.getRGB());
            }
        }
        return out;
    }

    public void run() throws IOException {
        String PATH = "C:\\Users\\Palups\\Documents\\img\\cor";
        BufferedImage img = ImageIO.read(new File(PATH, "puppy.png"));

        BufferedImage hsvImg = rgbToHsv(img);

        ImageIO.write(hsvImg, "png", new File("ex_07_hsvImg.png"));
    }

    public static void main(String [] args) throws IOException {
        new Exercicio_07().run();
    }
}
