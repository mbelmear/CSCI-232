package Lab9;
import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 *
 * @author yaw
 */
public class BFS {

    /**
     * @param args the command line arguments
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        String filename = new String(args[0]);
        Graph g = new Graph(filename);
        g.loadGraph(filename);
        BreadthFirstSearch bfs = new BreadthFirstSearch(g, Integer.parseInt(args[1]));
        LinkedList<Integer> path = bfs.getPathTo(Integer.parseInt(args[2]));
        for (int i = 0; i < path.size(); i++){
            System.out.print(path.get(i));
            if (i != path.size() -1){
                System.out.print(" -> ");
            }
        }
        //to run the program in the command line, navigate to the directory where the files are
        //for this computer, use the following command lines:
        //javac .\Lab9\BFS.java
        //javac .\Lab9\BreadthFirstSearch.java
        //java Lab9.BFS Lab9\graph.txt 0 5
    }
}
