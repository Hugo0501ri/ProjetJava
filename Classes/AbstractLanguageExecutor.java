package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Abstract base class for language executors.
 */

public abstract class AbstractLanguageExecutor implements LanguageExecutor {

 /**
     * Prints the output of the specified process.
     *
     * @param process The process whose output to print.
     * @throws IOException If an I/O error occurs.
     * @throws InterruptedException If the thread is interrupted while waiting for the process to complete.
     */

    protected void printProcessOutput(Process process) throws IOException, InterruptedException {
        try (BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
             BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String line;

            // Read and display the output
            while ((line = outputReader.readLine()) != null) {
                System.out.println(line);
            }

            // Read and display errors
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

            process.waitFor();
        }
    }
}
