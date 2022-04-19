package Project3;
/**
 *
 * @author yaw
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph output = new Graph(10);
        output.addEdge(0, 0);
        output.addEdge(1, 2);
        output.addEdge(2, 3);
        output.addEdge(3, 4);
        output.addEdge(4, 5);
        output.addEdge(5, 6);
        output.addEdge(8,9);
        output.addEdge(7, 7);
        //System.out.println(output.getNumEdges());
        //System.out.println(output.getNumVertices());
        //System.out.println(output.getNeighbors(3));
        output.printConnectedComponents();
    }
}
