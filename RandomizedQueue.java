import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] q;
    private int head;
    private int counter;

    public RandomizedQueue() {
        counter = 0;
        q = (Item[]) new Object[1];
        head = 0;


    }

    public boolean isEmpty() {
        return (q[head] == null);
    }

    public int size() {
        return counter;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("Item cant be null");
        if (counter == q.length) resize(q.length*2);

        if (!(head == 0 && q[head] == null))  head++;

        q[head] = item;


        counter++;

    }



    public Item dequeue() {
        if (this.isEmpty()) throw new java.util.NoSuchElementException("empty");
        if (counter == (q.length/4)) resize(q.length/2);
        int random = StdRandom.uniform(counter);


        Item item = q[random];


        q[random] = q[head];
        q[head] = null;
        if (head > 0) {
            head--;
        }

        counter--;

        return item;
    }

    private void resize(int newsize) {
        Item[] temp =  (Item[]) new Object[newsize];

        for (int i = 0; i < counter; i++) {
             temp[i] = q[i];
        }

        q = temp;

    }

    public Item sample() {
        if (this.isEmpty()) throw new java.util.NoSuchElementException("empty");
        int random = StdRandom.uniform(counter);
        return q[random];
    }





    public Iterator<Item> iterator() { return new ListIterator(); }

    private class ListIterator implements Iterator<Item> {

        private int pointer;
        private Item[] temp2;



        ListIterator() {

            pointer = counter-1;
            Item[] temp1;
            temp2 =  (Item[]) new Object[counter];
            temp1 = q;

                for (int i = 0; i < counter; i++) {
               int r = StdRandom.uniform(pointer+1);
                temp2[i] = temp1[r];
                temp1[r] = temp1[pointer];
                temp1[pointer] = null;
                pointer--;

            }

            pointer = counter-1;

        }



        public boolean hasNext() {
            return (pointer >= 0);
        }


        public Item next() {
            if (pointer < 0) throw new java.util.NoSuchElementException("empty");
            Item it = temp2[pointer];
            pointer--;
            return it;

        }

        public void remove() {
            throw new UnsupportedOperationException("no remove method");

        }
    }









}
