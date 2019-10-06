<?php
namespace Trivia;

include(__DIR__.'/../../src/Trivia/GameRunner.php');

use ApprovalTests\Approvals;
// use ApprovalTests\Reporters\KDiff3Reporter;

class GameRunnerTest extends \PHPUnit_Framework_TestCase {

    public static function setUpBeforeClass()
    {
        // Approvals::useReporter(new KDiff3Reporter());
    }

    /**
     * @test
     */
    public function runs_whole_game()
    {
        $numTests = 25;
        srand(0);
        ob_start();

        for ($run = 0; $run < $numTests; $run += 1) {
            play();
        }

        $gameConsoleOutput = ob_get_clean();

        Approvals::approveString($gameConsoleOutput);
    }

}
