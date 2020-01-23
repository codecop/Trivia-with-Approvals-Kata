/* globals describe, it, expect, beforeEach, afterEach, Game, randomizedGame */
'use strict';

require('../src/game.js');
var chai = require('chai');
var expect = chai.expect;

describe("The test environment", function() {
  it("should pass", function() {
    expect(true).to.equal(true);
  });

  it("should access game", function() {
    expect(Game).to.exist;
  });
});

describe("Your specs...", function() {
  // it ...
});
