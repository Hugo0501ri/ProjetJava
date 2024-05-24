public interface LanguageExecutor {
    void compile(String filePath) throws IOException, InterruptedException;
    void execute(String filePath) throws IOException, InterruptedException;
}