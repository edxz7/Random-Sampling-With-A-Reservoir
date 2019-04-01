/******************************************************************************
 *  Compilation:  javac RandomSampling.java
 *  Execution:    java RandomSampling sampling_size input.txt
 *  Dependencies: RandomizedQueue.java In.java StdRandom.java
 *
 *  A sampling reservoir implementation using a randomized Queue
 *
 *  Its complexity is {@code O(k)}, where {@code k} is the sample size.
 *  @code   RandomSampling
 *  @author Eduardo Ch Colorado
 ******************************************************************************/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class RandomSampling {
    public static void main(String[] args){
        RandomizedQueue<String> randomQueue = new RandomizedQueue<>();
        int k = Integer.parseInt(args[0]);     // Number of the elements sampled
        In in = new In(args[1]);               // Reservoir
        int counter = 0;
        while (!in.isEmpty()) {
            String item = in.readString();
            counter++;
            if(counter > k) {
                if (StdRandom.uniform() < k / ((double) counter)) {
                    randomQueue.dequeue();
                    randomQueue.enqueue(item);
                }
            }
            else randomQueue.enqueue(item);
        }
        //Print the content of the sample
        for (int i = 0; i < k; i++) {
            System.out.println(randomQueue.dequeue());
        }
    }
}
