package Lab9;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

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
    
    public Graph(String file) throws FileNotFoundException {
        loadGraph(file);
    }

    public void loadGraph(String file) throws FileNotFoundException{
        File filename = new File(file);
        Scanner sc = new Scanner(filename);
        String line = "";
        int numvert = Integer.parseInt(sc.nextLine());
        adjacencyList = new LinkedList[numvert];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        while(sc.hasNextLine()){
            line = sc.nextLine();
            String[] arr = line.split(",");
            int firstnode = Integer.parseInt(arr[0]);
            int secondnode = Integer.parseInt(arr[1]);
            adjacencyList[firstnode].add(secondnode);
            adjacencyList[secondnode].add(firstnode);
        }
        sc.close();
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
        if (adjacencyList[vertex1].contains(vertex2)) {
            adjacencyList[vertex1].remove((Integer) vertex2);
            adjacencyList[vertex2].remove((Integer) vertex1);
            numEdges--;
        }
    }

    public LinkedList<Integer> getNeighbors(int vertex) {
        return adjacencyList[vertex];
    }
}
