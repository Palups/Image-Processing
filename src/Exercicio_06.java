import javax.imageio.ImageIO;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 13/03/2017.
 */
public class Exercicio_06 {

    Color[][] getNextColor(BufferedImage img, int x, int y){                            //RETORNA MATRIZ COM CORES DOS VIZINHOS
        return new Color[][] {
                {getColor(img, x-1, y-1), getColor(img, x, y-1), getColor(img, x+1, y-1)},
                {getColor(img, x-1, y), getColor(img, x, y), getColor(img, x+1, y)},
                {getColor(img, x-1, y+1), getColor(img, x, y+1), getColor(img, x+1, y+1)}
        };
    }

    Color getColor(BufferedImage img, int x, int y){                                     //VERIFICA BORDAS
        if(x < 0 || x >= img.getWidth() || y < 0 || y >= img.getHeight())
            return new Color(0, 0, 0);

        return new Color(img.getRGB(x, y));
    }

    public static Color applyKernel(Color[][] colors, float[][] kernel){

        int mediaR = 0;
        int mediaG = 0;
        int mediaB = 0;

        Color newColors[][] = new Color[3][3];

        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                int r = (int)(colors[x][y].getRed() * kernel[x][y]);
                int g = (int)(colors[x][y].getGreen() * kernel[x][y]);
                int b = (int)(colors[x][y].getBlue() * kernel[x][y]);

                newColors[x][y] = new Color(r, g, b);
            }
        }

        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                mediaR += newColors[x][y].getRed();
                mediaG += newColors[x][y].getGreen();
                mediaB += newColors[x][y].getBlue();
            }
        }

        Color out = new Color(mediaR, mediaG, mediaB);

        return out;
    }

    BufferedImage convolve(BufferedImage img, float[][] kernel){
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int y = 0; y < img.getHeight(); y++){
            for(int x = 0; x < img.getWidth(); x++){
                Color outColor = new Color(applyKernel(getNextColor(img, x, y), kernel).getRGB());
                out.setRGB(x, y, outColor.getRGB());
            }
        }
        return out;
    }

    public void run() throws IOException {
        float kernel = (1.0f / 9.0f);
        float media[][] = {{kernel, kernel, kernel},
                           {kernel, kernel, kernel},
                           {kernel, kernel, kernel}};

        String PATH = "C:\\Users\\Palups\\Documents\\img\\cor";
        BufferedImage img = ImageIO.read(new File(PATH, "puppy.png"));

        BufferedImage convImg = convolve(img, media);

        ImageIO.write(convImg, "png", new File("convImg.png"));
    }

    public static void main(String [] args) throws IOException {
        new Exercicio_06().run();
    }
}
