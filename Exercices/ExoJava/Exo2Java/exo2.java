public class Exo2 {
    public static void exo2(String[] args) {
        int n = Integer.parseInt(args[0]);
        int result = factorielle(n);

        //exo2_utilisateur.factorielle(n);

        System.out.println("La factorielle de " + n + " est " + result);
    }

    public static int factorielle(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorielle(n - 1);
        }
    }
}
