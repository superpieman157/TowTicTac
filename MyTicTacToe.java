package Game;
import java.util.ArrayList;
import java.util.Scanner;
public class MyTicTacToe {
    public static boolean quit;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int xo;
        quit = true;
        int turn = 0;
        ArrayList<String> letters = new ArrayList<>();
        ArraySize(letters);
        displayGame(letters);
        while (quit) {
            System.out.println("\nWelcome to Tic Tac Toe, enter a number from the grid to start, 999 to quit");
            xo = input.nextInt();
            if (xo == 999)
                quit = false;
            if (turn % 2 == 0) {
                letters.set(xo, "X");
            } else
                letters.set(xo, "O");

            displayGame(letters);
            xWins(letters);
            oWins(letters);
            turn++;
            if (turn == 9) {
                System.out.println("Tie");
                quit = false;
            }
        }
    }
    public static void displayGame(ArrayList<String> letters) {
        for (int i = 0; i < letters.size(); i++) {
            if (i == 2 || i == 5 || i == 8) {
                System.out.print(letters.get(i) + " \n");
                System.out.print("---");
                System.out.print("---");
                System.out.print("---\n");
            } else if (i <= 7)
                System.out.print(letters.get(i) + " | ");
        }
    }
    public static void ArraySize(ArrayList<String> letters) {
        for (int j = 0; j < 9; j++) {
            letters.add(j, Integer.toString(j));
        }
    }
    public static void xWins(ArrayList <String> letters) {

        if (letters.get(0).equals("X") && letters.get(1).equals("X") && letters.get(2).equals("X") || letters.get(6).equals("X") && letters.get(4).equals("X") && letters.get(2).equals("X")
                || letters.get(6).equals("X") && letters.get(7).equals("X") && letters.get(8).equals("X") || letters.get(0).equals("X") && letters.get(3).equals("X") && letters.get(6).equals("X")
                || letters.get(1).equals("X") && letters.get(4).equals("X") && letters.get(7).equals("X") || letters.get(2).equals("X") && letters.get(5).equals("X") && letters.get(8).equals("X")
                || letters.get(0).equals("X") && letters.get(4).equals("X") && letters.get(8).equals("X")) {
            System.out.println("\nX Wins");
            quit = false;
        }
    } public static void oWins(ArrayList <String> letters) {

        if (letters.get(0).equals("O") && letters.get(1).equals("O") && letters.get(2).equals("O") || letters.get(6).equals("O") && letters.get(4).equals("O") && letters.get(2).equals("O")
                || letters.get(0).equals("O") && letters.get(1).equals("O") && letters.get(2).equals("O") || letters.get(6).equals("O") && letters.get(7).equals("O") && letters.get(8).equals("O")
                || letters.get(0).equals("O") && letters.get(3).equals("O") && letters.get(6).equals("O") || letters.get(1).equals("O") && letters.get(4).equals("O") && letters.get(7).equals("O")
                || letters.get(2).equals("O") && letters.get(5).equals("O") && letters.get(8).equals("O")) {
            System.out.println("\nO Wins");
            quit = false;
        }
    }
}