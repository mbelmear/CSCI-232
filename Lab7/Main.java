package Lab7;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;


public class Main {

    private static Integer higher(HashSet<Integer>hashSet2, int value){
        Integer result = Integer.MAX_VALUE;
        boolean flag = false;
        for (Integer entry: hashSet2){
            if(entry > value && entry < result){
                result = entry;
                flag = true;
            }
        }
        if(flag){
            return result;
        }
        return null;
    }
    private static Integer ceiling(HashSet<Integer> hashSet2, int value){
        Integer result = Integer.MAX_VALUE;
        boolean flag = false;
        for (Integer entry: hashSet2){
            if(entry >= value && entry < result){
                result = entry;
                flag = true;
            }
        }
        if(flag){
            return result;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] sizes = {500000, 750000, 1000000, 1250000};
        for (int size : sizes) {
            Random queryRandom = new Random();
            int queryNum = queryRandom.nextInt();
            System.out.println("Size, Iteration, Ceiling Time, Higher Time");
            for (int iteration = 0; iteration < 10; iteration++) {
                long seed = System.currentTimeMillis();
                Random r = new Random(seed);
                r = new Random(seed);
                
                HashSet<Integer> hashSet2 = new HashSet<Integer>();
                for (int i = 0; i < size; i++) {
                    hashSet2.add(r.nextInt());
                } 
                //Timing the ceiling method for the hashset
                long startTime1 = System.nanoTime();             
                ceiling(hashSet2, queryNum);
                //System.out.println(ceiling(hashSet2, size));
                long elapsedTime1 = System.nanoTime() - startTime1;
                System.out.print(size + "," + iteration + "," + (elapsedTime1 / 1000000000.0));
                //Timing the higher method for the hashset
                long startTime2 = System.nanoTime();
                higher(hashSet2, queryNum);
                //System.out.println(higher(hashSet2, size));
                long elapsedTime2 = System.nanoTime() - startTime2;
                System.out.println(size + ","  + (elapsedTime2 / 1000000000.0));
                
                
                r = new Random(seed);

                TreeSet<Integer> treeset = new TreeSet<Integer>();
                for (int i = 0; i < size; i++) {
                    treeset.add(r.nextInt());
                }
                //Timing the ceiling method for the TreeSet
                long startTime3 = System.nanoTime();
                treeset.ceiling(queryNum);
                //System.out.println(treeset.ceiling(size));
                long elapsedTime3 = System.nanoTime() - startTime3;
                System.out.print(size + "," + iteration + "," + (elapsedTime3 / 1000000000.0));
                //Timing the ceiling method for the TreeSet
                long startTime4 = System.nanoTime();
                treeset.higher(queryNum);
                //System.out.println(treeset.higher(size));
                long elapsedTime4 = System.nanoTime() - startTime4;
                System.out.println(size + "," + (elapsedTime4 / 1000000000.0));
            }
            System.out.println();
        }
    }
}
