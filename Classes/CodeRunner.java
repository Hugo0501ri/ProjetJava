package Classes;


import java.io.File;
import java.io.IOException;

/**
 * Responsible for running code from files.
 */

public class CodeRunner {
    
    /**
     * Runs code from multiple files.
     *
     * @param filePaths The paths of the files containing the code to run.
     * @throws IOException If an I/O error occurs.
     */

    public static void runCodeFromFiles(String[] filePaths) {
        for (String filePath : filePaths) {
            runCodeFromFile(filePath);
        }
    }

    /**
     * Runs code from a single file.
     *
     * @param filePath The path of the file containing the code to run.
     * @throws IOException If an I/O error occurs.
     */

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

    
    /**
     * Gets the appropriate executor based on the file extension.
     *
     * @param fileExtension The file extension of the code file.
     * @return The language executor for the specified file extension.
     */

    private static LanguageExecutor getExecutor(String fileExtension) {
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
    }
    
}


