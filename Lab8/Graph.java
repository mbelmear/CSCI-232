package Lab8;
import java.util.HashSet;
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
    
    public void removeEdge(int vertex1, int vertex2) {
        adjacencyList[vertex1].remove((Integer) vertex2);
        adjacencyList[vertex2].remove((Integer) vertex1);
        
        numEdges--;
    }
    
    public LinkedList<Integer> getNeighbors(int vertex) {
        return adjacencyList[vertex];
    }
    
    // Return the degree value of the provided vertex.
    public int getDegree(int vertex){
        return adjacencyList[vertex].size();
    }
    
    // Return the degree value of the vertex with the largest degree value in the graph.
    public int getMaxDegree() {
        int maxDegree = 0;
        for (LinkedList neighbors : adjacencyList) {
            if (neighbors.size() > maxDegree) {
                maxDegree = neighbors.size();
            }
        }
        return maxDegree;
    }
    
    // Return whether or not the graph is a simple graph.
    public boolean isSimple() {
        for (int vertex = 0 ; vertex < adjacencyList.length; vertex++) {
            HashSet<Integer> uniqueNeighbors = new HashSet<>();
            
            for (int neighbor : adjacencyList[vertex]) {
                if (neighbor == vertex) {
                    return false;
                }
                if (uniqueNeighbors.contains((Integer) neighbor)) {
                    return false;
                }
                uniqueNeighbors.add(neighbor);
            }
        }
        return true;
    }
}
