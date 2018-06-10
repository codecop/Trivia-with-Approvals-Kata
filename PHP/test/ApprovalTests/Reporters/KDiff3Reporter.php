<?php
namespace ApprovalTests\Reporters;

use ApprovalTests\Reporters\Reporter;
use ApprovalTests\FileUtil;

class KDiff3Reporter extends GenericDiffReporterBase {

    public function reportFailure($approvedFilename, $receivedFilename) {
        FileUtil::createFileIfNotExists($approvedFilename);
        system(escapeshellcmd('kdiff3') . " " .
                escapeshellarg($approvedFilename) . " " .
                escapeshellarg($receivedFilename) . " ");
    }

}
