import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 18/03/2017.
 */
public class Atividade_02 {

    static float contraste[][] = {
            { 0, -1,  0},
            {-1,  5, -1},
            { 0, -1,  0}
    };

    public static int saturate(int value){
        if (value > 255)
            return 255;
        if(value < 0)
            return 0;
        return value;
    }

    static Color applyKernel(Color[][] colors, float[][] kernel) {
        Color newColors[][] = new Color[3][3];
        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++) {
                int r = saturate((int) (colors[x][y].getRed() * kernel[x][y]));
                int g = saturate((int) (colors[x][y].getGreen() * kernel[x][y]));
                int b = saturate((int) (colors[x][y].getBlue() * kernel[x][y]));
                newColors[x][y] = new Color(r, g, b);
            }

        int sr = 0;
        int sg = 0;
        int sb = 0;

        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++) {
                sr +=  newColors[x][y].getRed();
                sg +=  newColors[x][y].getGreen();
                sb +=  newColors[x][y].getBlue();
            }
        return new Color(sr, sg, sb);
    }

    public static BufferedImage convolve(BufferedImage img, float[][] kernel, int pixelSize) {
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < img.getHeight(); y+=pixelSize)
            for (int x = 0; x < img.getWidth() ; x+=pixelSize) {
                Color color = new Color(applyKernel(getPixelColor(img, x, y), kernel).getRGB());
                setNextColorCon(img,out,x,y,pixelSize,color);
                out.setRGB(x, y, color.getRGB());
            }
        return out;
    }

    public static void setNextColorCon(BufferedImage img, BufferedImage out, int x, int y, int pixelSize, Color cor) {
        for (int h = y; h < y + pixelSize ; h++)
            for (int w = x; w < x + pixelSize ; w++) {
                if(h >= img.getHeight() || w >= img.getWidth())
                    continue;
                out.setRGB(w,h, cor.getRGB());
            }
    }

    static Color getColor (BufferedImage img, int x, int y) {
        if(x < 0 || x >= img.getWidth() || y < 0 || y >= img.getHeight())
            return new Color(0,0,0);
        return new Color (img.getRGB(x, y));
    }

    static Color[][] getPixelColor(BufferedImage img, int x, int y) {
        return new Color[][]{
                {getColor(img,x-1, y-1), getColor(img, x, y-1), getColor(img, x+1, y-1)},
                {getColor(img,x-1, y+0), getColor(img, x, y+0), getColor(img, x+1, y+0)},
                {getColor(img,x-1, y+1), getColor(img, x, y+1), getColor(img, x+1, y+1)}
        };
    }



    public static void setNextColor(BufferedImage img, BufferedImage out, int x, int y, int pixelSize){
        Color color = new Color(img.getRGB(x, y));

        for(int h = y; h < y + pixelSize; h++){
            for(int w = x; w < x + pixelSize; w++){
                if(h >= img.getHeight() || w >= img.getWidth())
                    continue;
                out.setRGB(w, h, color.getRGB());
            }
        }
    }

    public static BufferedImage pixelate(BufferedImage img, int pixelSize) {
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < img.getHeight(); y = y + pixelSize)
            for (int x = 0; x < img.getWidth(); x = x + pixelSize)
                setNextColor(img, out, x, y, pixelSize);
        return out;
    }

    public void run() throws IOException {
        String PATH = "C:\\Users\\Palups\\Documents\\img\\cor";
        BufferedImage img = ImageIO.read(new File(PATH, "metroid1.jpg"));

        BufferedImage pixelatedImg = pixelate(img, 30);
        BufferedImage pixelatedConImg = convolve(pixelatedImg, contraste, 15);

        ImageIO.write(pixelatedImg, "png", new File("atv_02_metroidPixel.jpg"));
        ImageIO.write(pixelatedConImg, "png", new File("atv_02_metroidConPixel.jpg"));
    }

    public static void main(String [] args) throws IOException {
        new Atividade_02().run();
    }
}