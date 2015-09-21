package week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ArrayQueue {

    private String[] s;
    private int head;
    private int tail;
    private int size;
    
    public ArrayQueue() {
        s = new String[1];
        head = 0;
        tail = 0;
        size = 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void enqueue(String data) {
        s[tail] = data;
        tail = (tail + 1) % s.length;
        size++;
        if (size >= s.length) {
            resize(s.length * 2);
        }
    }
    
    public String dequeue() {
        if (isEmpty()) {
            StdOut.println("Empty Queue");
            return null;
        }
        
        String data = s[head];
        s[head] = null;
        head = (head + 1) % s.length;
        size--;
        if (size <= s.length / 4) {
            resize(s.length / 2);
        }
        return data;
    }
    
    private void resize(int newCapacity) {
        String[] oldS = s;
        s = new String[newCapacity];
        for (int i = 0; i < size; i++) {
            s[i] = oldS[(head + i) % oldS.length];
        }
        head = 0;
        tail = size;
    }
        
    public static void main(String[] args) {
        ArrayQueue stack = new ArrayQueue();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-"))
                StdOut.println(stack.dequeue());
            else
                stack.enqueue(s);
        }
    }

}
