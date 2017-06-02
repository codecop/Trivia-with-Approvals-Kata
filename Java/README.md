# Ugly Trivia with Approvals Kata #

by Johan Martinsson and Peter Kofler. 

* See [Trivia code base](https://github.com/caradojo/trivia).
* See [ApprovalTests](https://github.com/approvals/ApprovalTests.Java).

## Constraint: Verbs instead of Nouns

Verbs instead of Nouns is a stretch activity, see [Coderetreat activities](http://coderetreat.org/facilitating/activity-catalog).
There is a [discussion how to meet the constraint](http://coderetreat.org/group/facilitators/forum/topics/verbs-instead-of-nouns).
* e.g. separate value objects from operations, and build service objects for the operations.
* e.g. not think about what a class IS (or what it represents), but what it DOES. This helps keeping the SoC and the classes small and simple. So it only applies to class names.

### Thoughts
* Peter has worked with the constraint in Coderetreats but not sure enough to facilitate it.

    * Problems explaining it.
    * Not sure about the learning goal.
  
* When doing functional programming this is natural. All activities are verbs (functions).
* What is a good exercise to apply that constraint?

    * Not algorithmic because an algorithm is mainly functional and that suits the constraint.
    * Must have some state and mutate that.
    * What about refactoring towards the constraint?

## Retrospective

* Ask

    * By accident we extracted a reasonable class.
    * Maybe better name would be Questions or QuestionsDeck.
    * It is a closure over the question lists.

* Move

    * Notice inconsistent naming of class vs. method name.
    * We only have class with one method - how is name meaningful.
    * This is the board. Can we escape our mental image of Objects as state?
    * But this was selected only looking at behaviour.

### 02.06.2017

* naming as verbs allows to split large clients into aspects of data
* we have the verb and repeat the verb in method name
* value is we can split big classes this way
* natural in functional programming
* the important state is what we are mutating
* when mutating the subject we should concentrate on subject
* not sure if functions closing over state is compatible with original idea
* good use of time, interesting views.
* unexpected problem/kata, especially refactoring approach
* but "are we really getting it?"
* we did not focus on clean/baby steps. Code needs cleanup.

### License ###
[New BSD License](http://opensource.org/licenses/bsd-license.php), see `license.txt` in repository.
