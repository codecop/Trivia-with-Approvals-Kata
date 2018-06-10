<?php
namespace Trivia;

use ApprovalTests\Approvals;
// use ApprovalTests\Reporters\KDiff3Reporter;

class SampleApprovalTest extends \PHPUnit_Framework_TestCase {

    public static function setUpBeforeClass()
    {
        // Approvals::useReporter(new KDiff3Reporter());
    }

    /**
     * @test
     */
    public function sample_array()
    {
        $list = ['zero', 'one', 'two', 'three', 'four', 'five'];
        Approvals::approveList($list);
    }

}