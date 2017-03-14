'use strict';

// hack, using internals of approvals.
var autils = require('../../../node_modules/approvals/lib/AUtils');
var GenericDiffReporterBase = require('../../../node_modules/approvals/lib/Reporting/GenericDiffReporterBase');

var KDiff3Reporter = function () {
  this.name = "KDiff3";
  this.exePath = autils.searchForExecutable("KDiff3", "kdiff3.exe");
};

KDiff3Reporter.prototype = new GenericDiffReporterBase();

module.exports = KDiff3Reporter;
