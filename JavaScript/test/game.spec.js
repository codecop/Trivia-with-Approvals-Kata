/* globals describe, it, expect, beforeEach, afterEach, Game, randomizedGame */
'use strict';
require('../src/game.js');

describe("The test environment", function() {
  it("should pass", function() {
    expect(true).toBe(true);
  });

  it("should access game", function() {
    expect(Game).toBeDefined();
  });
});

describe("Your specs...", function() {
  // it ...
});
