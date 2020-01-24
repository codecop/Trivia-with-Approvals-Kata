<?php
namespace Trivia;

include(__DIR__.'/../../src/Trivia/GameRunner.php');

use PHPUnit\Framework\TestCase;
use ApprovalTests\Approvals;

class WholeGameTest extends TestCase {

    /**
     * @test
     */
    public function plays_trivia()
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
