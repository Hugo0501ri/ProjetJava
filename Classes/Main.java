package Classes;

import java.io.IOException;
import java.util.Scanner;




public class Main {


public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    StringBuilder userCode = new StringBuilder();

    // Choix de l'exercice
    System.out.println("Choisissez l'exercice :");
    System.out.println("1. Exercice 1");
    System.out.println("2. Exercice 2");

    int exerciseChoice = scanner.nextInt();
    scanner.nextLine(); // Pour consommer la nouvelle ligne restante

    // Choix du langage
    System.out.println("Choisissez le langage :");
    System.out.println("1. Python");
    System.out.println("2. Java");
    System.out.println("3. JavaScript");
    System.out.println("4. PHP");
    System.out.println("5. C");

    int languageChoice = scanner.nextInt();
    scanner.nextLine(); // Pour consommer la nouvelle ligne restante

    // Récupération du code saisi par l'utilisateur
    System.out.println("Veuillez saisir votre code (appuyez sur Entrée pour terminer la saisie) :");
    while (true) {
        String line = scanner.nextLine();
        if (line.isEmpty()) {
            break;
        }
        userCode.append(line).append("\n");
    }

    // Création de l'instance ExerciseRunnerInterface en fonction du choix de langage
    ExerciseRunnerInterface runner = ExerciseRunner.getRunner(languageChoice);
    if (runner == null) {
        System.out.println("Langage non pris en charge.");
        return;
    }

    // Extraction de la fonction à partir du code utilisateur
    String userFunction = ExerciseRunner.extractFunction(userCode.toString(), languageChoice);
    int userOutput = ExerciseRunner.callFunction(userFunction, inputs, languageChoice);

    // Lecture du code original
    String originalCodePath = ExerciseRunner.getOriginalFilePath(exerciseChoice, languageChoice);
    String originalCode = FileModifier.readFileAsString(originalCodePath);

    // Comparaison des sorties des fonctions avec des valeurs aléatoires
    boolean isCorrect = ExerciseRunner.runAndCompare(exerciseChoice, languageChoice, userFunction, originalCode);

    if (isCorrect) {
        System.out.println("Félicitations! Votre code est correct.");
    } else {
        System.out.println("Votre code est incorrect. Veuillez réessayer.");
    }

    scanner.close();
}



             // Demander à l'utilisateur s'il souhaite réessayer ou quitter
         /*   System.out.println("Voulez-vous réessayer ou quitter ? (r/q)");
            String userResponse = scanner.nextLine();
            if (userResponse.equalsIgnoreCase("q")) {
                break; // Quitter la boucle et terminer le programme
            }
        }

        scanner.close();
    }*/

}