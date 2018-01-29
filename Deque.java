import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

     private Node first;
     private Node last;
    private int counter;




    public Deque() {
        counter = 0;
        first = null;
        last = null;

    }

    public boolean isEmpty() {
        return (first == null);
    }

    public int size() {
        return counter;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("Item cant be null");
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.pre = null;

        if (oldfirst == null) {
            last = first;
            first.next = null;
        }
        else {
            first.next = oldfirst;
            oldfirst.pre = first;
        }

        counter++;

    }

    public Item removeFirst() {
        if (this.isEmpty()) throw new java.util.NoSuchElementException("empty");
        Item item = first.item;
        if ((first.next == null)) {
            first = null;
            last = first;
        }
        else {
            first = first.next;
            first.pre = null;
        }
        counter--;
        return item;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("Item cant be null");
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        counter++;
        if (oldlast == null) {
            first = last;
            last.pre = null;
        } else {
            oldlast.next = last;
            last.pre = oldlast;
        }
    }


    public Item removeLast() {
        if (this.isEmpty()) throw new java.util.NoSuchElementException("empty");
        Item item = last.item;
        if (last.pre == null) {
            first = null;
            last = first;
        }
        else {
            last = last.pre;
            last.next = null;

        }


        counter--;
        return item;

    }


    private class Node {
        Node next;
        Node pre;
        Item item;
    }


    public Iterator<Item> iterator() { return new ListIterator(); }


    private class ListIterator implements Iterator<Item> {

        private Node current = first;

            public boolean hasNext() {
                return (current != null);
            }


            public Item next() {
                if (current == null) throw new java.util.NoSuchElementException("empty");
                Item item = current.item;
                current = current.next;
                return item;

            }

            public void remove() {
                throw new UnsupportedOperationException("no remove method");

            }
    }











}
