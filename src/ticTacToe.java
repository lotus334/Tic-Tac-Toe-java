import java.util.Scanner;

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

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
        /*
        char winer = ' ';
        boolean wins = false;
        boolean once1 = false;
        boolean once2 = false;
        int empty = 0;
        int xs = 0;
        int os = 0;
        int numberOfWiners = 0;
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2] && matrix[i][0] != '_') {
                wins = true;
                winer = matrix[i][0];
                numberOfWiners++;
            } else if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i] && matrix[0][i] != '_') {
                wins = true;
                winer = matrix[0][i];
                numberOfWiners++;
            } else if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[0][0] != '_') {
                wins = true;
                winer = matrix[1][1];
                if (once1 == false) {
                    once1 = true;
                    numberOfWiners++;
                }
            } else if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0] && matrix[1][1] != '_') {
                wins = true;
                winer = matrix[1][1];
                if (once2 == false) {
                    once2 = true;
                    numberOfWiners++;
                }
            }
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == '_') {
                    empty++;
                } else if (matrix[i][j] == 'X') {
                    xs++;
                } else if (matrix[i][j] == 'O') {
                    os++;
                }
            }
            if ((Math.abs(xs - os) > 1 && i == 2) || numberOfWiners > 1) {
                System.out.println("Impossible");
                break;
            }
            if (wins && i == 2) {
                System.out.println(winer + " wins");
                break;
            }
            if (xs + os == 9) {
                System.out.println("Draw");
                break;
            }
            if (xs + os + empty == 9) {
                System.out.println("Game not finished");
            }
        }
        */
        int x;
        int y;
        boolean flag = false;
        /*
        do {
            System.out.println("Enter the coordinates:");
            xs = scanner.next();
            ys = scanner.next();
            if (matrix[Math.abs(3-y)][x-1] == '_') {
                flag = true;
                matrix[Math.abs(3-y)][x-1] = 'X';
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        } while (!flag);
        */

        do {
            if (scanner.hasNextInt()) {
                x = scanner.nextInt();
                y = scanner.nextInt();
                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (matrix[Math.abs(3-y)][x-1] == '_') {
                    matrix[Math.abs(3-y)][x-1] = 'X';
                    flag = true;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } else {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        } while (!flag);

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }
}
