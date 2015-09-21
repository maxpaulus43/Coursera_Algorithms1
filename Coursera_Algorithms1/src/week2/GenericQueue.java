package week2;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class GenericQueue<Item> implements Iterable<Item> {
    private Item[] s;
    private int head;
    private int tail;
    private int size;

    @SuppressWarnings("unchecked")
    public GenericQueue() {
        s = (Item[]) new Object[1];
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Item data) {
        s[tail] = data;
        tail = (tail + 1) % s.length;
        size++;
        if (size >= s.length) {
            resize(s.length * 2);
        }
    }

    public Item dequeue() {
        if (isEmpty()) {
            StdOut.println("Empty Queue");
            return null;
        }

        Item data = s[head];
        s[head] = null;
        head = (head + 1) % s.length;
        size--;
        if (size <= s.length / 4) {
            resize(s.length / 2);
        }
        return data;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        Item[] oldS = s;
        s = (Item[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            s[i] = oldS[(head + i) % oldS.length];
        }
        head = 0;
        tail = size;
    }

    private class QueueIterator implements Iterator<Item> {

        private int i = head;

        @Override
        public boolean hasNext() {
            return (i != tail);
        }

        @Override
        public Item next() {
            Item item = s[i];
            i = (i + 1) % s.length;
            return item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    public static void main(String[] args) {
        GenericQueue<String> q = new GenericQueue<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-"))
                break;
            else if (s.equals("*"))
                q.dequeue();
            else
                q.enqueue(s);
        }

        for (String n : q) {
            StdOut.println(n);
        }
    }
}
