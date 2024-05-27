package Exercices.ExoJava.Exo2Java;

public class Exo2 {
    // Fonction de calcul de la factorielle
    public static int factorielle(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorielle(n - 1);
        }
    }
}
