public class ExerciseRunner {
    public static void runExercise(int exerciseChoice, int languageChoice, String code) {
        switch (exerciseChoice) {
            case 1:
                runExercise1(languageChoice, code);
                break;
            // Ajoutez d'autres cas pour d'autres exercices
            default:
                System.out.println("Exercice non pris en charge.");
        }
    }

    private static void runExercise1(int languageChoice, String code) {
        String fileName;
        String[] fileNames;
        switch (languageChoice) {
            case 1:
                // Python
                fileName = "exo1_utilisateur.py";
                FileModifier.writeToFile(fileName, code);
                fileNames = new String[]{"Exercices/Exo1/exo1_utilisateur.py"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 2:
                // Java
                // Ajoutez le code pour exécuter l'exercice 1 en Java
                break;
            case 3:
                // JavaScript
                // Ajoutez le code pour exécuter l'exercice 1 en JavaScript
                break;
            case 4:
                // PHP
                // Ajoutez le code pour exécuter l'exercice 1 en PHP
                break;
            case 5:
                // C
                // Ajoutez le code pour exécuter l'exercice 1 en C
                break;
            default:
                System.out.println("Langage non pris en charge.");
        }
    }
}
