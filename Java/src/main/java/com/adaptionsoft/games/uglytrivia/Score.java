package com.adaptionsoft.games.uglytrivia;

public class Score {

    private final int[] purses;

    /*
     * this constructor should disappear when we have an Increase Purses
     * function
     */
    public Score(int numberOfPlayers) {
        purses = new int[numberOfPlayers];
    }

    public boolean correct(String name, int currentPlayer) {
        System.out.println("Answer was correct!!!!");
        purses[currentPlayer]++;
        System.out.println(name + " now has " + purses[currentPlayer] + " Gold Coins.");
        return didPlayerNotWin(currentPlayer);
    }

    public boolean wrong(String name, int currentPlayer) {
        System.out.println("Question was incorrectly answered");
        return didPlayerNotWin(currentPlayer);
    }
    
    private boolean didPlayerNotWin(int currentPlayer) {
        boolean didPlayerWin = purses[currentPlayer] == 6;
        return !didPlayerWin;
    }

    /*
     * Good class, it has symetry
     */
}
