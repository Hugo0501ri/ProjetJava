import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir votre code Python (appuyez sur Entrée pour terminer la saisie) :");
        StringBuilder pythonCode = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            pythonCode.append(line).append("\n");
        }
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
