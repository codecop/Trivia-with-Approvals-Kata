package com.adaptionsoft.games.uglytrivia;

public class AllowToPlay {

    private final boolean[] inPenaltyBox;

    public AllowToPlay(int numberOfPlayers) {
        inPenaltyBox = new boolean[numberOfPlayers];
    }

    public boolean isAllowed(String name, int currentPlayer, boolean isLucky) {
        if (!inPenaltyBox[currentPlayer]) {
            return true;

        } else if (isLucky) {
            System.out.println(name + " is getting out of the penalty box");
            return true;
        } else {
            System.out.println(name + " is not getting out of the penalty box");
            return false;
        }
    }

    public boolean isDenied(int currentPlayer) {
        return inPenaltyBox[currentPlayer];
    }

    public void deny(String name, int curentPlayer) {
        System.out.println(name + " was sent to the penalty box");
        inPenaltyBox[curentPlayer] = true;
    }

}

/*
 * Started from inPenaltyBox.
 * difficult but able to extract code that deals with that.
 * it is a decision, it decides.
 * but we seem to have primary state here, so we cannot find a verb
 * it also does more with the `askQuestionOfDestinationPlace` inside.
 * tried to abstract out logic to make verb pure
*/
