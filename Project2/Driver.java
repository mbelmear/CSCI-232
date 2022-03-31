package Project2;
import java.io.File;

/**
 *
 * @author yaw
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File dictionaryFile = new File("CSCI 232/Project2/words.txt");
        File processingFile = new File("CSCI 232/Project2/test.txt");
        try {
            DocCheck.spellCheck(processingFile, dictionaryFile);
        } 
        catch (Exception e){
            e.printStackTrace();
        }
        try {
            DocCheck.wordCount(processingFile);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
