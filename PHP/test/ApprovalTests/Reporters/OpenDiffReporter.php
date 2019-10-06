<?php
namespace ApprovalTests\Reporters;

use ApprovalTests\Reporters\Reporter;
use ApprovalTests\FileUtil;

class OpenDiffReporter extends GenericDiffReporterBase {

    public function reportFailure($approvedFilename, $receivedFilename) {
        FileUtil::createFileIfNotExists($approvedFilename);
        system(escapeshellcmd('opendiff') . ' ' .
                escapeshellarg($receivedFilename) . " " .
                escapeshellarg($approvedFilename));
    }
}
