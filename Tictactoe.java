import java.util.Arrays; // Manipulating arrays
import java.util.InputMismatchException; // If it's not expected type
import java.util.Scanner; // To read input data


public class Main {
    static String[] board;
    static String turn;

    static void playing_Board() {
        System.out.println("|---|---|---|");
        for (int i = 0; i < 9; i+= 3) {
            System.out.println("| " + board[i] + " | " + board[i + 1] + " | " + board[i + 2] + " |");
            System.out.println("|---|---|---|");
        }
    }

    static String check_Winner() {

        String[] win_combination = {"123", "147", "159", "258", "357",  "369", "456", "789"};   //winning possibilities

        for (String line : win_combination) {
            String sequence = "" + board[line.charAt(0) - '1'] + board[line.charAt(1) - '1'] + board[line.charAt(2) - '1'];

            if (sequence.equals("XXX")) return "X";
            if (sequence.equals("OOO")) return "O";
        }

        if (Arrays.stream(board).allMatch(s -> s.equals("X") || s.equals("O"))) return "draw";

        return null;
    }

    }

}
