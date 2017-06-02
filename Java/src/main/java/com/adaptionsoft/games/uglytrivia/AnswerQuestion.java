package com.adaptionsoft.games.uglytrivia;

public class AnswerQuestion {

    private final int[] purses;

    public AnswerQuestion(int numberOfPlayers) {
        purses = new int[numberOfPlayers];
    }

    public boolean correct(String name, int currentPlayer) {
        System.out.println("Answer was correct!!!!");
        purses[currentPlayer]++;
        System.out.println(name
                + " now has "
                + purses[currentPlayer]
                + " Gold Coins.");
        
        boolean winner = didPlayerWin(currentPlayer);
        return winner;
    }
    
    public boolean corrent(String name, int currentPlayer) {
        System.out.println("Answer was corrent!!!!");
        purses[currentPlayer]++;
        System.out.println(name 
                + " now has "
                + purses[currentPlayer]
                + " Gold Coins.");
        
        boolean winner = didPlayerWin(currentPlayer);
        return winner;
    }

    private boolean didPlayerWin(int currentPlayer) {
        return !(purses[currentPlayer] == 6);
    }

}
