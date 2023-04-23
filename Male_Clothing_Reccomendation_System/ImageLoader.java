package Male_Clothing_Reccomendation_System;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
    public static BufferedImage loadImage(String path) throws IOException {
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        return image;
    }
}
