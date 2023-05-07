//Imports for the problem
import java.util.*;
import java.util.Vector;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class TravelingSalesmanProblem {

    // Defining the distances between nodes in the problem
    public static  int [][] distances = {
        {0,10,15,20},
        {10,0,35,25},
        {15,35,0,30},
        {20,25,30,0}
    };

    // Defining the number of nodes in the problem
    public static int numNodes = distances.length;

    // Defining the starting node
    public static int startNode = 0;

    // Defining a vector that will store the nodes
    private static Vector<Integer> Nodes = new Vector<Integer>();

    public static void main(String[] args) {
        // Adding all nodes except the starting node to the vector
        for (int i = 0; i < numNodes; i++) {
            if (i != startNode) {
                Nodes.add(i);
            }
        }

        /* Producing a picture with the proper proportions */ 
        // Seting image dimensions
        int imageSize = 500;
        BufferedImage image = new BufferedImage(imageSize,imageSize, BufferedImage.TYPE_INT_ARGB);

        // Making a drawing on the image using the graphics object
        Graphics2D graphics2D = image.createGraphics();

        // Making the image's background color white
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, imageSize, imageSize);

        // Changing the nodes color to blue
        graphics2D.setColor(Color.BLUE);
        
        // Calculating each node's coordinates depending on its index and the total number of nodes
        Point[] nodeCoords = new Point[numNodes];
        for (int i = 0; i < numNodes; i++) {
            double angle = (double)i / (double)numNodes*2.0*Math.PI;
            int x = (int) (Math.cos(angle) * imageSize * 0.4 + imageSize * 0.5);
            int y = (int) (Math.sin(angle) * imageSize * 0.4 + imageSize * 0.5);
            nodeCoords[i] = new Point(x, y);
            graphics2D.fillOval(x-5, y-5, 10, 10);
        }

        // Changing the edges color to red
        graphics2D.setColor(Color.RED);

        // Based on the distances between the nodes, draw the edges between them.
        for (int i = 0; i < numNodes; i++) {
            for (int j = i+1; j < numNodes; j++) {
                if(distances[i][j]>0){
                    graphics2D.drawLine(nodeCoords[i].x, nodeCoords[i].y, nodeCoords[j].x, nodeCoords[j].y);
                }
            }
        }

        // Creating a JFrame for the image to be shown
        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        /* Finding all the routes */
        // Creating a vector to store all routes found
        Vector<Vector<Integer>> routes = new Vector<Vector<Integer>>();

        // Creating a vector to store all the nodes that have been visited
        Vector <Integer> currentRoute = new Vector<Integer>();
        currentRoute.add(startNode);

        // Continually finding all routes
        findRoutes(startNode, Nodes, distances, currentRoute, routes);

        // Printing all the routes
        System.out.println("All the routes are: " + routes);


    }

    /* Method used to find all the routes between the nodes */
    public static void findRoutes(int currentNode, Vector<Integer> nodes,
    int[][] distances, Vector<Integer> currentRoute, Vector<Vector<Integer>> routes) {
        // Add the current node to the route and the finished route to the vector of all routes if there are no more nodes to add.
        if (nodes.size() == 0) {
            currentRoute.add(currentNode);
            routes.add(currentRoute);
            return;
        }

        // Looping over all remaining nodes
        for (int i = 0 ; i < nodes.size(); i++) {
            int nextNode = nodes.get(i);

            // Removing the current node to create a new set of remaining nodes
            Vector<Integer> newNode = new Vector<Integer>(nodes);
            newNode.removeElementAt(i);

            // Creating a fresh route by adding the current node
            Vector<Integer> newRoute = new Vector<Integer>(currentRoute);
            newRoute.add(nextNode);

            // Finding the separation between the current node and the following node
            int newDistance = distances[currentNode][nextNode];

            // Calling findRoutes recursively with the updated current node, updated nodes that are left, and updated route
            findRoutes(nextNode, newNode, distances, newRoute, routes);
        }
    }
}
