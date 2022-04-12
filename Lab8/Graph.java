package Lab8;
//import java.util.HashSet;
import java.util.LinkedList;


/**
 *
 * @author yaw
 */
public class Graph {
    private LinkedList<Integer>[] adjacencyList;
    private int numEdges;
    
    public Graph(int numVertices) {
        adjacencyList = new LinkedList[numVertices];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }
    
    public int getNumVertices() {
        return adjacencyList.length;
    }
    
    public int getNumEdges() {
        return numEdges;
    }
    
    public void addEdge(int vertex1, int vertex2) {
        adjacencyList[vertex1].add(vertex2);
        adjacencyList[vertex2].add(vertex1);
        numEdges++;
    }
    
    public LinkedList<Integer> getNeighbors(int vertex) {
        return adjacencyList[vertex];
    }
    
    // Return the degree value of the provided vertex.
    public int getDegree(int vertex){
        return adjacencyList[vertex].size();
        //if the adjacency list exists at the given vertex, return the number of vertices
        //at each spot in the adjacency list return the number of vertices
        //return the number of edges touching a particular vertex
    }
    
    // Return the degree value of the vertex with the largest degree value in the graph.
    public int getMaxDegree() {
        int counter = 0;
        for (int i = 0; i < adjacencyList.length; i++){
            if(getDegree(i) > counter){
                counter = getDegree(i);
            }
        }
        return counter;
        //for each vertex in the graph, find the vertex with the largest number of edges touching it
    }
    //was unable to finish this method
    // Return whether or not the graph is a simple graph.
   // public boolean isSimple() {
        //no loops and no parallel edges
        //use a hashset
        //if there is more than one vertex between any two vertices in the entire graph 
        //return false
        //else return true
        //a simple graph has at most one edge between a pair of vertices and no edges that start and end at the same vertex
    //}
}
