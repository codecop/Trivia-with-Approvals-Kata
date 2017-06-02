package com.adaptionsoft.games.uglytrivia;

public class MovePlayerOnBoard {

    private int[] places = new int[6];

    public String move(int roll, int currentPlayer, String name) {
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] > 11)
            places[currentPlayer] = places[currentPlayer] - 12;

        System.out.println(name + "'s new location is " + places[currentPlayer]);

        String currentCategory = currentCategory(currentPlayer);
        System.out.println("The category is " + currentCategory);
        return currentCategory;
    }

    private String currentCategory(int currentPlayer) {
        if (places[currentPlayer] == 0)
            return "Pop";
        if (places[currentPlayer] == 4)
            return "Pop";
        if (places[currentPlayer] == 8)
            return "Pop";
        if (places[currentPlayer] == 1)
            return "Science";
        if (places[currentPlayer] == 5)
            return "Science";
        if (places[currentPlayer] == 9)
            return "Science";
        if (places[currentPlayer] == 2)
            return "Sports";
        if (places[currentPlayer] == 6)
            return "Sports";
        if (places[currentPlayer] == 10)
            return "Sports";
        return "Rock";
    }

}
