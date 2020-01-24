<?php
namespace Sample;

use PHPUnit\Framework\TestCase;

class SamplePhpUnitTest extends TestCase {

    /** @test */
    function testAddition() {
        $this->assertEquals(2, 1 + 1);
    }

}
