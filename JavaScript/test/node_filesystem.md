var fs = require('fs');

fs.writeFile('test/random_always_1.log', gameConsoleOutput);

var reference = fs.readFileSync('test/random_always_1.log', 'UTF-8');
expect(gameConsoleOutput).toEqual(reference);
