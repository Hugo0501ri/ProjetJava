package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javax.script.ScriptException;

public class ExerciseRunner {

    public static boolean compareOutputs(int exerciseChoice, int languageChoice, String userFilePath, String originalFilePath) {
        ExerciseRunnerInterface runner = getRunner(languageChoice);
        if (runner == null) {
            System.out.println("Langage non pris en charge.");
            return false;
        }
    
        try {
            // Exécution des programmes avec les entrées aléatoires et comparaison des sorties
            ExerciseInputConfig inputConfig = new ExerciseInputConfig();
            List<String[]> inputs = inputConfig.getInputsForExercise(exerciseChoice);
    
            for (int i = 0; i < inputs.size(); i++) {
                String[] inputsArray = inputs.get(i);
                // Exécution du code utilisateur
                Object userOutputObject = runner.executeWithInputs(userFilePath, inputsArray);
                // Exécution du code original
                Object originalOutputObject = runner.executeWithInputs(originalFilePath, inputsArray);
                
                // Conversion des sorties en chaînes de caractères pour l'enregistrement dans les fichiers
                String userOutput = userOutputObject != null ? userOutputObject.toString() : "";
                String originalOutput = originalOutputObject != null ? originalOutputObject.toString() : "";
    
                // Vérification des sorties dans la console (à des fins de débogage)
                System.out.println("Sortie utilisateur pour l'entrée " + i + ": " + userOutput);
                System.out.println("Sortie originale pour l'entrée " + i + ": " + originalOutput);
    
                // Comparaison des sorties
                if (!userOutput.equals(originalOutput)) {
                    return false;
                }
    
                // Enregistrer les sorties dans des fichiers
                FileModifier.writeToFile("user_output_" + i + ".txt", userOutput);
                FileModifier.writeToFile("expected_output_" + i + ".txt", originalOutput);
            }
    
            return true;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : Les entrées récupérées ne sont pas du type attendu (String[]).");
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    
    
    


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

        

    
    
    // Méthode utilitaire pour convertir un tableau de chaînes en un tableau d'entiers
    

}



