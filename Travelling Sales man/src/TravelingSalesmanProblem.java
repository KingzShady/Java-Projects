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
