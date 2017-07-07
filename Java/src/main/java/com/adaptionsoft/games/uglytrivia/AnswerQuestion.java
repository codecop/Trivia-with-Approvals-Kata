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

    private boolean didPlayerNotWin(int currentPlayer) {
        boolean didPlayerWin = purses[currentPlayer] == 6;
        return !didPlayerWin;
    }

    boolean wrong(String name, int currentPlayer) {
        System.out.println("Question was incorrectly answered");
        System.out.println(name+ " was sent to the penalty box");
        return didPlayerNotWin(currentPlayer);
    }

    // TODO comment on this class
    
}
