import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 03/04/2017.
 */
public class Atividade_03 {

    public static int saturate(int value) {
        if(value > 255)
            return 255;
        if(value < 0)
            return 0;
        return value;
    }

    public static BufferedImage equalize(BufferedImage img){

        int[] histogram = new int[256];
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < 255; i++)
            histogram[i] = 0;

        for(int y = 0; y < img.getHeight(); y++)
            for (int x = 0; x < img.getWidth(); x++) {
                int color = img.getRGB(x, y);
                Color pixel = new Color(color);
                int r = pixel.getRed();
                histogram[r]++;
            }

        int[] accumulatedHistogram = new int[256];
        int minHistogram = 0;

        accumulatedHistogram[0] = histogram[0];

        for(int i = 1; i < 255; i++)
            accumulatedHistogram[i] = histogram[i] + accumulatedHistogram[i -1];

        for(int i = 0; i < 255; i++)
            if(histogram[i] != 0) {
                minHistogram = histogram[i];
                break;
            }

        int[] hv= new int[256];
        for(int i = 0; i < 255; i++)
            hv[i] = saturate((Math.round(((accumulatedHistogram[i] - minHistogram) / ((float)img.getHeight() * img.getWidth()))* (256 - 1))));

        for(int y = 0; y < img.getHeight(); y++)
            for (int x = 0; x < img.getWidth(); x++) {

                int cor = img.getRGB(x, y);
                Color newPixel = new Color(cor);
                newPixel = new Color(hv[newPixel.getRed()],hv[newPixel.getRed()],hv[newPixel.getRed()]);

                out.setRGB(x,y,newPixel.getRGB());
            }
        return out;
    }

    public void run() throws IOException {
        String PATH = "C:\\Users\\Palups\\Documents\\img\\gray";

        BufferedImage carPNG = ImageIO.read(new File(PATH, "car.png"));
        BufferedImage carsJPG = ImageIO.read(new File(PATH, "cars.jpg"));
        BufferedImage crowdPNG = ImageIO.read(new File(PATH, "crowd.png"));
        BufferedImage montanhaJPG = ImageIO.read(new File(PATH, "montanha.jpg"));
        BufferedImage universityPNG = ImageIO.read(new File(PATH, "university.png"));

        BufferedImage img1 = equalize(carPNG);
        BufferedImage img2 = equalize(carsJPG);
        BufferedImage img3 = equalize(crowdPNG);
        BufferedImage img4 = equalize(montanhaJPG);
        BufferedImage img5 = equalize(universityPNG);

        ImageIO.write(img1, "png", new File("atv_03_carEqualize.png"));
        ImageIO.write(img2, "jpg", new File("atv_03_carsEqualize.jpg"));
        ImageIO.write(img3, "png", new File("atv_03_crowdEqualize.png"));
        ImageIO.write(img4, "jpg", new File("atv_03_montanhaEqualize.jpg"));
        ImageIO.write(img5, "png", new File("atv_03_universityEqualize.png"));
    }

    public static void main(String [] args) throws IOException {
        new Atividade_03().run();
    }
}
