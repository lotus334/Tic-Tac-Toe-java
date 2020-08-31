import java.util.Scanner;
import java.util.Arrays;

public class ticTacToe {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");

        char[] matrix = scanner.nextLine().toCharArray();
        System.out.println("---------");
        for (int i = 0; i < 9; i += 3) {
            System.out.println(String.format("| %c %c %c |", matrix[i], matrix[i+1], matrix[i+2]));
        }
        System.out.println("---------");
    }
}
