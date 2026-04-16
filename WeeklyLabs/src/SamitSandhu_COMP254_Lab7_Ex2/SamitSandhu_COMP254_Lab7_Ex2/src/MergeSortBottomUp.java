import maps.DefaultComparator;

import java.util.Queue;
import java.util.Arrays;
import java.util.Comparator;


public class MergeSortBottomUp {

//-------- support for bottom-up merge-sort of Queue --------

    public static <E> LinkedQueue<E> mergeQueue(LinkedQueue<E> Q1, LinkedQueue<E> Q2, maps.DefaultComparator<E> comp) {
        LinkedQueue<E> result = new LinkedQueue<E>();

        // both have to be not empty
        while (!Q1.isEmpty() && !Q2.isEmpty()) {
            int compResult = comp.compare(Q1.first(), Q2.first());
            // check if q1 first is less than q2 first (0 if equal, negative if true, positive if false)
            if (compResult <= 0) {
                result.enqueue(Q1.dequeue());
            } else {
                result.enqueue((Q2.dequeue()));
            }
        }
        // whatevers remaining, will be already sorted, as each iteration begins with only one element in each q1 and q2
        while (!Q1.isEmpty())
            result.enqueue(Q1.dequeue());
        while (!Q2.isEmpty())
            result.enqueue(Q2.dequeue());

        return result;
    }

    public static <E> LinkedQueue<E> bottomUpMergeSort(LinkedQueue<E> input) {

        DefaultComparator<E> comp = new DefaultComparator<>();
        LinkedQueue<LinkedQueue<E>> QueOfQues = new LinkedQueue<>();

        // Step 1: split into single-element queues
        while (!input.isEmpty()) {
            LinkedQueue<E> single = new LinkedQueue<>();
            single.enqueue(input.dequeue());
            QueOfQues.enqueue(single);
        }

        // Step 2: merge until one remains
        while (QueOfQues.size() > 1) {
            LinkedQueue<E> q1 = QueOfQues.dequeue();
            LinkedQueue<E> q2 = QueOfQues.dequeue();

            //only use whats left in q1, since q2 is emptied.
            if (q2 == null) {
                QueOfQues.enqueue(q1);
                break;
            }

            LinkedQueue<E> mergedQue = mergeQueue(q1, q2, comp);
            QueOfQues.enqueue(mergedQue);
        }

        return QueOfQues.dequeue();
    }

    public static void main(String[] args) {
        int[] S = new int[]{85, 24, 63, 45};

        iterateArray(S);

        LinkedQueue<Integer> MyQue = new LinkedQueue<>();
        for (int i = 0; i < S.length; i++) {
            MyQue.enqueue(S[i]);
        }

        MyQue = bottomUpMergeSort(MyQue);

        System.out.println("\nQue Size: " + MyQue.size());
        iterateQueue(MyQue);

        //Use the implementation of Merge-Sort with Queues to sort a queue of String objects
        //


    }
    public static void iterateArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
    }

    public static <E> void iterateQueue(LinkedQueue<E> Q) {
        int size = Q.size();

        for (int i = 0; i < size; i++) {
            E elem = Q.dequeue();
            System.out.print(elem + ", ");
            Q.enqueue(elem); // put it back
        }
    }
}