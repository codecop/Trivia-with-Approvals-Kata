package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class Game {
    final MovePlayerOnBoard move = new MovePlayerOnBoard(6);
    final Ask ask = new Ask();
    final Score score = new Score(6);

    ArrayList<String> players = new ArrayList<>();
    boolean[] inPenaltyBox = new boolean[6];

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean add(String playerName) {
        players.add(playerName);

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }


    public void moveAndAsk(int roll) {
        boolean isLucky = roll % 2 != 0;
        Runnable doSomething = () -> askQuestionOfDestinationPlace(roll);

        System.out.println(players.get(currentPlayer) + " is the current player");
        System.out.println("They have rolled a " + roll);

        handle(players.get(currentPlayer), isLucky, doSomething);

    }

    private void handle(String name, boolean isLucky, Runnable doSomething) {
        if (!inPenaltyBox[currentPlayer]) {
            doSomething.run();

        } else if (isLucky) {
            System.out.println(name + " is getting out of the penalty box");
            isGettingOutOfPenaltyBox = true;
            doSomething.run();

        } else {
            System.out.println(name + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
        }
    }

    private void askQuestionOfDestinationPlace(int roll) {
        String name = players.get(currentPlayer);
        String currentCategory = move.move(name, currentPlayer, roll);
        ask.askQuestionFor(currentCategory);
    }

    public boolean wasCorrectlyAnswered() {
        final boolean didPlayerNotWin;
        if (canAnswerQuestion()) {
            String name = players.get(currentPlayer);
            didPlayerNotWin = score.correctAnswer(name, currentPlayer);

        } else {
            didPlayerNotWin = true;
        }

        changePlayer();

        return didPlayerNotWin;
    }

    private boolean canAnswerQuestion() {
        return !inPenaltyBox[currentPlayer] || isGettingOutOfPenaltyBox;
    }

    private void changePlayer() {
        currentPlayer = (currentPlayer + 1) % players.size();
    }

    public boolean wrongAnswer() {
        String name = players.get(currentPlayer);
        boolean didPlayerNotWin = score.wrongAnswer(name, currentPlayer);

        inPenaltyBox[currentPlayer] = true;
        System.out.println(name + " was sent to the penalty box");

        changePlayer();

        return didPlayerNotWin;
    }

}
