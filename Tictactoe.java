import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String[] board;
    static String turn;

    static void printBoard() {  //Board creation -> put number in board for later
        System.out.println("|---|---|---|");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + board[i] + " | " + board[i + 1] + " | " + board[i + 2] + " |");
            System.out.println("|---|---|---|");
        }
    }

    static String checkWinner() { // Check the combination to win the game
        String[] win_combinations = {"123", "147", "159", "258", "357", "369", "456", "789"};

        for (String line : win_combinations) {
            String sequence = "" + board[line.charAt(0) - '1'] + board[line.charAt(1) - '1'] + board[line.charAt(2) - '1'];

            if (sequence.equals("XXX")) {
                return "X";
            }
            if (sequence.equals("OOO")) {
                return "O";
            }
        }

        if (Arrays.stream(board).allMatch(s -> s.equals("X") || s.equals("O"))) return "draw"; // check if the game is a draw

        return null;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;
        

        Arrays.fill(board, " "); // Fill the board with spaces

        printBoard();


        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Player goes first. Enter a number to place X in:");

        while (winner == null) {
            int numInput;

            try {
                numInput = in.nextInt();

                if (numInput < 1 || numInput > 9 || !board[numInput - 1].equals(" ")) { // check for wrong input
                    System.out.println("Invalid input; retry.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input; retry.");
                in.next();
                continue;
            }

            board[numInput - 1] = turn;
            turn = (turn.equals("X")) ? "O" : "X";

            printBoard();
            winner = checkWinner();
        }

        if (winner.equalsIgnoreCase("draw")) {  // print draw if result is draw
            System.out.println("It's a draw!");
        } else {
            System.out.println(winner + " has won! Thanks for playing.");
        }
        in.close();
    }
}
