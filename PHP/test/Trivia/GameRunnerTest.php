<?php
namespace Trivia;

include(__DIR__.'/../../src/Trivia/GameRunner.php');

use PHPUnit\Framework\TestCase;
use ApprovalTests\Approvals;

class GameRunnerTest extends TestCase {

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
