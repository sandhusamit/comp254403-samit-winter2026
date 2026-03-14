public static void main(String[] args) {

    // Exercise 1
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
    LinkedQueue<Integer> Q1 = new LinkedQueue<>();
    Q1.enqueue(100);
    Q1.enqueue(90);
    Q1.enqueue(80);
    LinkedQueue<Integer> Q2 = new LinkedQueue<>();
    Q2.enqueue(40);
    Q2.enqueue(50);
    Q2.enqueue(60);
    Q1.concatenate(Q2);


}