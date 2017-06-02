package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Ask {

    private LinkedList popQuestions = new LinkedList();
    private LinkedList scienceQuestions = new LinkedList();
    private LinkedList sportsQuestions = new LinkedList();
    private LinkedList rockQuestions = new LinkedList();

    public Ask() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    private String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public void ask(String currentCategory) {
        if (currentCategory == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (currentCategory == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }

}
