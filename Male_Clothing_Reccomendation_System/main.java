package Male_Clothing_Reccomendation_System;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class main {
    public static void main(String[] args) {
        String imagePath = "C:\\Users\\eomot\\OneDrive\\Desktop\\Job Search & Career Records\\Portfolio Website\\Java Projects\\Male_Clothing_Reccomendation_System\\Datasets\\benchmark images\\male body types.jpg";

        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            ImageIcon icon = new ImageIcon(image);
            JLabel label = new JLabel(icon);
            JFrame frame = new JFrame();
            frame.getContentPane().add(label);
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }
}
        