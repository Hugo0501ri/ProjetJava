package Classes;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            StringBuilder userCode = new StringBuilder();

            System.out.println("Choisissez l'exercice :");
            System.out.println("1. Exercice 1");
            System.out.println("2. Exercice 2");

            int exerciseChoice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Choisissez le langage :");
            System.out.println("1. Python");
            System.out.println("2. Java");
            System.out.println("3. JavaScript");
            System.out.println("4. PHP");
            System.out.println("5. C");

            int languageChoice = scanner.nextInt();
            scanner.nextLine();

            String dataFilePath = ReadFile.getFilePath(exerciseChoice, languageChoice, "data");
            ReadFile.readFileData(dataFilePath);

            System.out.println("Veuillez saisir votre code (appuyez sur Entrée pour terminer la saisie) :");
            while (true) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                userCode.append(line).append("\n");
            }

            ExerciseRunnerInterface runner = ExerciseRunner.getRunner(languageChoice);
            if (runner == null) {
                System.out.println("Langage non pris en charge.");
                return;
            }

            // Obtention du chemin du fichier intégré
            String integratedFilePath = runner.getFileName(exerciseChoice);
            AdditionalCodeInterface codeGenerator = new AdditionalCode();
            String additionalCode = codeGenerator.getAdditionalCode(exerciseChoice,languageChoice);

            // Écriture du code utilisateur dans le fichier intégré
            FileModifier.writeCodeToFile(integratedFilePath, userCode.toString(), additionalCode);

            // Obtention du chemin du fichier original
            String originalFilePath = ExerciseRunner.getOriginalFilePath(exerciseChoice, languageChoice);

            // Compilation (si nécessaire) et exécution du code utilisateur
            boolean isCorrect = ExerciseRunner.compareOutputs(exerciseChoice, languageChoice, integratedFilePath, originalFilePath);

            if (isCorrect) {
                System.out.println("Félicitations! Votre code est correct.");
            } else {
                System.out.println("Votre code est incorrect. Veuillez réessayer.");
            }

            // Demander à l'utilisateur s'il souhaite réessayer ou quitter
            System.out.println("Voulez-vous réessayer ou quitter ? (r/q)");
            String userResponse = scanner.nextLine();
            if (userResponse.equalsIgnoreCase("q")) {
                break; // Quitter la boucle et terminer le programme
            }
        }

        scanner.close();
    }

}
