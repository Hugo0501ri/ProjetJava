package Classes;

import java.io.IOException;

import javax.script.ScriptException;

public abstract class ProgrammingLanguage {
    public abstract String extractFunction(String userCode);
    public abstract int callFunction(String functionCode, int... args) throws ScriptException, IOException, InterruptedException;
}