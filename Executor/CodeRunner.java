

import java.io.File;
import java.io.IOException;


public class CodeRunner {
    
    /*public static void runCodeFromFiles(String[] filePaths) {
        for (String filePath : filePaths) {
            runCodeFromFile(filePath);
        }
    }

    public static void runCodeFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("Le fichier n'existe pas : " + filePath);
            return;
        }

        String fileName = file.getName();
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

        switch (fileExtension) {
            case "c":
                runCCode(filePath);
                break;
            case "class":
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
        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }
    }

    public static void runJavaCode(String javaClassFilePath) {
        try {
            // Supposons que le fichier soit un fichier .class compilé
            String className = javaClassFilePath.replace(".class", "");
            ProcessBuilder processBuilder = new ProcessBuilder("java", className);
            Process process = processBuilder.start();
            printProcessOutput(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runPythonCode(String pythonFilePath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("py", pythonFilePath);
            Process process = processBuilder.start();
            printProcessOutput(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runJavaScriptCode(String jsFilePath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("node", jsFilePath);
            Process process = processBuilder.start();
            printProcessOutput(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runPHPCode(String phpFilePath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("php", phpFilePath);
            Process process = processBuilder.start();
            printProcessOutput(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
    */

    public static void runCodeFromFiles(String[] filePaths) {
        for (String filePath : filePaths) {
            runCodeFromFile(filePath);
        }
    }

    public static void runCodeFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("Le fichier n'existe pas : " + filePath);
            return;
        }

        String fileName = file.getName();
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
        LanguageExecutor executor = getExecutor(fileExtension);

        if (executor == null) {
            System.err.println("Format de fichier non pris en charge : " + fileExtension);
            return;
        }

        try {
            executor.compile(filePath);
            executor.execute(filePath);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*private static LanguageExecutor getExecutor(String fileExtension) {
        switch (fileExtension) {
            case "c":
                return new CExecutor();
            case "java":
                return new JavaExecutor();
            case "py":
                return new PythonExecutor();
            case "js":
                return new JavaScriptExecutor();
            case "php":
                return new PHPExecutor();
            default:
                return null;
        }
    }*/
    private static LanguageExecutor getExecutor(String fileName) {
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
        switch (extension) {
            case "java":
                return new JavaExecutor();
            case "py":
                return new PythonExecutor();
            case "js":
                return new JavaScriptExecutor();
            case "php":
                return new PHPExecutor();
            case "c":
                return new CExecutor();
            default:
                return null;
    }
}
}

