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
            // Générer un nom de fichier unique (par exemple, basé sur l'horodatage)
            String fileName = "code_" + System.currentTimeMillis() + ".py";
            
            // Utiliser FileModifier pour écrire le code dans un fichier
            FileModifier.writeToFile(fileName, pythonCode.toString());
        } else {
            System.out.println("Aucun code Python saisi.");
        }
    }
}
