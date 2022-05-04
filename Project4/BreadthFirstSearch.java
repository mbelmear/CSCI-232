package Project4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author yaw
 */
public class BreadthFirstSearch {
    private List<Node> visited;
    
    private HashMap<Node, Node> previousVertex;
    private Node startNode;

    public BreadthFirstSearch(WeightedGraph graph, Node startNode) {
        visited = new ArrayList<>();
        previousVertex = new HashMap<>();
        this.startNode = startNode;
        bfs(graph, startNode);
    }

    private void bfs(WeightedGraph graph, Node startVertex) {
        Queue<Node> queue = new LinkedList<>();
        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Node vertex = queue.remove();
            for (Node neighbor : vertex.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    previousVertex.put(neighbor, vertex);
                    queue.add(neighbor);
                }
            }
        }
    }
    
    public boolean reachable(Node endVertex) {
        return visited.contains(endVertex);
    }

    public LinkedList<Node> getPathTo(Node endVertex) {
        if (!reachable(endVertex)) {
            return null;
        } else {
            LinkedList<Node> path = new LinkedList<>();
            for (Node v = endVertex; v != startNode; v = previousVertex.get(v)) {
                path.addFirst(v);
            }
            path.addFirst(startNode);
            return path;
        }
    }
}
