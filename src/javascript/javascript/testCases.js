const testCases = [
    { input: [/* valeurs d'entrée */], expected: /* valeur attendue */ },
    // Ajoutez d'autres cas de test ici
  ];
  
  function runTestCases(userFunction) {
    return testCases.map(({ input, expected }) => {
      try {
        const result = userFunction(...input);
        return result === expected ? 'Passé' : `Échoué (Attendu: ${expected}, Reçu: ${result})`;
      } catch (error) {
        return `Erreur: ${error.message}`;
      }
    });
  }
  