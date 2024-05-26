package Classes;

import java.io.IOException;
import java.util.Scanner;

import javax.script.ScriptException;



    
    public class Main {
    
          /**
     * The main method that runs the application.
     * This method initializes the application, processes user-submitted code,
     * integrates it with provided exercise templates, executes the combined code,
     * and compares the output with expected results.
     *
     * @param args Command-line arguments.
     * @throws IOException If an I/O error occurs during file operations.
     * @throws ScriptException If an error occurs while executing scripts.
     * @throws InterruptedException If the thread is interrupted while waiting for processes to complete.
     */
        public static void main(String[] args) throws IOException, ScriptException, InterruptedException {
            Scanner scanner = new Scanner(System.in);
            StringBuilder userCode = new StringBuilder();
    
            // Choice of exercise
            System.out.println("Choisissez l'exercice :");
            System.out.println("1. Exercice 1");
            System.out.println("2. Exercice 2");
    
            int exerciseChoice = scanner.nextInt();
            scanner.nextLine(); // To consume the remaining new line
    
            // Choice of language
            System.out.println("Choisissez le langage :");
            System.out.println("1. Python");
            System.out.println("2. Java");
            System.out.println("3. JavaScript");
            System.out.println("4. PHP");
            System.out.println("5. C");
    
            int languageChoice = scanner.nextInt();
            scanner.nextLine(); // To consume the remaining new line
    
            // Retrieve code entered by user
            System.out.println("Veuillez saisir votre code (appuyez sur Entrée pour terminer la saisie) :");
            while (true) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                userCode.append(line).append("\n");
            }
            //Create ExerciseRunnerInterface instance according to language choice
            ExerciseRunnerInterface runner = ExerciseRunner.getRunner(languageChoice);
            if (runner == null) {
                System.out.println("Langage non pris en charge.");
                return;
            }
    
            // Extract function from user code
            String userFunction = ExerciseRunner.extractFunction(userCode.toString(), languageChoice);
            int userOutput = ExerciseRunner.callFunction(userFunction, new int[]{}, languageChoice);
    
             // Read original code
            String originalCodePath = ExerciseRunner.getOriginalFilePath(exerciseChoice, languageChoice);
            String originalCode = FileModifier.readFileAsString(originalCodePath);
    
            // Comparison of function outputs with random values
            boolean isCorrect = ExerciseRunner.runAndCompare(exerciseChoice, languageChoice, userFunction, originalCode);
    
            if (isCorrect) {
                System.out.println("Félicitations! Votre code est correct.");
            } else {
                System.out.println("Votre code est incorrect. Veuillez réessayer.");
            }
    
            scanner.close();
        }
    }


