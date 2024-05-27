package Classes;

import java.util.*;

public class ExerciseInputConfig {
    public List<String[]> getInputsForExercise(int exerciseChoice) {
        List<String[]> inputs = new ArrayList<>();

        switch (exerciseChoice) {
            case 1:
                // Générer les entrées pour l'exercice 1 (par exemple, deux nombres aléatoires)
                for (int i = 0; i < 10; i++) {
                    String[] input = {String.valueOf(Math.random() * 100), String.valueOf(Math.random() * 100)};
                    inputs.add(input);
                }
                break;
            case 2:
                // Générer les entrées pour l'exercice 2 (par exemple, un nombre aléatoire)
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
    
