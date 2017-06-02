package com.adaptionsoft.games.uglytrivia;

public class MovePlayerOnBoard {

    private final int[] playerPositions;

    public MovePlayerOnBoard(int numberOfPlayers) {
        playerPositions = new int[numberOfPlayers];
    }

    public String move(String playerName, int currentPlayer, int byPlaces) {
        playerPositions[currentPlayer] = playerPositions[currentPlayer] + byPlaces;
        if (playerPositions[currentPlayer] > 11)
            playerPositions[currentPlayer] = playerPositions[currentPlayer] - 12;

        System.out.println(playerName + "'s new location is " + playerPositions[currentPlayer]);

        String currentCategory = currentCategory(currentPlayer);
        System.out.println("The category is " + currentCategory);
        return currentCategory;
    }

    private String currentCategory(int currentPlayer) {
        if (playerPositions[currentPlayer] == 0)
            return "Pop";
        if (playerPositions[currentPlayer] == 4)
            return "Pop";
        if (playerPositions[currentPlayer] == 8)
            return "Pop";
        if (playerPositions[currentPlayer] == 1)
            return "Science";
        if (playerPositions[currentPlayer] == 5)
            return "Science";
        if (playerPositions[currentPlayer] == 9)
            return "Science";
        if (playerPositions[currentPlayer] == 2)
            return "Sports";
        if (playerPositions[currentPlayer] == 6)
            return "Sports";
        if (playerPositions[currentPlayer] == 10)
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
