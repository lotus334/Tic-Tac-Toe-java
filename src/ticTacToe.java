import java.util.Scanner;

/*
The game starts with empty cells and ends when someone wins or there is a draw
The bottom left cell has the coordinates (1, 1) and the top right cell has the coordinates (3, 3) like in this table:

(1, 3) (2, 3) (3, 3)
(1, 2) (2, 2) (3, 2)
(1, 1) (2, 1) (3, 1)

If the user input is unsuitable, the program asks him to enter coordinates again

INPUT: two numbers from 1 to 3;
OUTPUT: updated the game field;
 */

public class ticTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char gamer = ' ';
        boolean gameOver = false;
        boolean correctInput;
        int emptyCells = 9;
        int numberOfX = 0;
        int numberOfY = 0;
        int x;
        int y;

        char[][] matrix = new char[3][3]; // creates multi-dimension array;

        // fills in cells of array;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = '_';
            }
        }

        // prints out the game field;
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

            // checks if there is winer or not.If no winer found and no empty cells in the field - prints "Draw".
            for (int i = 0; i < 3; i++) {
                if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2] && matrix[i][0] != '_') {
                    gameOver = true;
                } else if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i] && matrix[0][i] != '_') {
                    gameOver = true;
                } else if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[0][0] != '_') {
                    gameOver = true;
                } else if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0] && matrix[1][1] != '_') {
                    gameOver = true;
                }
                if (gameOver) {
                    System.out.println(gamer + " wins");
                    break;
                } else if (numberOfX + numberOfY == 9) {
                    System.out.println("Draw");
                    gameOver = true;
                    break;
                }
            }

            // does next move of game;
            if (!gameOver) {
                correctInput = false;
                System.out.println("Enter the coordinates: ");

                // change gamer from Xs to Os;
                if (emptyCells % 2 == 0) {
                    gamer = 'X';
                    numberOfX++;
                } else {
                    gamer = 'O';
                    numberOfY++;
                }
                emptyCells--;

                // checks whether the input is correct;
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

                // prints out the game field after each move;
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
