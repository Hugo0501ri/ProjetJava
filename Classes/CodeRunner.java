package Classes;


import java.io.File;
import java.io.IOException;


public class CodeRunner {
    
    /**
     * @param filePaths
     */
    public static void runCodeFromFiles(String[] filePaths) {
        for (String filePath : filePaths) {
            runCodeFromFile(filePath);
        }
    }

    /**
     * @param filePath
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
     * @param fileExtension
     * @return
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


