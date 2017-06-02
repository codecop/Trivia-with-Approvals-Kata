package com.adaptionsoft.games.uglytrivia;

public class AnswerQuestion {

    private final int[] purses;

    public AnswerQuestion(int numberOfPlayers) {
        purses = new int[numberOfPlayers];
    }

    public boolean correct(String name, int currentPlayer) {
        System.out.println("Answer was correct!!!!");
        purses[currentPlayer]++;
        System.out.println(name + " now has " + purses[currentPlayer] + " Gold Coins.");

        return didPlayerNotWin(currentPlayer);
    }

    public boolean corrent(String name, int currentPlayer) {
        return correct(name, currentPlayer);
    }

    private boolean didPlayerNotWin(int currentPlayer) {
        boolean didPlayerWin = purses[currentPlayer] == 6;
        return !didPlayerWin;
    }

    // TODO move wrong answer here as well.
    // TODO comment on this class
    
}
