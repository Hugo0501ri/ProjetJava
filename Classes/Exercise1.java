package Classes;

import java.util.*;

public class Exercise1 implements Exercise {
    @Override
    public List<Object> generateInputs() {
        Random random = new Random();
        int num1 = random.nextInt(100); // Valeur aléatoire entre 0 et 99
        int num2 = random.nextInt(100); // Valeur aléatoire entre 0 et 99
        return Arrays.asList(num1, num2);
    }
}