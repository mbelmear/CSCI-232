package Project4;

import java.util.ArrayList;

public class Node{
    int number;
    ArrayList<Node> neighbors;
    ArrayList<Integer> weights;
    boolean isoriginal;

    public Node(int number, boolean isoriginal){
        this.number = number;
        this.isoriginal = isoriginal;
        neighbors = new ArrayList<Node>();
        weights = new ArrayList<Integer>();
    }

    public void addedge(Node node, Integer weight){
        neighbors.add(node);
        weights.add(weight);
        node.neighbors.add(this);
        node.weights.add(weight);
    }

    public int getNumber(){
        return number;
    }

    public ArrayList<Node> getNeighbors(){
        return neighbors;
    }

    public ArrayList<Integer> getWeights(){
        return weights;
    }

    public boolean getisOriginal(){
        return isoriginal;
    }

    public void removeedge(Node node){
        int edgeIndex = neighbors.indexOf(node);
        neighbors.remove(edgeIndex);
        weights.remove(edgeIndex);

        int otherEdgeIndex = node.neighbors.indexOf(this);
        node.neighbors.remove(otherEdgeIndex);
        node.weights.remove(otherEdgeIndex);
    }

}

