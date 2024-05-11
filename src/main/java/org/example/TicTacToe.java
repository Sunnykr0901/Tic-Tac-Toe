package org.example;

public class TicTacToe {
    private final char[][] ticTacToe = new char[3][3];

    public TicTacToe() {
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToe[i][j] = (char) ('A' + 3*i + j);
            }
        }
        print();
    }

    public char getPositionValue(int x, int y) {
        return ticTacToe[x][y];
    }

    public boolean setPositionValue(int x, int y, char ch) {
        if (ticTacToe[x][y] == 'X' || ticTacToe[x][y] == 'O') {
            return false;
        }
        ticTacToe[x][y] = ch;
        print();
        return true;
    }

    private void print() {
        for (int i = 0; i < 3 ; i++) {
            System.out.print("-------------\n");
            for (int j = 0; j < 3; j++) {
                System.out.print("| "+ ticTacToe[i][j] + " ");
                if (j == 2) {
                    System.out.print("|\n");
                }
            }
        }
        System.out.print("-------------\n");
    }
}
