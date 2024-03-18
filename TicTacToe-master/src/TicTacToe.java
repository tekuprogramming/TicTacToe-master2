import java.util.Scanner;

public class TicTacToe {
    private static char[][] board;
    private static final int SIZE = 3;

    public TicTacToe() {
        initializeBoard();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        while (true) {
            System.out.println("Player " + currentPlayer + ", input the position (row and column separated by a space):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid position, try again.");
            }
        }



    }

    public void initializeBoard() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.println(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-';
    }
}
