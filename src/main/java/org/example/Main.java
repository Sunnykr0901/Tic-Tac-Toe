package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("Sunny");
        Player player2 = new Player("Rahul");
        Scanner myObj = new Scanner(System.in);
        int count = 0;
        String winner = null;
        System.out.printf("Player 1: %s, Player 2: %s\n", player1.name(), player2.name());
        TicTacToe ticTacToe = new TicTacToe();
        System.out.println("Start the game.\n");
        while(count <= 10) {
            System.out.println("Enter position value.\n");
            int x = myObj.nextInt();
            int y = myObj.nextInt();
            char ch = 'X';
            String player = player1.name();
            if (count % 2 == 1) {
                ch = 'O';
                player = player2.name();
            }
            while(!ticTacToe.setPositionValue(x, y, ch)) {
                System.out.printf("Wrong position chosen: (%s, %s) by %s\n", x, y, player);
                x = myObj.nextInt();
                y = myObj.nextInt();
            }
            System.out.printf("%s is entering the value %s at position (%s, %s)\n", player, ch, x, y);
            if (winCondition(ticTacToe)) {
                winner = count % 2 == 0 ? player1.name() : player2.name();
                System.out.println("We got the winner and the game stopped.");
                break;
            }
            count = count + 1;
        }

        if (winner == null) {
            System.out.println("No one has won the game.");
        } else {
            System.out.printf(String.format("%s has won the game.", winner));
        }
    }

    private static boolean winCondition(TicTacToe ticTacToe) {
        return ((ticTacToe.getPositionValue(0, 0) == ticTacToe.getPositionValue(0, 1))
        && (ticTacToe.getPositionValue(0, 0) == ticTacToe.getPositionValue(0, 2)))
                || ((ticTacToe.getPositionValue(0, 0) == ticTacToe.getPositionValue(1, 1))
                && (ticTacToe.getPositionValue(0, 0) == ticTacToe.getPositionValue(2, 2)))
                || ((ticTacToe.getPositionValue(0, 0) == ticTacToe.getPositionValue(1, 0))
                && (ticTacToe.getPositionValue(0, 0) == ticTacToe.getPositionValue(2, 0)))
                || ((ticTacToe.getPositionValue(0, 1) == ticTacToe.getPositionValue(1, 1))
                && (ticTacToe.getPositionValue(0, 1) == ticTacToe.getPositionValue(2, 1)))
                || ((ticTacToe.getPositionValue(0, 2) == ticTacToe.getPositionValue(1, 2))
                && (ticTacToe.getPositionValue(0, 2) == ticTacToe.getPositionValue(2, 2)))
                || ((ticTacToe.getPositionValue(0, 2) == ticTacToe.getPositionValue(1, 1))
                && (ticTacToe.getPositionValue(0, 2) == ticTacToe.getPositionValue(2, 0)))
                || ((ticTacToe.getPositionValue(1, 0) == ticTacToe.getPositionValue(1, 1))
                && (ticTacToe.getPositionValue(1, 0) == ticTacToe.getPositionValue(1, 2)))
                || ((ticTacToe.getPositionValue(2, 0) == ticTacToe.getPositionValue(2, 1))
                && (ticTacToe.getPositionValue(2, 0) == ticTacToe.getPositionValue(2, 2)))
                || ((ticTacToe.getPositionValue(0, 0) == ticTacToe.getPositionValue(0, 1))
                && (ticTacToe.getPositionValue(0, 0) == ticTacToe.getPositionValue(0, 2)));
    }
}