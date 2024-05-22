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
                fileName = "exo1_utilisateur.java";
                FileModifier.writeToFile(fileName, code);
                fileNames = new String[]{"Exercices/Exo1/exo1_utilisateur.java"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 3:
                fileName = "exo1_utilisateur.js";
                FileModifier.writeToFile(fileName, code);
                fileNames = new String[]{"Exercices/Exo1/exo1_utilisateur.js"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 4:
                fileName = "exo1_utilisateur.php";
                FileModifier.writeToFile(fileName, code);
                fileNames = new String[]{"Exercices/Exo1/exo1_utilisateur.php"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 5:
                fileName = "exo1_utilisateur.c";
                FileModifier.writeToFile(fileName, code);
                fileNames = new String[]{"Exercices/Exo1/exo1_utilisateur.c"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            default:
                System.out.println("Langage non pris en charge.");
        }
    }
}
