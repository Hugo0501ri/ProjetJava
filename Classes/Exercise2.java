package Classes;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Exercise2 implements Exercise{
    
    public List<Object> generateInputs() {
        Random random = new Random();
        int num = random.nextInt(10) + 1; // Valeur aléatoire entre 1 et 10
        return Collections.singletonList(num);
    }
}
