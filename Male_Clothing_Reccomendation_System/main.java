package Male_Clothing_Reccomendation_System;

// imports for program
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
    //*  Define an array of image file paths *//
    public static void main(String[] args) {
        String[] imagePaths = 
        {"C:\\Users\\eomot\\OneDrive\\Desktop\\Job Search & Career Records\\Portfolio Website\\Java Projects\\Male_Clothing_Reccomendation_System\\Datasets\\benchmark images\\Ectomorph.jpg",
         "C:\\Users\\eomot\\OneDrive\\Desktop\\Job Search & Career Records\\Portfolio Website\\Java Projects\\Male_Clothing_Reccomendation_System\\Datasets\\benchmark images\\Endomorph.jpg", 
         "C:\\Users\\eomot\\OneDrive\\Desktop\\Job Search & Career Records\\Portfolio Website\\Java Projects\\Male_Clothing_Reccomendation_System\\Datasets\\benchmark images\\Mesomorph.jpg"};

         //* Create a panel *//
         // Create a JScrollPane to wrap the JPanel so we can scroll through the images
        JPanel panel = new JPanel(new GridLayout(0, 3));

        // Create a JScrollPane to wrap the JPanel so we can scroll through the images
        JScrollPane scrollPane = new JScrollPane(panel);

        // Create a JFrame and add the JScrollPane to it
        JFrame frame = new JFrame();
        frame.add(scrollPane);
        
        //* Add each image to the panel *//
        // Loop through each image file path and add the images to the JPanel
        for (String imagePath : imagePaths) {
            try {
                // Load the image into a BufferedImage object
                BufferedImage image = ImageIO.read(new File(imagePath));
                
                // Create a JLabel with an ImageIcon that wraps the BufferedImage
                ImageIcon icon = new ImageIcon(image);
                JLabel label = new JLabel(icon);

                // Add the JLabel to the JPanel
                panel.add(label);
            } catch (IOException e) {
                System.out.println("Error loading image: " + e.getMessage());
            }
        }

        //* Pack the JFrame *//
        // Pack the JFrame tightly around its components and make it visible
        frame.pack();
        frame.setVisible(true);
    }
}
        