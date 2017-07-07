package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class Game {
    final MovePlayerOnBoard move = new MovePlayerOnBoard(6);
    final Ask ask = new Ask();
    final AnswerQuestion answer = new AnswerQuestion(6);

    ArrayList<String> players = new ArrayList<>();
    boolean[] inPenaltyBox  = new boolean[6];

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

	public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}

	public boolean add(String playerName) {
	    players.add(playerName);
	    inPenaltyBox[howManyPlayers()] = false;

	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.size());
		return true;
	}

	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
		System.out.println(players.get(currentPlayer) + " is the current player");
		System.out.println("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

				System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");

				String name = players.get(currentPlayer);
				String currentCategory = move.move(name, currentPlayer, roll);
				ask.askQuestionFor(currentCategory);

			} else {
				System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
			}

		} else {

            String name = players.get(currentPlayer);
			String currentCategory = move.move(name, currentPlayer, roll);
			ask.askQuestionFor(currentCategory);
		}
	}

	public boolean wasCorrectlyAnswered() {
	    boolean winner = true;
        if (!inPenaltyBox[currentPlayer] || isGettingOutOfPenaltyBox){
			    String name = players.get(currentPlayer);
				winner = answer.correct(name, currentPlayer);

		}

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;

        return winner;
	}

	public boolean wrongAnswer(){


	    String name = players.get(currentPlayer);
        boolean didPlayerNotWin = answer.wrong(name, currentPlayer);

        inPenaltyBox[currentPlayer] = true;
        System.out.println(name+ " was sent to the penalty box");

		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;

        return didPlayerNotWin;
	}

}
