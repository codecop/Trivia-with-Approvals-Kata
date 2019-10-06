<?php
namespace ApprovalTests\Reporters;

use ApprovalTests\Reporters\Reporter;
use ApprovalTests\Namers\PHPUnitNamer;
use ApprovalTests\FileUtil;
use PHPUnit_Framework_Assert;

/**
 * Adapter between old and new reporters.
 */
abstract class GenericDiffReporterBase implements Reporter {

    public function report($approvedFileContents, $receivedFileContents) {

        if ($approvedFileContents == $receivedFileContents) {
            PHPUnit_Framework_Assert::assertTrue(true);
            return true;
        }

        // hardcoded stuff to get going
        $extension = 'txt';
        $namer = new PHPUnitNamer();
        $approvedFilename = $namer->getApprovedFile($extension);
        $receivedFilename = $namer->getReceivedFile($extension);
        $this->reportFailure($approvedFilename, $receivedFilename);

        return false;
    }

    public abstract function reportFailure($approvedFilename, $receivedFilename);

}
