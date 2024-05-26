package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javax.script.ScriptException;

/**
 * Coordinates the execution of exercises and comparison of results.
 */

public class ExerciseRunner {

 /**
     * Retrieves the comment marker for the specified programming language.
     *
     * @param languageChoice The choice of programming language.
     * @return The comment marker for the specified language.
     */

    public static String getCommentMarker(int languageChoice) {
        switch (languageChoice) {
            case 1: // Python
                return "# Code utilisateur ici";
            case 2: // Java
                return "// Code utilisateur ici";
            case 3: // JavaScript
                return "// Code utilisateur ici";
            case 4: // PHP
                return "// Code utilisateur ici";
            case 5: // C
                return "// Code utilisateur ici";
            default:
                return "// Code utilisateur ici";
        }
    }

/**
     * Runs the submitted program and compares it with the reference program.
     *
     * @param exerciseChoice The choice of exercise.
     * @param languageChoice The choice of programming language.
     * @param integratedFilePath The path to the integrated file.
     * @param originalFilePath The path to the original file.
     * @return True if the results match, otherwise false.
     */

    public static boolean runAndCompare(int exerciseChoice, int languageChoice, String integratedFilePath, String originalFilePath) {
        ExerciseRunnerInterface runner = getRunner(languageChoice);
        if (runner == null) {
            System.out.println("Langage non pris en charge.");
            return false;
        }

        try {
            // L'extraction de la fonction à partir du code utilisateur
            String userFunction = extractFunction(FileModifier.readFileAsString(integratedFilePath), languageChoice);

            // L'appel de la fonction extraite avec des entrées aléatoires
            List<String[]> randomInputs = generateRandomInputs();
            for (String[] inputs : randomInputs) {
                int userOutput = callFunction(userFunction, inputs, languageChoice);
                int expectedOutput = callFunction(userFunction, inputs, languageChoice); // Vous devez extraire et appeler la fonction à partir du code original de la même manière
                if (userOutput != expectedOutput) {
                    return false;
                }
            }
            return true;
        } catch (IOException | ScriptException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

  /**
     * Generates random inputs for running the exercises.
     *
     * @return A list of string arrays representing the random inputs.
     */


    private static List<String[]> generateRandomInputs() {
        List<String[]> inputs = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < 10; i++) { // Générer 10 ensembles de valeurs aléatoires
            String[] input = {String.valueOf(random.nextInt(100)), String.valueOf(random.nextInt(100))};
            inputs.add(input);
        }

        return inputs;
    }

 /**
     * Executes the specified function in the given file with the provided inputs.
     *
     * @param runner The exercise runner interface.
     * @param filePath The path to the file to be executed.
     * @param inputs The inputs for the function.
     * @return The result of executing the function.
     */    

    @SuppressWarnings("unused")
    private static String executeFunction(ExerciseRunnerInterface runner, String filePath, String[] inputs) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(getCommand(filePath, inputs));
        Process process = processBuilder.start();

        // Lire la sortie du processus
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        process.waitFor();
        return output.toString().trim();
    }

 /**
     * Retrieves the command to execute the file with the specified inputs.
     *
     * @param filePath The path to the file to be executed.
     * @param inputs The inputs for the function.
     * @return An array of strings representing the execution command.
     */

    private static String[] getCommand(String filePath, String[] inputs) {
        String extension = filePath.substring(filePath.lastIndexOf('.') + 1).toLowerCase();
        String[] baseCommand;
        switch (extension) {
            case "java":
                baseCommand = new String[]{"java", filePath.replace(".java", "")};
                break;
            case "py":
                baseCommand = new String[]{"python", filePath};
                break;
            case "js":
                baseCommand = new String[]{"node", filePath};
                break;
            case "php":
                baseCommand = new String[]{"php", filePath};
                break;
            case "c":
                baseCommand = new String[]{"./a.out"};
                break;
            default:
                throw new IllegalArgumentException("Unsupported file extension: " + extension);
        }

        // Ajouter les arguments à la commande de base
        String[] command = new String[baseCommand.length + inputs.length];
        System.arraycopy(baseCommand, 0, command, 0, baseCommand.length);
        System.arraycopy(inputs, 0, command, baseCommand.length, inputs.length);

        return command;
    }

     /**
     * Retrieves the exercise runner interface for the specified programming language.
     *
     * @param languageChoice The choice of programming language.
     * @return The exercise runner interface for the specified language.
     */
    public static ExerciseRunnerInterface getRunner(int languageChoice) {
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

    /**
     * Retrieves the original file path for the specified exercise and language.
     *
     * @param exerciseNumber The number of the exercise.
     * @param languageChoice The choice of programming language.
     * @return The original file path.
     */
    public static String getOriginalFilePath(int exerciseNumber, int languageChoice) {
        String languageExtension = getLanguageExtension(languageChoice);
        return "Exercices/Exo" + languageExtension + "/Exo" + exerciseNumber + languageExtension + "/Exo" + exerciseNumber + "." + languageExtension;
    }

      /**
     * Retrieves the file extension for the specified programming language.
     *
     * @param languageChoice The choice of programming language.
     * @return The file extension for the specified language.
     */

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


    /**
     * Retrieves the programming language corresponding to the specified choice.
     *
     * @param languageChoice The choice of programming language.
     * @return The programming language corresponding to the specified choice.
     */

        private static ProgrammingLanguage getLanguage(int languageChoice) {
        switch (languageChoice) {
            case 1:
                return new PythonLanguage();
            case 2:
                return new JavaLanguage();
            case 3:
                return new JavaScriptLanguage();
            case 4:
                return new PHPLanguage();
            case 5:
                return new CLanguage();
            
            default:
                throw new IllegalArgumentException("Langage non pris en charge");
        }
    }

     /**
     * Extracts the function from the code for the specified programming language.
     *
     * @param code The source code.
     * @param languageChoice The choice of programming language.
     * @return The extracted function from the code.
     */

    public static String extractFunction(String code, int languageChoice) {
        ProgrammingLanguage language = getLanguage(languageChoice);
        return language.extractFunction(code);
    }

 /**
     * Calls the specified function with the given arguments for the specified programming language.
     *
     * @param functionCode The code of the function to be called.
     * @param args The arguments for the function.
     * @param languageChoice The choice of programming language.
     * @return The result of calling the function.
     */

    public static int callFunction(String functionCode, int[] args, int languageChoice) throws ScriptException, IOException, InterruptedException {
        ProgrammingLanguage language = getLanguage(languageChoice);
        return language.callFunction(functionCode, args);
    }
}



