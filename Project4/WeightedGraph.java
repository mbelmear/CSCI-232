package Project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeightedGraph{
    List<Node> allnodes;
    int numvertices;

    public WeightedGraph(String file) throws FileNotFoundException {
        allnodes = new ArrayList<Node>();
        loadGraph(file);
    }

    private void loadGraph(String file) throws FileNotFoundException{
        File filename = new File(file);
        Scanner sc = new Scanner(filename);
        String line = "";
        numvertices = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < numvertices; i++){
            Node newnode = new Node(i, true);
            allnodes.add(newnode);
        }
        while(sc.hasNextLine()){
            line = sc.nextLine();
            String[] arr = line.split(", ");
            int firstnode = Integer.parseInt(arr[0]);
            int secondnode = Integer.parseInt(arr[1]);
            int weight = Integer.parseInt(arr[2]);
            allnodes.get(firstnode).addedge(allnodes.get(secondnode), weight);
        }
        sc.close();
    }

    public List<Node> getNodes() {
        return allnodes;
    }

    public void convert(){
        ArrayList<Node> proggy = new ArrayList<>(allnodes);
        for(Node n : allnodes){
            for(int i = n.getNeighbors().size() - 1; i >= 0; i--){
                if(n.getWeights().get(i) > 1){
                    Node oldneighbor = n.getNeighbors().get(i);
                    int newEdges = n.getWeights().get(i);
                    n.removeedge(oldneighbor);
                    Node lastnode = n;
                    for(int j = 0; j < newEdges - 1; j++){
                        Node newnode = new Node(-1, false);
                        proggy.add(newnode);
                        newnode.addedge(lastnode, 1);
                        lastnode = newnode;
                    }
                    oldneighbor.addedge(lastnode, 1);
                }
            }
        }
        allnodes = proggy;
        //Create a new collection of nodes
        // For each node in the graph
            // X Add node to new collection
            // For each neighbor/weight pair of that node, looping backwards
            // If weight is already 1, skip that edge, otherwise:
                // Remove that edge
                // For the number of nodes to insert
                    // Create a new node, marked as not original, add to collection
                    // Set that node to have a neighbor of the previous new node with weight 1
                // Original neighbor, add edge of weight 1 to previous node
        // Replace old collection of nodes with new collection

    }
}