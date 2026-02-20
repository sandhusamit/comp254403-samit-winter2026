//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter first positive integer (m): ");
    int m = sc.nextInt();

    System.out.print("Enter second positive integer (n): ");
    int n = sc.nextInt();

    int result = SamitSandhu_COMP254Lab3_Ex1.recursiveProduct(m, n);

    System.out.println("Product is: " + result);

    sc.close();
}

public class SamitSandhu_COMP254Lab3_Ex1 {

    public static int recursiveProduct(int m, int n) {
        if (m == 0)
            return 0;
        return n + recursiveProduct(m - 1, n);
    }
}
