package miniProject;
import java.util.Scanner;


public class TIC_TAC_TOE {

    // Display the game board
    static void displayBoard(char[][] board) {
        System.out.println("\n-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // Check whether a player has won
    static boolean checkWinner(char[][] b, char p) {

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((b[i][0] == p && b[i][1] == p && b[i][2] == p) ||
                (b[0][i] == p && b[1][i] == p && b[2][i] == p)) {
                return true;
            }
        }

        // Check diagonals
        if ((b[0][0] == p && b[1][1] == p && b[2][2] == p) ||
            (b[0][2] == p && b[1][1] == p && b[2][0] == p)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };

        char player = 'X';
        int moves = 0;

        while (moves < 9) {

            displayBoard(board);

            System.out.print("Player " + player +
                             ", enter a position (1-9): ");

            int choice = sc.nextInt();

            if (choice < 1 || choice > 9) {
                System.out.println("Invalid position!");
                continue;
            }

            int row = (choice - 1) / 3;
            int col = (choice - 1) % 3;

            // Prevent overwriting an occupied position
            if (board[row][col] == 'X' ||
                board[row][col] == 'O') {
                System.out.println("Position already occupied!");
                continue;
            }

            board[row][col] = player;
            moves++;

            if (checkWinner(board, player)) {
                displayBoard(board);
                System.out.println("Player " + player + " wins!");
                sc.close();
                return;
            }

            // Switch between X and O
            player = (player == 'X') ? 'O' : 'X';
        }

        displayBoard(board);
        System.out.println("Game Draw!");

        sc.close();
    }
}
