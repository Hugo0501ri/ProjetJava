import java.io.*;

public class CodeRunner {
    // Exécution de code C
    public static void runCCode(String cFilePath) {
        try {
            // Compilation du fichier C
            ProcessBuilder compileProcessBuilder = new ProcessBuilder("gcc", cFilePath, "-o", "program");
            Process compileProcess = compileProcessBuilder.start();
            compileProcess.waitFor();

            // Exécution du fichier compilé
            ProcessBuilder executeProcessBuilder = new ProcessBuilder("./program");
            Process executeProcess = executeProcessBuilder.start();
            printProcessOutput(executeProcess);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Exécution de code Java
    public static void runJavaCode(String javaClassFilePath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", ".", javaClassFilePath);
            Process process = processBuilder.start();
            printProcessOutput(process);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Exécution de code Python
    public static void runPythonCode(String pythonFilePath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonFilePath);
            Process process = processBuilder.start();
            printProcessOutput(process);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Exécution de code JavaScript (Node.js)
    public static void runJavaScriptCode(String jsFilePath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("node", jsFilePath);
            Process process = processBuilder.start();
            printProcessOutput(process);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Exécution de code PHP
    public static void runPHPCode(String[] phpFilePath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("php", phpFilePath);
            Process process = processBuilder.start();
            printProcessOutput(process);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Méthode utilitaire pour afficher la sortie du processus
    private static void printProcessOutput(Process process) {
        try (BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
             BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String line;

            // Lire et afficher la sortie
            while ((line = outputReader.readLine()) != null) {
                System.out.println(line);
            }

            // Lire et afficher les erreurs
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void runCodeFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("Le fichier n'existe pas.");
            return;
        }

        String fileName = file.getName();
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

        switch (fileExtension) {
            case "c":
                runCCode(filePath);
                break;
            case "java":
                runJavaCode(filePath);
                break;
            case "py":
                runPythonCode(filePath);
                break;
            case "js":
                runJavaScriptCode(filePath);
                break;
            case "php":
                runPHPCode(filePath);
                break;
            default:
                System.err.println("Format de fichier non pris en charge : " + fileExtension);
        }
    }

    
}