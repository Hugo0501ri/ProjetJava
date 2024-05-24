package Classes;



public class ExerciseRunner {
   
    public static void runExercise(int exerciseChoice, int languageChoice, String code) {
        ExerciseRunnerInterface runner = getRunner(languageChoice);
        if (runner == null) {
            System.out.println("Langage non pris en charge.");
            return;
        }

        String fileName = runner.getFileName(exerciseChoice);
        runner.compile(fileName, code);
        String[] fileNames = runner.getFilePaths(exerciseChoice);
        runner.execute(fileNames);
        
    }

    private static ExerciseRunnerInterface getRunner(int languageChoice) {
        switch (languageChoice) {
            case 1:
                return new PythonExerciseRunner();
            case 2:
                return new JavaExerciseRunner();
            case 3:
                return new JavaScriptExerciseRunner();
            case 4:
                return new PHPExerciseRunner();
            case 5:
                return new CExerciseRunner();
            default:
                System.out.println("Langage non pris en charge");
                return null;
        }
    }
}