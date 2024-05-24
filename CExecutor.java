public class CExecutor extends AbstractLanguageExecutor {
    @Override
    public void compile(String cFilePath) throws IOException, InterruptedException {
        ProcessBuilder compileProcessBuilder = new ProcessBuilder("gcc", cFilePath, "-o", "program");
        Process compileProcess = compileProcessBuilder.start();
        printProcessOutput(compileProcess);
    }

    @Override
    public void execute(String cFilePath) throws IOException, InterruptedException {
        ProcessBuilder executeProcessBuilder = new ProcessBuilder("./program");
        Process executeProcess = executeProcessBuilder.start();
        printProcessOutput(executeProcess);
    }
}
