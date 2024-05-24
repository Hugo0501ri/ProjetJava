import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Choix de l'exercice
        System.out.println("Choisissez l'exercice :");
        System.out.println("1. Exercice 1");
        System.out.println("2. Exercice 2");

        int exerciseNumber = scanner.nextInt();
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

        while (true) {
            StringBuilder userCode = new StringBuilder();

            // Récupération du code saisi par l'utilisateur
            System.out.println("Veuillez saisir votre code (appuyez sur Entrée pour terminer la saisie) :");
            while (true) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                userCode.append(line).append("\n"); // Ajout des lignes de code à userCode
            }

            // Exécution de l'exercice
            ExerciseRunner.runExercise(exerciseNumber, languageChoice, userCode.toString());
            

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
