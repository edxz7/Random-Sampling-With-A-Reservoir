import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

/******************************************************************************
 *  Compilation:  javac RandomSampling.java
 *  Execution:    none
 *  Dependencies: none
 *
 *  Randomize Queue build using a resizing array queue
 *
 *  @author Eduardo Ch Colorado
 ******************************************************************************/


public class RandomizedQueue<Item> implements Iterable<Item> {
    /**
     * The head index of the array is set to be always the index 0. The tail index tell us the index of the
     * last element inserted in the array. Tail is used to measure the # of Items and head isn't defined
     * explicitly
     */
    private Item[] queue = (Item[]) new Object[1];
    private int tail = 0;                            //pointer to the end of the array
//    private int numOfElements = 0;

    private void resize(int sz){
        Item[] tempQueue = (Item[]) new Object[sz];
        int numOfElements = tail;
        tail = 0;
        for (int i = 0; i < numOfElements; i++)
            tempQueue[tail++] = queue[i];
        queue = tempQueue;
    }

    public RandomizedQueue(){}  //construct a empty randomized queue
    public boolean isEmpty(){return tail == 0;}  //is the randomized queue empty?
    public int size() {return tail;} //return the number of items in the randomized queue
    public void enqueue(Item item){
        //add a Item
        if(item == null) throw new IllegalArgumentException();
        if (tail == queue.length) resize(2*queue.length);
        if(queue[tail] == null) {
            queue[tail] = item;
            tail =  tail + 1;
        }
    }
    public Item dequeue(){
        //remove and return a random item
        if(isEmpty()) throw new java.util.NoSuchElementException();
        int idx = StdRandom.uniform(tail);     //choose a index at random
        Item item = queue[idx];
        queue[idx] = queue[tail-1];
        queue[tail-1] = null;
        --tail;
        if (tail>0 && tail==queue.length/4) resize(queue.length/2);
        return item;
    }

    public Item sample(){
        //return a random item (but don't remove it)
        if(isEmpty()) throw new java.util.NoSuchElementException();
        int idx = StdRandom.uniform(tail);
        Item item = queue[idx];
        return item;
    }

    public Iterator<Item> iterator() { return new ArrayIterator(); }

    private class ArrayIterator implements Iterator<Item> {
        Item[] randomQueue = (Item[]) new Object[tail];
        private int i = 0;

        public ArrayIterator(){
            int idx = 0;
            for(int i = 0; i< tail; i++)
                randomQueue[idx++] = queue[i];
            StdRandom.shuffle(randomQueue);
        }

        public boolean hasNext() { return i < randomQueue.length; }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return randomQueue[i++];
        }
    }

//    public static void main(String[] args){
//        RandomizedQueue<String> rQ = new RandomizedQueue<>();
//        rQ.enqueue("2");
//        System.out.println(rQ.dequeue());
//        rQ.enqueue("3");
//        for (int i = 0; i < 10; i++) {
//            rQ.enqueue("s"+i);
//        }
//        for (int i = 0; i < 100; i++) {
//            System.out.println(rQ.sample());
//        }

//        System.out.println("----------------");
//        for (String k:rQ) {
//            System.out.println(k);
//        }
//    }
}
