package Project4;
import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 *
 * @author yaw
 */
public class IntegerShortestPath {

    /**
     * @param args the command line arguments
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        WeightedGraph g = new WeightedGraph(args[0]);
        g.convert();
        BreadthFirstSearch bfs = new BreadthFirstSearch(g, g.getNodes().get(Integer.parseInt(args[1])));
        LinkedList<Node> path = bfs.getPathTo(g.getNodes().get(Integer.parseInt(args[2])));
        System.out.print("Route: ");
        for (int i = 0; i < path.size(); i++){
            if (path.get(i).getisOriginal()) {
                System.out.print(path.get(i).getNumber());
                if (i != path.size() -1){
                    System.out.print(" -> ");
                }
            }
        }
        System.out.println();
        System.out.println("Total Cost: "+ (path.size() - 1));
    }
}
