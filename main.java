import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder pythonCode = new StringBuilder(); // Déclaration de pythonCode

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

        // Récupération du code saisi par l'utilisateur
        System.out.println("Veuillez saisir votre code (appuyez sur Entrée pour terminer la saisie) :");
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            pythonCode.append(line).append("\n"); // Ajout des lignes de code à pythonCode
        }

        // Exécution de l'exercice
        ExerciseRunner.runExercise(exerciseChoice, languageChoice, pythonCode.toString());

        scanner.close();
    }
}
