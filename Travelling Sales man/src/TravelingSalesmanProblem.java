//Imports for the problem
import java.util.*;

public class TravelingSalesmanProblem {
    public static void main(String[] args) {
        // Defining the distances between nodes in the problem
        int [][] distances = {
            {0,10,15,20},
            {10,0,35,25},
            {15,35,0,30},
            {20,25,30,0}
        };

        // Defining the number of nodes in the problem
        int numNodes = distances.length;

        // Defining the starting node
        int startNode = 0;

        // Defining a vector that will store the nodes
        Vector<Integer> Nodes = new Vector<Integer>();

        for (int i = 0; i < numNodes; i++) {
            if (i != startNode) {
                Nodes.add(i);
            }
        }
        
        // Finding all the routes
        Vector<Vector<Integer>> routes = new Vector<Vector<Integer>>();
        Vector <Integer> currentRoute = new Vector<Integer>();
        currentRoute.add(startNode);
        routes.add(currentRoute);
        return;

        

    }
}
