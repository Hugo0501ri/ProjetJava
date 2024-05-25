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
        // Ajoutez d'autres exercices au besoin

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

        // Création d'une instance de ExerciseRunner
        ExerciseRunner exerciseRunner = new ExerciseRunner();

        // Récupération du code saisi par l'utilisateur
        System.out.println("Veuillez saisir votre code (appuyez sur Entrée pour terminer la saisie) :");
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            userCode.append(line).append("\n");
        }

        // Intégration du code utilisateur dans le code original
        String originalCodePath = ExerciseRunner.getOriginalFilePath(exerciseChoice, languageChoice);
        String originalCode = FileModifier.readFileAsString(originalCodePath);

        String integratedCode = FileModifier.integrateUserCode(originalCode, userCode.toString(), "// Code utilisateur ici");
        String userFileName = "Exercice" + exerciseChoice + "_utilisateur.java";
        FileModifier.writeToFile(userFileName, integratedCode);

        // Exécution et comparaison des sorties
        ExerciseRunner.runExercise(exerciseChoice, languageChoice, integratedCode);

        // Afficher les résultats à l'utilisateur
        boolean isCorrect = FileModifier.compareOutputs("expected_output.txt", "user_output.txt");
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