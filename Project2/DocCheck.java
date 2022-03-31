package Project2;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author yaw
 */
public class DocCheck {

    public static void spellCheck(File processingFile, File dictionaryFile) throws Exception {
        HashSet<String> dictionary = new HashSet<>();
        Scanner sc = new Scanner(dictionaryFile);
        while(sc.hasNextLine()){
            dictionary.add(sc.nextLine().toLowerCase());
        }
        sc = new Scanner(processingFile);
        String text = sc.nextLine();
        String[] pp = text.split("((?=[^a-zA-Z])|(?<=[^a-zA-Z]))");
        String output = "";
        for (int i = 0; i < pp.length; i++){
            String word = pp[i];
            if(word.matches("[a-zA-Z]+") && !dictionary.contains(word.toLowerCase())){
                pp[i] = "<" + word + ">";
            }
            output += pp[i];
        }
        String outputName = processingFile.getName();
        int pos = outputName.lastIndexOf(".");
        outputName = outputName.substring(0, pos) + "_spellChecked.txt";
        FileWriter myWriter = new FileWriter(outputName);
        myWriter.write(output);
        myWriter.close();
        
    }

    public static void wordCount(File processingFile) throws Exception {
        HashMap<String, Integer> countPerWord = new HashMap<>();
        HashMap<Integer, HashSet<String>> wordsPerCount = new HashMap<>();
        Scanner sc = new Scanner(processingFile);
        while(sc.hasNext()){
            String word = sc.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
            if(countPerWord.get(word) != null){
                countPerWord.replace(word, countPerWord.get(word)+1);
            }
            else if(word != ""){
                countPerWord.put(word, 1);
            }
        }
        TreeMap<String, Integer> alphabetical = new TreeMap<>(countPerWord);
        Iterator<String> it = alphabetical.keySet().iterator();
        String output = "";
        while(it.hasNext()){
            String key = it.next().toString();
            output += key + ": " + alphabetical.get(key) +"\n"; 
        }
        for (String word : countPerWord.keySet()){
            int count = countPerWord.get(word);
            if(wordsPerCount.containsKey(count)){
                wordsPerCount.get(count).add(word);
            }
            else{
                wordsPerCount.put(count, new HashSet<String>());
                wordsPerCount.get(count).add(word);
            }
        }
        //For printing in descending order use this
        String output2 = "";
        for (int i = wordsPerCount.size(); i > 0; i--){
            output2 += i + ": " + wordsPerCount.get(i).toString().replace("[", "").replace("]", "") + "\n";
        }
        //For printing in ascending order use this
        //for(int count : wordsPerCount.keySet()){
        //    output2 += count + ": " + wordsPerCount.get(count).toString().replace("[", "").replace("]", "") + "\n";
        //}
        //for(int i = wordsPerCount.size(); i >= 0; i++ ){
        //    output2 += i + ": " + wordsPerCount.get(i) + "\n";
        //}
        String outputname2 = processingFile.getName();
        int pos2 = outputname2.lastIndexOf(".");
        outputname2 = outputname2.substring(0,pos2) + "_wordCount.txt";
        FileWriter myWriter2 = new FileWriter(outputname2);
        myWriter2.write("Alphabetical Order Word Count:" + "\n" + output + "\n" + "By Occurrences Word Count:" + "\n" + output2);
        myWriter2.close();
    }
}
