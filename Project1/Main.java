package Project1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String answer; 
        AnimalTree animal;
        try{
            animal = new AnimalTree("tree.txt");
        }
        catch(Exception e){
            animal = new AnimalTree();
        }
        Node curnode = animal.root;
        while(true){
            System.out.print("Do you have another animal to identify?");
            answer = input.nextLine();
            //System.out.print(answer);
            if(answer.equals("N")){
                break;
            }
            if(curnode != null){
                System.out.print("What is your new animal?");
                answer = input.nextLine();
                System.out.print("I don't know any " + curnode.getCharacteristic() + " animals that aren't a " + curnode);
                System.out.print("What characteristic does this new animal have that a " + curnode + " does not?");
                answer = input.nextLine();

            }

            //System.out.print("Is your animal " + animal.getCharacteristic());

        }
        
        /*
        needs to get the question based off of where we are 
        asks user the correct question
        is told the answer
        */


        try {
        animal.save("tree.txt");
        } 
        catch (Exception e){

        }
        input.close();
    }
}
