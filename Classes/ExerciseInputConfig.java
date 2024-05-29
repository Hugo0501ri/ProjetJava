package Classes;

import java.util.*;

/**
 * Class to generate input configurations for different exercises.
 */

public class ExerciseInputConfig {

    /**
     * Generates a list of input arrays for the specified exercise choice.
     *
     * @param exerciseChoice The choice of exercise for which inputs are to be generated.
     *                       Supported values:
     *                       - 1: Generates two random numbers as inputs.
     *                       - 2: Generates one random number as input.
     * @return A list of string arrays where each array represents a set of inputs for the exercise.
     *         If the exercise choice is not supported, returns an empty list.
     */
    
    public List<String[]> getInputsForExercise(int exerciseChoice) {
        List<String[]> inputs = new ArrayList<>();

        switch (exerciseChoice) {
            case 1:
                // Generate inputs for Exercise 1 (for example, two random numbers)
                for (int i = 0; i < 10; i++) {
                    String[] input = {String.valueOf(Math.random() * 100), String.valueOf(Math.random() * 100)};
                    inputs.add(input);
                }
                break;
            case 2:
                // Generate inputs for exercise 2 (e.g. a random number)
                for (int i = 0; i < 10; i++) {
                    String[] input = {String.valueOf(Math.random() * 100)};
                    inputs.add(input);
                }
                break;
            default:
                System.out.println("Exercice non pris en charge.");
                break;
        }

        return inputs;
    }
}
    
