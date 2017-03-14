require('approvals').jasmine();

describe("sample array", function() {

  it("testList", function() {
    var names = [ "Llewellyn", "James", "Dan", "Jason", "Katrina" ];
    names = names.sort();
    this.verifyAsJSON(names);
  });

});
