import java.util.Scanner;

public class ticTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char winer = ' ';
        char gamer;
        boolean gameOver = false;
        boolean correctInput;
        int emptyCells = 9;
        int numberOfX = 0;
        int numberOfY = 0;
        int x;
        int y;

        char[][] matrix = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = '_';
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
        while (!gameOver) {
            for (int i = 0; i < 3; i++) {
                if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2] && matrix[i][0] != '_') {
                    gameOver = true;
                    winer = matrix[i][0];
                } else if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i] && matrix[0][i] != '_') {
                    gameOver = true;
                    winer = matrix[0][i];
                } else if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[0][0] != '_') {
                    gameOver = true;
                    winer = matrix[1][1];
                } else if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0] && matrix[1][1] != '_') {
                    gameOver = true;
                    winer = matrix[1][1];
                }
                if (gameOver) {
                    System.out.println(winer + " wins");
                    break;
                }
                if (numberOfX + numberOfY == 9) {
                    System.out.println("Draw");
                    gameOver = true;
                    break;
                }
            }
            if (!gameOver) {
                correctInput = false;
                System.out.println("Enter the coordinates: ");
                if (emptyCells % 2 == 0) {
                    gamer = 'X';
                    numberOfX++;
                } else {
                    gamer = 'O';
                    numberOfY++;
                }
                emptyCells--;
                do {
                    if (scanner.hasNextInt()) {
                        x = scanner.nextInt();
                        y = scanner.nextInt();
                        if (x < 1 || x > 3 || y < 1 || y > 3) {
                            System.out.println("Coordinates should be from 1 to 3!");
                        } else if (matrix[Math.abs(3-y)][x-1] == '_') {
                            matrix[Math.abs(3-y)][x-1] = gamer;
                            correctInput = true;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                        }
                    } else {
                        System.out.println("You should enter numbers!");
                        scanner.nextLine();
                    }
                } while (!correctInput);
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
    }
}
