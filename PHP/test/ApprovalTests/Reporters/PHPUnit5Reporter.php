<?php
namespace ApprovalTests\Reporters;

use PHPUnit_Framework_Assert;
use PHPUnit_Framework_ExpectationFailedException;

class PHPUnit5Reporter implements Reporter
{
    public function report($approvedFileContents, $receivedFileContents)
    {
        try {
            PHPUnit_Framework_Assert::assertEquals($approvedFileContents, $receivedFileContents);
            return true;
        } catch (PHPUnit_Framework_ExpectationFailedException $e) {
            return false;
        }
    }
}
