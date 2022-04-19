package Project3;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


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
    
    public void printConnectedComponents() {
        //HashSet<Integer> connected = new HashSet<>();
        List<List<Integer>> components = new ArrayList<List<Integer>>();
        List<Integer> nodelist = new ArrayList<Integer>();
        for(int i = 0; i < adjacencyList.length; i++){
            nodelist.add(i);
        }
        while(!nodelist.isEmpty()){
            List<Integer> flow = new ArrayList<Integer>();
            flow.add(nodelist.get(0));
            boolean flag = false;
            int index = 0;
            while(!flag){
                int currentNode = flow.get(index);
                List<Integer> neighbors = this.getNeighbors(currentNode);
                for(int i = 0; i < neighbors.size(); i++){
                    Integer cur = neighbors.get(i);
                    if(!flow.contains(cur)){
                        flow.add(cur);
                    }
                    //if its not in the flow list, add it, if it is, skip it
                }
                // based on the adjacency list, get all its neighbors. then put them into flow
                if(flow.size() - 1 == index){
                    flag = true;
                }
                // if flow.length -1 ==  index ; set flag = true;
                index += 1;
                //index += 1;
            }
            components.add(flow);
            nodelist.removeAll(flow);
        }
        System.out.println(components);
    }
}
