# Ugly Trivia with Approvals Kata C99 Setup

This is a bunch of C99 files.

To run the game:

    gcc -g -Wall -Wextra -pedantic -std=c99 game.c game_runner_main.c -o game_runner_main.exe
    .\game_runner_main.exe

To run tests with cmocka:

    gcc -g -Wall -Wextra -pedantic -std=c99 ..\game.c %APPROVALS_HOME%\src\approvals.c GameTest.c -l cmocka -o GameTest.exe
    .\GameTest.exe

* See [Trivia code base](https://github.com/caradojo/trivia).
* Create unit tests with [cmocka](https://cmocka.org/).
* See [ApprovalTests for C](https://github.com/codecop/ApprovalTests.c).
