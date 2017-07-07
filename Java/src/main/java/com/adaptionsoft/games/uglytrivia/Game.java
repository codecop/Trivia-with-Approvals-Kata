package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class Game {
    final MovePlayerOnBoard move = new MovePlayerOnBoard(6);
    final Ask ask = new Ask();
    final Score score = new Score(6);
    final AllowToPlay allow = new AllowToPlay(6);

    ArrayList<String> players = new ArrayList<>();
    int currentPlayer = 0;
    // TODO (name, currentPlayer) go together all the time. Would like to extract that. 
    // What is the verb? What is it doing? At the moment nothing, but it could as soon as it exists.
    // We discussed and said "it can get the name" - but that is just a wrapper around its state. Meh.

    boolean isGettingOutOfPenaltyBox;

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public void add(String playerName) {
        players.add(playerName);

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void moveAndAsk(int roll) {
        String name = players.get(currentPlayer);
        System.out.println(name + " is the current player");
        System.out.println("They have rolled a " + roll);

        boolean isLucky = roll % 2 != 0;
        // we should use a three state enum here really, but not related to constraint
        isGettingOutOfPenaltyBox = allow.isAllowed(name, currentPlayer, isLucky);
        if (isGettingOutOfPenaltyBox) {
            askQuestionOfDestinationPlace(roll);
        }
    }

    private void askQuestionOfDestinationPlace(int roll) {
        String name = players.get(currentPlayer);
        String currentCategory = move.move(name, currentPlayer, roll);
        ask.askQuestionFor(currentCategory);
    }

    // TODO maybe there is an Answer class inside here nevertheless which combines AllowToPlay and Score.
    
    public boolean wasCorrectlyAnswered() {
        final boolean didPlayerNotWin;

        boolean canAnswerQuestion = !allow.isDenied(currentPlayer) || isGettingOutOfPenaltyBox;
        if (canAnswerQuestion) {
            String name = players.get(currentPlayer);
            didPlayerNotWin = score.correctAnswer(name, currentPlayer);
        } else {
            didPlayerNotWin = true;
        }

        changePlayer();

        return didPlayerNotWin;
    }

    private void changePlayer() {
        currentPlayer = (currentPlayer + 1) % players.size();
    }

    public boolean wasWrongAnswered() {
        final boolean didPlayerNotWin;

        String name = players.get(currentPlayer);
        didPlayerNotWin = score.wrongAnswer(name, currentPlayer);

        allow.deny(name, currentPlayer);

        changePlayer();

        return didPlayerNotWin;
    }

}
