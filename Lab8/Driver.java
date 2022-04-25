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
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 4);
        graph.addEdge(0, 4);
        
        System.out.println(graph.getDegree(0));
        System.out.println(graph.getMaxDegree());
        System.out.println(graph.isSimple());
        
        graph.addEdge(3, 3);
        System.out.println(graph.isSimple());
        graph.removeEdge(3, 3);
        
        graph.addEdge(4, 2);
        System.out.println(graph.isSimple());
        graph.removeEdge(4, 2);
        
        graph.addEdge(1, 4);
        System.out.println(graph.isSimple());
    }
}
