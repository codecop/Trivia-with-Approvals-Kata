# Ugly Trivia with Approvals Kata #

by [Johan Martinsson](https://bitbucket.org/jmartinsson/) and [Peter Kofler](https://bitbucket.org/pkofler/). 

* See [Trivia code base](https://github.com/caradojo/trivia).
* See [ApprovalTests](https://github.com/approvals/ApprovalTests.Java).

## Constraint: Verbs instead of Nouns

Verbs instead of Nouns is a stretch activity, see [Coderetreat activities](http://coderetreat.org/facilitating/activity-catalog).
There is a [discussion how to meet the constraint](http://coderetreat.org/group/facilitators/forum/topics/verbs-instead-of-nouns).
* e.g. separate value objects from operations, and build service objects for the operations.
* e.g. not think about what a class IS (or what it represents), but what it DOES. This helps keeping the SoC and the classes small and simple. So it only applies to class names.

Immutability is out of scope here. It is difficult. The current code is state based.

### Thoughts
* Peter has worked with the constraint in Coderetreats but not sure enough to facilitate it.
    * Problems explaining it.
    * Not sure about the learning goal.
  
* When doing functional programming this is natural. All activities are verbs (functions).
* What is a good exercise to apply that constraint?
    * Not algorithmic because an algorithm is mainly functional and that suits the constraint.
    * Must have some state and mutate that.
    * What about refactoring towards the constraint?

* (Johan) What is this exercise bringing? What is it open up to?
    * Till now we only encapsulated primitives. Is there more?
    * That would need to be checked.

## Retrospectives

### Notes from extracted classes

* `Ask`
    * By accident we extracted a reasonable class.
    * Maybe a better name would be Questions or QuestionsDeck. But that would be violating the rules.
    * It is a closure over the question lists.
    * In functional programming this would be named something like createAskQuestionFn.

* `MovePlayerOnBoard` (was `Move`)
     * Notice the inconsistent naming of class vs. method names.
     * We only have a class with one method - how is the name meaningful?
     * This is the board. Can we escape our mental image of Objects as state?
     * But this was selected only looking at behaviour. So it must be good.

* `Score` (was `Answer`)
     * The constructor should disappear when we have an Increase Purses function. Maybe we go to smaller functions.
     * Good class, it has symmetry.
     * Discussion of symmetry of similar functions vs. their enclosing scopes:
     * Penalty box is of larger scope, cannot be here.
     * after renaming this class to Score, it is clear that penalty box is not in Score (but it could have been in Answer).

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

### 07.07.2017

* as going forward, some verbs are not standing out strong as others.
* some verbs are small, like `increasePurse`, some are higher level like `moveAndAsk`
* Finding: Smaller verb is easier to extract.
* Peter felt somehow stuck.
     * last time, good progress, 3 good verbs
     * extracted things made sense
     * today we cannot see any more words
* we seem to have primary state here, so we cannot find a verb
* remaining methods also do more
* we tried to abstract out logic to make verbs pure
* not sure it gave me something today
* unsure how to handle state with these rules.
* surprised that it is so much more difficult today and it is getting more difficult

### Notes
* IDEA plugin ForceShortcut

### License ###
[New BSD License](http://opensource.org/licenses/bsd-license.php), see `license.txt` in repository.
