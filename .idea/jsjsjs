// Import Classes

import java.util.Arrays; // Manipulating arrays
import java.util.InputMismatchException; // If it's not expected type
import java.util.Scanner; // To read input data


// Main class of the program
public class Main {
    static String[] board;
    static String turn;

    static String checkWinner() {

        // The possibilites to win
        String[] winningCombinations = {"123", "147", "159", "258", "357",  "369", "456", "789"};

        for (String line : winningCombinations) {
            String sequence = "" + board[line.charAt(0) - '1'] + board[line.charAt(1) - '1'] + board[line.charAt(2) - '1'];

            if (sequence.equals("XXX")) return "X";
            if (sequence.equals("OOO")) return "O";
        }

        if (Arrays.stream(board).allMatch(s -> s.equals("X") || s.equals("O"))) return "draw";

        return null;
    }

    static void printBoard() {
        // The tictactoe printed board
        System.out.println("|---|---|---|");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + board[i] + " | " + board[i + 1] + " | " + board[i + 2] + " |");
            System.out.println("|---|---|---|");
        }
    }

    public static void main(String[] args) {
        // Main methode that return previous methods
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }

        printBoard();

        System.out.println("X is the first player. Enter a number to place X in:");

        // Retry if you write an invalid input

        while (winner == null) {
            int numInput;

            try {
                numInput = in.nextInt();
                if (numInput < 1 || numInput > 9 || !board[numInput - 1].equals(String.valueOf(numInput))) {
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

        // Ends the program if it's a draw or a win

        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw!");
        } else {
            System.out.println(winner + " has won! Thanks for playing.");
        }
        in.close();
    }
}