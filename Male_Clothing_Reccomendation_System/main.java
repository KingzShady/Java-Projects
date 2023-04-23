package Male_Clothing_Reccomendation_System;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class main {
    public static void main(String[] args) {
        String[] imagePaths = 
        {"C:\\Users\\eomot\\OneDrive\\Desktop\\Job Search & Career Records\\Portfolio Website\\Java Projects\\Male_Clothing_Reccomendation_System\\Datasets\\benchmark images\\Ectomorph.jpg",
         "C:\\Users\\eomot\\OneDrive\\Desktop\\Job Search & Career Records\\Portfolio Website\\Java Projects\\Male_Clothing_Reccomendation_System\\Datasets\\benchmark images\\Endomorph.jpg", 
         "C:\\Users\\eomot\\OneDrive\\Desktop\\Job Search & Career Records\\Portfolio Website\\Java Projects\\Male_Clothing_Reccomendation_System\\Datasets\\benchmark images\\Mesomorph.jpg"};

        JPanel panel = new JPanel(new GridLayout(0, 3));
        JScrollPane scrollPane = new JScrollPane(panel);
        JFrame frame = new JFrame();
        frame.add(scrollPane);
        
        for (String imagePath : imagePaths) {
            try {
                BufferedImage image = ImageIO.read(new File(imagePath));
                ImageIcon icon = new ImageIcon(image);
                JLabel label = new JLabel(icon);
                panel.add(label);
            } catch (IOException e) {
                System.out.println("Error loading image: " + e.getMessage());
            }
        }

        frame.pack();
        frame.setVisible(true);
    }
}
        