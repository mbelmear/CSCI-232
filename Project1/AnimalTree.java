package Project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class AnimalTree {

    public Node root;
    public AnimalTree(){
        root = new Node("furry");
        root.setLeft(new Node("dog"));
        root.setRight(new Node("snake"));
    }

    public AnimalTree(String path) throws Exception{
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        HashMap<String, Node> nodeMap = new HashMap<>();
        String curline;
        while ((curline = br.readLine()) != null){
            String[] poop = curline.split(",");
            Node node = new Node(poop[0]);
            String parentname = poop[1];
            String location = poop[2];
            if(parentname.equals("root")){
                root = node;
            }
            else{
                Node parent = nodeMap.get(parentname);
                if(location.equals("R")){
                    parent.setRight(node);
                }
                if(location.equals("L")){
                    parent.setLeft(node);
                }
            }
            nodeMap.put(poop[0], node);
        }
        br.close();
    }
    
    public void save(String path) throws Exception{
        FileWriter myWriter = new FileWriter(path);
        myWriter.write(generatetreestr(root));
        myWriter.close();       
    }

    private String generatetreestr(Node current){
        if(current == null){
            return "";
        }
        String asString = current.getCharacteristic();        
        if(current == root){
            asString += ",root,Y";
        }
        else{
            asString += "," + current.getParent().getCharacteristic() + ",";
            if(current == current.getParent().getLeft()){
                asString += "L";
            }
            else{
                asString += "R";
            }
        }
        String lefttree = generatetreestr(current.getLeft());
        String righttree = generatetreestr(current.getRight());
        if (!lefttree.equals("")){
            asString += "\n" + lefttree;
        }
        if (!righttree.equals("")){
            asString += "\n" + righttree;
        }
        return asString;
    }

    //need two more methods
    //need a method that tells current question
    //need that tells the current answer 
    private String curQuestion;
    
    public String getcurQuestion(){
        return curQuestion;
    }
    public void setcurQuestion(String curQuestion){
        this.curQuestion = curQuestion;
    }
    //public String Currentquestion(String curQuestion){
        //wherever we are in the tree, ask the corresponding question
        
    //}

}