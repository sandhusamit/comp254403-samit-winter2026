public static void main(String[] args) {

    // Exercise 1
    System.out.println("\n \n=================== Exercise 1 ==============");

    LinkedPositionalList<String> list = new LinkedPositionalList<>();

    Position<String> p1 = list.addLast("A");
    Position<String> p2 = list.addLast("B");
    Position<String> p3 = list.addLast("C");
    Position<String> p4 = list.addLast("D");

    System.out.println("Index of A: " + list.indexOf(p1)); // 0
    System.out.println("Index of B: " + list.indexOf(p2)); // 1
    System.out.println("Index of C: " + list.indexOf(p3)); // 2
    System.out.println("Index of D: " + list.indexOf(p4)); // 3


    // Exercise 2
    System.out.println("\n \n=================== Exercise 2 ==============");

    ArrayStack<Integer> S = new ArrayStack<>();
    ArrayStack<Integer> T = new ArrayStack<>();

    S.push(10);
    S.push(20);
    S.push(30);

    ArrayStack.transfer(S, T);

    System.out.println("Contents of T after transfer:");
    while (!T.isEmpty()) {
        System.out.println(T.pop());
    }

    //Exercise 3
    System.out.println("\n \n=================== Exercise 3 - Corrected on 4/12/2026 ==============");

    //Create two linkedQues
    LinkedQueue<Integer> Q1 = new LinkedQueue<>();
    LinkedQueue<Integer> Q2 = new LinkedQueue<>();
    for (int i = 0; i < 5000; i++)
    {
        Q1.enqueue(i);
        Q2.enqueue(i+10);
    }
    System.out.println("Q1:" + Q1);
    System.out.println("Q2" + Q2);

    //Concatenate with O(1)
    System.out.println("=============== Concatenate in O(1) =============");
    long start = System.nanoTime();
    Q2 = Q1.concatenate(Q2);
    long end = System.nanoTime();
    System.out.println("Quick Concat O(1): " + (end - start) + " ns");
    System.out.println("Q1:" + Q1);
    System.out.println("Q2" + Q2);

    //Create two linkedQues
    LinkedQueue<Integer> Q3 = new LinkedQueue<>();
    LinkedQueue<Integer> Q4 = new LinkedQueue<>();
    for (int i = 0; i < 5000; i++)
    {
        Q3.enqueue(i);
        Q4.enqueue(i+5);
    }

    //Concatenate with O(n)
    System.out.println("=============== Concatenate in O(n) =============");
    long start1 = System.nanoTime();
    Q3.concatenateSlow(Q4);
    long end1 = System.nanoTime();
    System.out.println("Loop Concat O(n): " + (end1 - start1) + " ns");
    System.out.println("Q3:" + Q3);
    System.out.println("Q4" + Q4);


    /*
    Note for prof: I left the previous concatenate in [O(n)] which at the time I thought was correct, but upon re-doing assignment4 to study for exams, I noticed how wrong that was and decided to redo it to atleast demo my progression in this course :)
     */

}