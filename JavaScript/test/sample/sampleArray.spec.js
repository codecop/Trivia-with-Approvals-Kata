'use strict';

require('approvals').jasmine();
var KDiff3Reporter = require('../approvals/Reporters/kdiff3Reporter.js');

describe("sample array", function() {

  var approvalConfig = { reporters: [ new KDiff3Reporter(), "DoNothing" ] };

  it("testList", function() {
    var names = [ "Llewellyn", "James", "Dan", "Jason", "Katrina" ];
    names = names.sort();
    this.verifyAsJSON(names, approvalConfig);
  });

});
