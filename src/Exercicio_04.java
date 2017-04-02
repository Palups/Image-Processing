import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Palups on 14/03/2017.
 */
public class Exercicio_04 {

    BufferedImage lerp(BufferedImage img1, BufferedImage img2, float percent){
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

                int r3 = ((int)(r1 * (1.0f - percent) + r2 * percent));
                int g3 = ((int)(g1 * (1.0f - percent) + g2 * percent));
                int b3 = ((int)(b1 * (1.0f - percent) + b2 * percent));

                Color color3 = new Color(r3, g3, b3);
                out1.setRGB(x, y, color3.getRGB());
            }
        }
        return out1;
    }

    public void run() throws IOException {
        String PATH = "C:\\Users\\Palups\\Documents\\img\\mine";
        BufferedImage img1 = ImageIO.read(new File(PATH, "tom_jerry.jpg"));
        BufferedImage img2 = ImageIO.read(new File(PATH, "padrinhos_magicos.jpg"));

        BufferedImage img3 = lerp(img1, img2, 0.5f);

        ImageIO.write(img3, "jpg", new File("ex_04_img_result.jpg"));
    }

    public static void main(String [] args) throws IOException {
        new Exercicio_04().run();
    }
}
