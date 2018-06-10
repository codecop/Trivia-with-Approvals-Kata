<?php
namespace Trivia;

use ApprovalTests\Approvals;

class SampleApprovalTest extends \PHPUnit_Framework_TestCase {

    /**
     * @test
     */
    public function sample_array()
    {
        $list = ['zero', 'one', 'two', 'three', 'four', 'five'];
        Approvals::approveList($list);
    }

}