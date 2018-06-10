<?php
namespace PHPUnit\Framework;

use PHPUnit_Framework_ExpectationFailedException;

class ExpectationFailedException extends PHPUnit_Framework_ExpectationFailedException {

    public function __construct() {
        parent::__construct("Approvals reporter failed");
    }

}
