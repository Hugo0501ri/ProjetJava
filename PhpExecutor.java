public class PHPExecutor extends AbstractLanguageExecutor {
    @Override
    public void compile(String phpFilePath) {
        // Pas de compilation nécessaire pour PHP
    }

    @Override
    public void execute(String phpFilePath) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("php", phpFilePath);
        Process process = processBuilder.start();
        printProcessOutput(process);
    }
}
