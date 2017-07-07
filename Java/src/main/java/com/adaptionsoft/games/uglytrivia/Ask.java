package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Ask {

    private final LinkedList<String> popQuestions = new LinkedList<>();
    private final LinkedList<String> scienceQuestions = new LinkedList<>();
    private final LinkedList<String> sportsQuestions = new LinkedList<>();
    private final LinkedList<String> rockQuestions = new LinkedList<>();

    public Ask() {
        createQuestions(50);
    }

    private void createQuestions(int numberOfQuestion) {
        for (int i = 0; i < numberOfQuestion; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast("Science Question " + i);
            sportsQuestions.addLast("Sports Question " + i);
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    public void askQuestionFor(String currentCategory) {
        String question = "";
        if (currentCategory == "Pop") {
            question = popQuestions.removeFirst();
        }
        if (currentCategory == "Science") {
            question = scienceQuestions.removeFirst();
        }
        if (currentCategory == "Sports") {
            question = sportsQuestions.removeFirst();
        }
        if (currentCategory == "Rock") {
            question = rockQuestions.removeFirst();
        }
        System.out.println(question);
    }

}

/*
 * By accident we extracted a reasonable class.
 * Maybe better name would be Questions or QuestionsDeck. But that would be violating the rules
 * It is a closure over the question lists.
 *
 * In functional programming this would be named something like CreateAskQuestionFn
 */