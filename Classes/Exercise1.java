package Classes;

import java.util.*;

public class Exercise1 implements Exercise {
    @Override
    public List<Object> generateInputs() {
        Random random = new Random();
        int num1 = random.nextInt(100); // Random value between 0 and 99
        int num2 = random.nextInt(100); // Random value between 0 and 99
        return Arrays.asList(num1, num2);
    }
}