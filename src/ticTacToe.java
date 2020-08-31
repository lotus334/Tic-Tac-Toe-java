import java.util.Scanner;
import java.util.Arrays;

public class ticTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");

        char[][] matrix = new char[3][3];
        String str = scanner.nextLine();
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = str.charAt(k);
                k++;
            }
        }

        //char[] matrix = scanner.nextLine().toCharArray();
        System.out.println("---------");
        //for (int i = 0; i < 9; i += 3) {
        //    System.out.println(String.format("| %c %c %c |", matrix[i], matrix[i+1], matrix[i+2]));
        //}
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");

        char winer = ' ';
        boolean wins = false;
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2]) {
                wins = true;
                winer = matrix[i][0];
            }
            if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i]) {
                wins = true;
                winer = matrix[0][i];
            } else if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]) {
                wins = true;
                winer = matrix[1][1];
            } else if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0]) {
                wins = true;
                winer = matrix[1][1];
            }
            if (wins) {
                System.out.println(winer + " wins");
                break;
            }
        }
    }
}
