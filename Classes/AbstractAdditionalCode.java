package Classes;

/**
 * Abstract class that provides additional code snippets based on exercise and language choices.
 */

public abstract class AbstractAdditionalCode implements AdditionalCodeInterface{

      /**
     * Returns additional code based on the given exercise and language choices.
     *
     * @param exerciseChoice The choice of exercise for which additional code is needed.
     * @param languageChoice The choice of programming language:
     *                       1 for Python,
     *                       2 for Java,
     *                       3 for JavaScript,
     *                       4 for PHP,
     *                       5 for C.
     * @return A string containing the additional code for the specified exercise and language.
     *         Returns an empty string if the language choice is not recognized.
     */

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

 /**
     * Generates additional Python code for the specified exercise choice.
     *
     * @param exerciseChoice The choice of exercise.
     * @return A string containing the additional Python code.
     */

    protected abstract String generatePythonCode(int exerciseChoice);

        /**
     * Generates additional Java code for the specified exercise choice.
     *
     * @param exerciseChoice The choice of exercise.
     * @return A string containing the additional Java code.
     */

    protected abstract String generateJavaCode(int exerciseChoice);

     /**
     * Generates additional JavaScript code for the specified exercise choice.
     *
     * @param exerciseChoice The choice of exercise.
     * @return A string containing the additional JavaScript code.
     */

    protected abstract String generateJavaScriptCode(int exerciseChoice);

     /**
     * Generates additional PHP code for the specified exercise choice.
     *
     * @param exerciseChoice The choice of exercise.
     * @return A string containing the additional PHP code.
     */

    protected abstract String generatePHPCode(int exerciseChoice);

/**
     * Generates additional C code for the specified exercise choice.
     *
     * @param exerciseChoice The choice of exercise.
     * @return A string containing the additional C code.
     */

    protected abstract String generateCCode(int exerciseChoice);

}