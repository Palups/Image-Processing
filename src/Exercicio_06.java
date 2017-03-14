/*import java.awt.*;
import java.awt.image.BufferedImage;*/

/**
 * Created by Palups on 13/03/2017.
 */
/*public class Exercicio_06 {

    float media[][] = {
            {1.0f/9.0f, 1.0f/9.0f, 1.0f/9.0f},
            {1.0f/9.0f, 1.0f/9.0f, 1.0f/9.0f},
            {1.0f/9.0f, 1.0f/9.0f, 1.0f/9.0f}
    };

    Color applyKernel(Color[][] colors, float[][] kernel){
        Color newColors[][] = new Color[3][3];

        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                int r = (int)(colors[x][y].getRed()*kernel[x][y]);
                int g = (int) (colors[x][y].getGreen()*kernel[x][y]);
                int b = (int) (colors[x][y].getBlue()*kernel[x][y]);
                newColors[x][y] = new Color(r, g, b);
            }
        }
    }

    Color getColor(BufferedImage img, int x, int y){
        if(x < 0 || x >= img.getWidth() || y < 0 || y >= img.getHeight())
            return new Color(0, 0, 0);

        return new Color(img.getRGB(x, y));
    }

    Color[][] getPixelColor(BufferedImage img, int x, int y){
        return new Color[][] {
                {getColor(img, x-1, y-1), getColor(img, x, y-1), getColor(img, x+1, y-1)},
                {getColor(img, x-1, y), getColor(img, x, y), getColor(img, x+1, y)},
                {getColor(img, x-1, y+1), getColor(img, x, y+1), getColor(img, x+1, y+1)}
        };
    }

    BufferedImage convolve(BufferedImage img, float[][] kernel){
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int y = 0; y < img.getHeight(); y++){
            for(int x = 0; x < img.getWidth(); x++){
                Color[][] colors = getPixelColor(img, x, y);
            }
        }
    }

    public static void main(String [] args){

    }
}*/
