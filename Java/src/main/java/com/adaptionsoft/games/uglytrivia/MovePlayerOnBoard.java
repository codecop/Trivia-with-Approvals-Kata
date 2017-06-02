package com.adaptionsoft.games.uglytrivia;

public class MovePlayerOnBoard {

    private final int[] board;

    public MovePlayerOnBoard(int numberOfPlayers) {
        board = new int[numberOfPlayers];
    }

    public String move(int roll, int currentPlayer, String name) {
        board[currentPlayer] = board[currentPlayer] + roll;
        if (board[currentPlayer] > 11)
            board[currentPlayer] = board[currentPlayer] - 12;

        System.out.println(name + "'s new location is " + board[currentPlayer]);

        String currentCategory = currentCategory(currentPlayer);
        System.out.println("The category is " + currentCategory);
        return currentCategory;
    }

    private String currentCategory(int currentPlayer) {
        if (board[currentPlayer] == 0)
            return "Pop";
        if (board[currentPlayer] == 4)
            return "Pop";
        if (board[currentPlayer] == 8)
            return "Pop";
        if (board[currentPlayer] == 1)
            return "Science";
        if (board[currentPlayer] == 5)
            return "Science";
        if (board[currentPlayer] == 9)
            return "Science";
        if (board[currentPlayer] == 2)
            return "Sports";
        if (board[currentPlayer] == 6)
            return "Sports";
        if (board[currentPlayer] == 10)
            return "Sports";
        return "Rock";
    }

}

/*
 * notice inconsistent naming of class vs. method name.
 * We only have class with one method - how is name meaningful.
 * This is the board. Can we escape our mental image of Objects as state?
 * But this was selected only looking at behaviour.
*/
