document.getElementById('runButton').addEventListener('click', function() {
    const code = document.getElementById('codeInput').value;
    const outputElement = document.getElementById('output');
  
    try {
      const result = eval(code);
      outputElement.textContent = `Résultat : ${result}`;
    } catch (error) {
      outputElement.textContent = `Erreur : ${error.message}`;
    }
  });
  
  // Assurez-vous que cette fonction est définie
// par exemple, dans un fichier `testCases.js`
// et importez le dans votre `index.html`

document.getElementById('runButton').addEventListener('click', function() {
    const code = document.getElementById('codeInput').value;
    const outputElement = document.getElementById('output');
  
    try {
      const userFunction = new Function('...args', code);
      const testResults = runTestCases(userFunction);
      outputElement.textContent = testResults.join('\n');
    } catch (error) {
      outputElement.textContent = `Erreur : ${error.message}`;
    }
  });
  