//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String input = sc.nextLine();

    if (SamitSandhu_COMP254Lab3_Ex2.isPalindrome(input))
        System.out.println("The string is a palindrome.");
    else
        System.out.println("The string is NOT a palindrome.");

    sc.close();
}
public class SamitSandhu_COMP254Lab3_Ex2 {

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1)
            return true;

        if (s.charAt(0) != s.charAt(s.length() - 1))
            return false;

        return isPalindrome(s.substring(1, s.length() - 1));
    }
}