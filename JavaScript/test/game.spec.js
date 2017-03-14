/* globals describe, it, expect, beforeEach, afterEach */
'use strict';

require('../src/game.js');
require('approvals').jasmine();

var KDiff3Reporter = require('./approvals/Reporters/kdiff3Reporter.js');
var approvalConfig = { reporters: [ new KDiff3Reporter(), "DoNothing" ] };

describe("Ugly Trivia", function() {

  var gameConsoleOutput;
  /**
   * @var string
   */
  var originalConsoleLog;

  /**
   * @param msg string
   */
  function gameConsoleLog(msg) {
    gameConsoleOutput += msg + "\r\n";
  }

  beforeEach(function () {
    // prepare capturing console.log to our own gameConsoleLog.
    gameConsoleOutput = '';
    originalConsoleLog = console.log;
    console.log = gameConsoleLog;
  });

  afterEach(function () {
    // reset original console.log
    console.log = originalConsoleLog;
  });

  it("should access game", function() {
    expect(Game).toBeDefined();
    expect(randomizedGame).toBeDefined();
  });

  it("runs whole game", function () {
    function constantRandom() {
      return 0;
    }

    randomizedGame(constantRandom);

    this.verify(gameConsoleOutput, approvalConfig);
  });

});
