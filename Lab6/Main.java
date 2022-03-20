package Lab6;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

/**
 *
 * @author yaw
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] sizes = {500000, 750000, 1000000, 1250000};

        for (int size : sizes) {
            System.out.println("Size, Iteration, Insertion_time, Search_time");
            for (int iteration = 0; iteration < 10; iteration++) {
                long seed = System.currentTimeMillis();
                Random r = new Random(seed);
                /*
                This is the example that was given using a separate-chaining HashSet which uses a LinkedList
                //Insertion test SC.
                SeparateChainingHashSet hashSet = new SeparateChainingHashSet();
                long startTime = System.nanoTime();
                for (int i = 0; i < size; i++) {
                    hashSet.add(r.nextInt());
                }
                long elapsedTime = System.nanoTime() - startTime;
                System.out.print(size + "," + iteration + "," + (elapsedTime / 1000000000.0));
                
                //Search test SC.
                startTime = System.nanoTime();
                for (int i = 0; i < 10000; i++) {
                    hashSet.contains(r.nextInt());
                }
                elapsedTime = System.nanoTime() - startTime;
                System.out.println("," + (elapsedTime / 1000000000.0));
                */
                
                
                //Insertion Test HS
                r = new Random(seed);
                
                HashSet<Integer> hashSet2 = new HashSet<Integer>();
                long startTime2 = System.nanoTime();
                for (int i = 0; i < size; i++) {
                    hashSet2.add(r.nextInt());
                }
                long elapsedTime2 = System.nanoTime() - startTime2;
                System.out.print(size + "," + iteration + "," + (elapsedTime2 / 1000000000.0));
                
                //Search Test HS.
                startTime2 = System.nanoTime();
                for (int i = 0; i < 10000; i++) {
                    hashSet2.contains(r.nextInt());
                }
                elapsedTime2 = System.nanoTime() - startTime2;
                System.out.println("," + (elapsedTime2 / 1000000000.0));
                
                

                
                //Insertion Test TS
                r = new Random(seed);

                TreeSet<Integer> treeset = new TreeSet<Integer>();
                long startTime3 = System.nanoTime();
                for (int i = 0; i < size; i++) {
                    treeset.add(r.nextInt());
                }
                long elapsedTime3 = System.nanoTime() - startTime3;
                System.out.print(size + "," + iteration + "," + (elapsedTime3 / 1000000000.0));
                
                //Search test TS.
                startTime3 = System.nanoTime();
                for (int i = 0; i < 10000; i++) {
                    treeset.contains(r.nextInt());
                }
                elapsedTime3 = System.nanoTime() - startTime3;
                System.out.println("," + (elapsedTime3 / 1000000000.0));
                
            }
            System.out.println();
        }
    }
}
