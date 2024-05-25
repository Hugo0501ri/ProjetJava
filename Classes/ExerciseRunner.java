package Classes;


import java.io.IOException;


public class ExerciseRunner {
   
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

        try {
            // Sauvegarder la sortie utilisateur
            saveOutput(fileNames[0], "user_output.txt");
            
            // Exécuter l'exercice original
            String originalFilePath = getOriginalFilePath(exerciseChoice, languageChoice);
            runner.compile(originalFilePath, code);
            runner.execute(new String[]{originalFilePath});
            
            // Sauvegarder la sortie attendue
            saveOutput(originalFilePath, "expected_output.txt");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void saveOutput(String filePath, String outputFile) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(getCommand(filePath));
        Process process = processBuilder.start();
        FileModifier.saveOutput(process, outputFile);
    }
        
    
    private static String[] getCommand(String filePath) {
        String extension = filePath.substring(filePath.lastIndexOf('.') + 1).toLowerCase();
        switch (extension) {
            case "java":
                return new String[]{"java", filePath.replace(".java", "")};
            case "py":
                return new String[]{"py", filePath};
            case "js":
                return new String[]{"node", filePath};
            case "php":
                return new String[]{"php", filePath};
            case "c":
                return new String[]{"./a.out"};
            default:
                throw new IllegalArgumentException("Unsupported file extension: " + extension);
        }
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

    public static String getOriginalFilePath(int exerciseNumber, int languageChoice) {
        String languageExtension = getLanguageExtension(languageChoice);
        return "Exercices/Exo" + languageExtension + "/Exo" + exerciseNumber + languageExtension + "/Exo" + exerciseNumber + "." + languageExtension;
    }

    public static String getLanguageExtension(int languageChoice) {
        switch (languageChoice) {
            case 1:
                return "Py"; // Python
            case 2:
                return "Java"; // Java
            case 3:
                return "Js"; // JavaScript
            case 4:
                return "Php"; // PHP
            case 5:
                return "C"; // C
            default:
                return ""; // Par défaut
        }
    
}
}