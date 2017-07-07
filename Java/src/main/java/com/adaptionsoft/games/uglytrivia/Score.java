package com.adaptionsoft.games.uglytrivia;

public class Score {

    private final int[] purses;

    /*
     * This constructor should disappear when we have an Increase Purses function. Maybe we go to smaller functions.
     * TODO maybe introduce smaller/low level function/Verb class: increasePurse which wraps over the purses.
     */
    public Score(int numberOfPlayers) {
        purses = new int[numberOfPlayers];
    }

    public boolean correctAnswer(String name, int currentPlayer) {
        System.out.println("Answer was correct!!!!");
        purses[currentPlayer]++;
        System.out.println(name + " now has " + purses[currentPlayer] + " Gold Coins.");
        return didPlayerNotWin(currentPlayer);
    }

    public boolean wrongAnswer(@SuppressWarnings("unused") String name, int currentPlayer) {
        System.out.println("Question was incorrectly answered");
        return didPlayerNotWin(currentPlayer);
    }

    private boolean didPlayerNotWin(int currentPlayer) {
        boolean didPlayerWin = purses[currentPlayer] == 6;
        return !didPlayerWin;
    }

}

/*
 * Good class, it has symmetry.
 * Discussion of symmetry of similar functions vs. their enclosing scopes:
 * - Penalty box is of larger scope, cannot be here.
 * - after renaming this class to Score, it is clear that penalty box is not in Score (but it could have been in Answer).
 */
