import java.util.Scanner;

public class TicTacToe {
    private static char[][] board;
    private static final int SIZE = 3;
    private static int scoreX = 0;
    private static int scoreO = 0;

    public TicTacToe() {
        initializeBoard();
    }

    public static void playMultipleGames() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            initializeBoard();
            printBoard();

            playGame(scanner);

            System.out.println("Player X won: " + scoreX + " times, Player O won: " + scoreO + " times");
            System.out.println("Do you want to play again? (Y/N)");
            String again = scanner.next();
            if (!again.equalsIgnoreCase("Y")) {
                break;
            }
        }

        scanner.close();
    }

    public static void playGame(Scanner scanner) {
        char currentPlayer = 'X';

        while (true) {
            System.out.println("Player " + currentPlayer + ", input the position (row and column separated by a space):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();

                if (isWinner(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " won!");
                    updateScore(currentPlayer);
                    break;
                }

                if (isBoardFull()) {
                    System.out.println("It's a tie!");
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid position, try again.");
            }
        }
    }
        public static void initializeBoard () {
            board = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    board[i][j] = '-';
                }
            }
        }

        public static void printBoard () {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.println(board[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static boolean isValidMove (int row, int col){
            return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-';
        }

        public static boolean isWinner(char player) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                return true;
            }
            return board[0][2] == player && board[1][1] == player && board[2][0] == player;
        }

        public static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
        }

        public static void updateScore(char player) {
        if (player == 'X') {
            scoreX++;
        } else {
            scoreO++;
        }
        }
}
