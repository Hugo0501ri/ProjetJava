public class ExerciseRunner {
    public static void runExercise(int exerciseChoice, int languageChoice, String code) {
        switch (exerciseChoice) {
            case 1:
                runExercise1(languageChoice, code);
                break;
            case 2:
                runExercise2(languageChoice, code);
                break;
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
                fileNames = new String[]{"Exercices/ExoPython/exo1_utilisateur.py"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 2:
                // Java
                fileName = "exo1_utilisateur.java";
                FileModifier.writeToFile(fileName, code);
                fileNames = new String[]{"Exercices/ExoJava/exo1_utilisateur.java"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 3:
                // Javascript
                fileName = "exo1_utilisateur.js";
                FileModifier.writeToFile(fileName, code);
                fileNames = new String[]{"Exercices/ExoJs/exo1_utilisateur.js"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 4:
                // PHP
                fileName = "exo1_utilisateur.php";
                FileModifier.writeToFile(fileName, code);
                fileNames = new String[]{"Exercices/ExoPHP/exo1_utilisateur.php"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 5:
                // C
                fileName = "exo1_utilisateur.c";
                FileModifier.writeToFile(fileName, code);
                fileNames = new String[]{"Exercices/ExoC/exo1_utilisateur.c"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            default:
                System.out.println("Langage non pris en charge.");
        }
    }

    private static void runExercise2(int languageChoice, String code) {
        String fileName;
        String[] fileNames;
        switch (languageChoice) {
            case 1:
                // Python
                fileName = "exo2_utilisateur.py";
                FileModifier.writeToFile(fileName, code);
                fileNames = new String[]{"Exercices/ExoPython/exo2_utilisateur.py"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 2:
                // Java
                fileName = "exo2_utilisateur.java";
                FileModifier.writeToFile(fileName, code);
                fileNames = new String[]{"Exercices/ExoJava/exo2_utilisateur.java"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 3:
                // Javascript
                fileName = "exo2_utilisateur.js";
                FileModifier.writeToFile(fileName, code);
                fileNames = new String[]{"Exercices/ExoJs/exo2_utilisateur.js"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 4:
                // PHP
                fileName = "exo2_utilisateur.php";
                FileModifier.writeToFile(fileName, code);
                fileNames = new String[]{"Exercices/ExoPHP/exo2_utilisateur.php"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 5:
                // C
                fileName = "exo2_utilisateur.c";
                FileModifier.writeToFile(fileName, code);
                fileNames = new String[]{"Exercices/ExoC/exo2_utilisateur.c"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            default:
                System.out.println("Langage non pris en charge.");
        }
    }
}
