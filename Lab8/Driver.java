package Lab8;
/**
 *
 * @author yaw
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph j = new Graph(3);
        j.addEdge(2, 3);
        j.getNumEdges();
        j.addEdge(4, 5);
        j.addEdge(6, 7);
        j.addEdge(2, 5);
        j.getDegree(3);
        j.getNeighbors(4);
        j.getMaxDegree();
    }
}
