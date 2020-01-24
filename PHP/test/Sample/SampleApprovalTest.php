<?php
namespace Sample;

use PHPUnit\Framework\TestCase;
use ApprovalTests\Approvals;

class SampleApprovalTest extends TestCase {

    /**
     * @test
     */
    public function sample_array()
    {
        $list = ['zero', 'one', 'two', 'three', 'four', 'five'];
        Approvals::approveList($list);
    }

}