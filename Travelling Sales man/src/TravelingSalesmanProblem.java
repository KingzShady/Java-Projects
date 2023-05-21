//Imports for the problem
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

        // return early if there are less than 2 nodes
        if(numNodes < 2) return;

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
            double angle = (double) i / (double) numNodes * 2.0 * Math.PI;
            int x = (int) (Math.cos(angle) * imageSize * 0.4 + imageSize * 0.5);
            int y = (int) (Math.sin(angle) * imageSize * 0.4 + imageSize * 0.5);
            nodeCoords[i] = new Point(x, y);
            graphics2D.fillOval(x - 5, y - 5, 10, 10);
        }

        // Changing the edges color to red
        graphics2D.setColor(Color.RED);

        // Finding the shortest route and coloring its edges green
        int[] shortestRoute = getShortestRoute();
        graphics2D.setColor(Color.GREEN);
        for (int i = 0; i < numNodes - 1; i++) {
            int node1 = shortestRoute[i];
            int node2 = shortestRoute[i+1];
            graphics2D.drawLine(nodeCoords[node1].x, nodeCoords[node1].y, nodeCoords[node2].x, nodeCoords[node2].y);
        }
        

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
    }

    /* Caculating the Shortest Path Functions */
    // Functions that calculate the distance of a given route
    private static int getRouteDistance(int[] route){
        int distance = distances[startNode][route[0]];
        for(int i = 0; i < numNodes - 2; i++){
            distance += distances[route[i]][route[i+1]];
        }
        distance += distances[route[numNodes-2]][startNode];
        return distance;
    }

    // Function to find the shortest route
    private static int[] getShortestRoute(){
        int[] shortestRoute = new int[numNodes-1];
        int[] currentRoute = new int[numNodes-1];
        for(int i = 0; i < numNodes - 1; i++){
            currentRoute[i] = Nodes.get(i);
        }
        int shortestDistance = getRouteDistance(currentRoute);
        System.arraycopy(currentRoute, 0, shortestRoute, 0, numNodes - 1);
        while(getNextPermutation(currentRoute)){
            int currentDistance = getRouteDistance(currentRoute);
            if(currentDistance < shortestDistance){
                shortestDistance = currentDistance;
                System.arraycopy(currentRoute, 0, shortestRoute, 0, numNodes-1);
            }
        }
        return shortestRoute;
    
    }

    // Function to determine the next permutation of an integer array.
    private static boolean getNextPermutation(int[] array){
        int i = array.length -2;
        while( i >= 0 && array[i] >= array[i+1]){
            i--;
        }
        if(i < 0){
            return false;
        }
        int j = array.length -1;
        while (array[j] <= array[i]) { 
            j--;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        int start  = i + 1;
        int end = array.length -1;
        while(start < end){
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return true;
    }

}
