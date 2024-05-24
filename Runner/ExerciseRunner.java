package Runner;

public class ExerciseRunner {
    /*public static void runExercise(int exerciseChoice, int languageChoice, String code) {
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
                FileModifier.writeToFile(fileName, code,1, languageChoice);
                fileNames = new String[]{"Exercices/ExoPython/Exo1PY/exo1_utilisateur.py"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 2:
                // Java
                fileName = "exo1_utilisateur.java";
                FileModifier.writeToFile(fileName, code,1,languageChoice);
                fileNames = new String[]{"Exercices/ExoJava/Exo1Java/exo1_utilisateur.java"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 3:
                // Javascript
                fileName = "exo1_utilisateur.js";
                FileModifier.writeToFile(fileName, code,1,languageChoice);
                fileNames = new String[]{"Exercices/ExoJs/Exo1JS/exo1_utilisateur.js"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 4:
                // PHP
                fileName = "exo1_utilisateur.php";
                FileModifier.writeToFile(fileName, code,1,languageChoice);
                fileNames = new String[]{"Exercices/ExoPHP/Exo1PHP/exo1_utilisateur.php"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 5:
                // C
                fileName = "exo1_utilisateur.c";
                FileModifier.writeToFile(fileName, code,1,languageChoice);
                fileNames = new String[]{"Exercices/ExoC/Exo1C/exo1_utilisateur.c"};
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
                FileModifier.writeToFile(fileName, code,2,languageChoice);
                fileNames = new String[]{"Exercices/ExoPython/Exo2PY/exo2_utilisateur.py"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 2:
                // Java
                fileName = "exo2_utilisateur.java";
                FileModifier.writeToFile(fileName, code,2,languageChoice);
                fileNames = new String[]{"Exercices/ExoJava/Exo2Java/exo2_utilisateur.java"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 3:
                // Javascript
                fileName = "exo2_utilisateur.js";
                FileModifier.writeToFile(fileName, code,2,languageChoice);
                fileNames = new String[]{"Exercices/ExoJs/Exo2JS/exo2_utilisateur.js"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 4:
                // PHP
                fileName = "exo2_utilisateur.php";
                FileModifier.writeToFile(fileName, code,2,languageChoice);
                fileNames = new String[]{"Exercices/ExoPHP/Exo2PHP/exo2_utilisateur.php"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            case 5:
                // C
                fileName = "exo2_utilisateur.c";
                FileModifier.writeToFile(fileName, code,2,languageChoice);
                fileNames = new String[]{"Exercices/ExoC/Exo2C/exo2_utilisateur.c"};
                CodeRunner.runCodeFromFiles(fileNames);
                break;
            default:
                System.out.println("Langage non pris en charge.");
        }
    }*/
    public static void runExercise(int exerciseChoice, int languageChoice, String code) {
        ExerciseRunnerInterface runner = getRunner(languageChoice);
        if (runner == null) {
            System.out.println("Langage non pris en charge.");
            return;
        }

        String fileName = runner.getFileName(exerciseChoice);
        runner.compile(fileName, code);
        String[] fileNames = runner.getFilePaths(exerciseChoice);
        runner.execute(fileNames);
        
    }

    private static ExerciseRunnerInterface getRunner(int languageChoice) {
        switch (languageChoice) {
            case 1:
                return new PythonExerciseRunner();
            case 2:
                return new JavaExerciseRunner();
            case 3:
                return new JavaScriptExerciseRunner();
            case 4:
                return new PHPExerciseRunner();
            case 5:
                return new CExerciseRunner();
            default:
                System.out.println("Langage non pris en charge");
                return null;
        }
    }
}