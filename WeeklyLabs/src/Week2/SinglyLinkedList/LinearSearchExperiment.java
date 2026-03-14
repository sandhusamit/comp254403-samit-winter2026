package Week2.SinglyLinkedList;

import Week2.SinglyLinkedList.SinglyLinkedList;

import java.util.*;
public class LinearSearchExperiment {
    public static int linearSearchArray(int[] a, int key) {
        for(int i=0;i<a.length;i++) if(a[i]==key) return i;
        return -1;
    }
    public static int linearSearchList(SinglyLinkedList.Node head, int key) {
        int idx = 0;
        SinglyLinkedList.Node walk = head;

        while (walk != null) {
            if ((Integer) walk.getElement() == key) return idx;
            walk = walk.getNext();
            idx++;
        }
        return -1;
    }


    public static void main(String[] args) {
        int N = 100_000;
        int[] array = new int[N];
        for (int i = 0; i < N; i++) array[i] = i;     // setup (not timed)

        SinglyLinkedList.Node head = buildList(N);     // setup (not timed)
        int key = 5;

// time array search (1,000,000 times)
        long t1 = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) linearSearchArray(array, key);
        long t2 = System.nanoTime();

// time list search (1,000,000 times)
        long t3 = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) linearSearchList(head, key);
        long t4 = System.nanoTime();

        System.out.println("Array search time: " + (t2-t1)/1e6 + " ms");
        System.out.println("List search time:  " + (t4-t3)/1e6 + " ms");
    }

    // build singly linked list 0→1→…→N-1
    static SinglyLinkedList.Node buildList(int N){ /* TODO */
        SinglyLinkedList newList = new SinglyLinkedList();
        for (int i = 0; i < N; i++) newList.addLast(i);
        return newList.firstNode();

    }
}