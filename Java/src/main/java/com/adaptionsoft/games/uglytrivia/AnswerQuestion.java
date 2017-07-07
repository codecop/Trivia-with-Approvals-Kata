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

    public boolean wrong(String name, int currentPlayer) {
        System.out.println("Question was incorrectly answered");
        return didPlayerNotWin(currentPlayer);
    }
    
    private boolean didPlayerNotWin(int currentPlayer) {
        boolean didPlayerWin = purses[currentPlayer] == 6;
        return !didPlayerWin;
    }

    // TODO comment on this class
    
}
