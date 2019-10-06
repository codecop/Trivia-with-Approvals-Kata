<?php
namespace ApprovalTests\Reporters;

use ApprovalTests\Reporters\Reporter;
use ApprovalTests\FileUtil;

class ViDiffReporter extends GenericDiffReporterBase {

    public function reportFailure($approvedFilename, $receivedFilename) {
        FileUtil::createFileIfNotExists($approvedFilename);
        system("echo '#!/bin/sh' > /tmp/reporter.command; echo 'vimdiff " .
                escapeshellarg($approvedFilename) . " " .
                escapeshellarg($receivedFilename) .
                "' > /tmp/reporter.command; chmod +x /tmp/reporter.command; open /tmp/reporter.command");
    }

}
