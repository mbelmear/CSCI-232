package Lab9;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author yaw
 */
public class BreadthFirstSearch {
    private boolean[] visited;
    
    private int[] previousVertex;
    private int startVertex;

    public BreadthFirstSearch(Graph graph, int startVertex) {
        visited = new boolean[graph.getNumVertices()];
        previousVertex = new int[graph.getNumVertices()];
        this.startVertex = startVertex;
        bfs(graph, startVertex);
    }

    private void bfs(Graph graph, int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            for (int neighbor : graph.getNeighbors(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    previousVertex[neighbor] = vertex;
                    queue.add(neighbor);
                }
            }
        }
    }
    
    public boolean reachable(int endVertex) {
        return visited[endVertex];
    }

    public LinkedList<Integer> getPathTo(int endVertex) {
        if (!reachable(endVertex)) {
            return null;
        } else {
            LinkedList<Integer> path = new LinkedList<>();
            for (int v = endVertex; v != startVertex; v = previousVertex[v]) {
                path.addFirst(v);
            }
            path.addFirst(startVertex);
            return path;
        }
    }
}
