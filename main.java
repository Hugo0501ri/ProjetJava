import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Choix de l'exercice
        System.out.println("Choisissez l'exercice :");
        System.out.println("1. Exercice 1");
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
        StringBuilder code = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            code.append(line).append("\n");
        }

        // Exécution de l'exercice
        ExerciseRunner.runExercise(exerciseChoice, languageChoice, code.toString());

        scanner.close();

        if (pythonCode.length() > 0) {
            // Nom du fichier dans lequel le code sera enregistré ou modifié
            String fileName = "exo1_utilisateur.py";
            
            // Utiliser FileModifier pour écrire ou ajouter le code dans le fichier
            FileModifier.writeToFile(fileName, pythonCode.toString());
        } else {
            System.out.println("Aucun code Python saisi.");
        }
        String[] fileNames = {"Exercices/Exo1/exo1_utilisateur.py"}; // Remplacez "exo1.py" par le nom de votre fichier Python
        CodeRunner.runCodeFromFiles(fileNames);
    }

}
