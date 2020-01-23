# Ugly Trivia with Approvals Kata JavaScript Setup

This is a [npm](https://www.npmjs.com/) project. Run `npm test` or `jasmine-node .` to
run your tests.

* See [Trivia code base](https://github.com/caradojo/trivia).
* Create unit tests with [Jasmine 1.3.1](https://jasmine.github.io/1.3/introduction).
  * Uses `jasmine-node` plugin from https://github.com/mhevery/jasmine-node.
  * Any test source matching the pattern `*.spec.js` will be executed.
  * `jasmine-node` uses jasmine 1.3.1 internally.
* See [ApprovalTests for Node.js](https://github.com/approvals/Approvals.NodeJS).
  * Needs to be version 1.3.0 to have support for Jasmine 1.3.

## Check your Coverage

To measure your progress you should use code coverage tools:

* [Istanbul](https://istanbul.js.org/) - run `coverage.bat` or `./coverage.sh`.
