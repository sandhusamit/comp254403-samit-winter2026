//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String[] args) {

    //Exercise 1

    LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

    Position<String> root = tree.addRoot("10");
    Position<String> n5 = tree.addLeft(root, "5");
    Position<String> n15 = tree.addRight(root, "15");
    Position<String> n3 = tree.addLeft(n5, "3");
    Position<String> n7 = tree.addRight(n5, "7");
    Position<String> n12 = tree.addLeft(n15, "12");
    Position<String> n18 = tree.addRight(n15, "18");

    Position<String> next = tree.inorderNext(n7);
    System.out.println("Next of 7: " + (next != null ? next.getElement() : "null"));

    next = tree.inorderNext(n12);
    System.out.println("Next of 12: " + (next != null ? next.getElement() : "null"));

    next = tree.inorderNext(n18);
    System.out.println("Next of 18: " + (next != null ? next.getElement() : "null"));


    //Ex 2
    tree = new LinkedBinaryTree<>();

    root = tree.addRoot("10");
    n5 = tree.addLeft(root, "5");
    n15 = tree.addRight(root, "15");
    n3 = tree.addLeft(n5, "3");
    n7 = tree.addRight(n5, "7");
    n12 = tree.addLeft(n15, "12");

    tree.printAllSubtreeHeights();

}
/*
    1) The worst case running times in this algorithm is if we need to find the next for the largest number. In other words if it O(n) and n is the height of the tree.
 */
