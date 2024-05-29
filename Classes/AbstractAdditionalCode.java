package Classes;

public abstract class AbstractAdditionalCode implements AdditionalCodeInterface{
    public String getAdditionalCode(int exerciseChoice, int languageChoice){
    switch (languageChoice) {
        case 1:
            return generatePythonCode(exerciseChoice);
        case 2:
            return generateJavaCode(exerciseChoice);
        case 3:
            return generateJavaScriptCode(exerciseChoice);
        case 4:
            return generatePHPCode(exerciseChoice);
        case 5:
            return generateCCode(exerciseChoice);
        default:
            return "";
    }
}

    protected abstract String generatePythonCode(int exerciseChoice);
    protected abstract String generateJavaCode(int exerciseChoice);
    protected abstract String generateJavaScriptCode(int exerciseChoice);
    protected abstract String generatePHPCode(int exerciseChoice);
    protected abstract String generateCCode(int exerciseChoice);

}